package com.vcredit.ci.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 博客业务
 * @author seal
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    /**
     * 存放所有帖子
     */
    private ArrayList<String> blogs = new ArrayList<>(10);

    /**
     * 查看帖子
     * @return
     */
    @GetMapping("/")
    public ArrayList<String> showBlog(){
        return blogs;
    }

    /**
     * 发布帖子
     * @param blogText
     */
    @PostMapping("/")
    public void postBolg(@RequestBody String blogText){
        System.out.println(blogText);
        blogs.add(blogText);
    }

    /**
     * 清空帖子
     */
    @DeleteMapping("/")
    public void deleteBolg(){
        blogs.clear();
    }
}