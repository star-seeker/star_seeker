package com.imooc.service;

import com.imooc.pojo.Stu;

/**
 * @author zhangyoubao
 * @version 2020/5/13
 */
public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);
}
