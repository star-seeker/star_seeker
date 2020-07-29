package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import javax.annotation.Resource;

import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhangyoubao
 * @version 2020/5/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    private static final String USER_FACE = "http://img.zcool.cn/community/012aa75c34615aa8012029ac4af0ed.jpg@2o.jpg";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExample = new Example(Users.class);
        Criteria useCriteria = userExample.createCriteria();
        useCriteria.andEqualTo("username", username);

        Users users = usersMapper.selectOneByExample(userExample);

        return users != null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

        Users users = new Users();
        users.setId(UUID.randomUUID().toString().replace("-", ""));
        users.setUsername(userBO.getUsername());
        users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));

        // 默认昵称同用户名
        users.setNickname(userBO.getUsername());
        // 默认头像
        users.setFace(USER_FACE);
        // 设置默认生日
        users.setBirthday(DateUtil.stringToDate("1900-01-01", "yyyy-MM-dd"));
        // 默认性别为保密
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        usersMapper.insert(users);
        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        Example userExample = new Example(Users.class);
        Criteria useCriteria = userExample.createCriteria();
        useCriteria.andEqualTo("username", username);
        useCriteria.andEqualTo("password", password);

        Users users = usersMapper.selectOneByExample(userExample);

        return users;
    }
}
