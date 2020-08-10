package com.imooc.mapper;

import com.imooc.pojo.vo.ItemCommentVO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperExt {

    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
}