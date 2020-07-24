package com.imooc.controller;

import com.imooc.service.StuService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Resource
    private StuService stuService;

    @GetMapping("getStu")
    public Object hello(int id) {
        return stuService.getStuInfo(id);
    }

    @PostMapping("saveStu")
    public Object saveStu(){
        stuService.saveStu();
        return "OK";
    }

    @PostMapping("updateStu")
    public Object updateStu(int id){
        stuService.updateStu(id);
        return "OK";
    }

    @PostMapping("deleteStu")
    public Object deleteStu(int id){
        stuService.deleteStu(id);
        return "OK";
    }

}
