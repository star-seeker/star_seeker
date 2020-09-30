package com.imooc.interceptor;

import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisOperator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangyoubao
 * @version 2020/9/28
 */
public class UserTokenInterceptor implements HandlerInterceptor {

    public static final String REDIS_USER_TOKEN = "redis_user_token";

    @Autowired
    private RedisOperator redisOperator;

    /**
     * 拦截请求，在访问调用之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String userId = request.getHeader("headerUserId");
        String userToken = request.getHeader("headerUserToken");

        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(userToken)) {
            String uniqueToken = redisOperator.get(REDIS_USER_TOKEN + ":" + userId);
            if (StringUtils.isBlank(uniqueToken)) {
                returnErrorResponse(response, IMOOCJSONResult.errorMsg("请登录..."));
                return false;
            } else {
                if (!uniqueToken.equals(userToken)) {
                    returnErrorResponse(response, IMOOCJSONResult.errorMsg("账号异地登录..."));
                    return false;
                }
            }
        } else {
            returnErrorResponse(response, IMOOCJSONResult.errorMsg("请登录..."));
            return false;
        }

        /*
         * false: 请求被拦截，被驳回，验证出现问题
         * true: 请求经过验证以后是OK的
         */
        return true;
    }

    private void returnErrorResponse(HttpServletResponse response, IMOOCJSONResult result) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");

        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
