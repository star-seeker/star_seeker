package com.imooc.mapper;

import com.imooc.pojo.vo.CategoryVO;
import java.util.List;

public interface CategoryMapperExt {

    List<CategoryVO> getSubCatList(Integer rootCatId);
}