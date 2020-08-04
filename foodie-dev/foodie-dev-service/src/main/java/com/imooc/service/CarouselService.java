package com.imooc.service;

import com.imooc.pojo.Carousel;
import java.util.List;

/**
 * @author zhangyoubao
 * @version 2020/7/31
 */
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     */
    public List<Carousel> queryAll(Integer isShow);
}
