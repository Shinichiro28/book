package com.chappy.portfolio1.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chappy.portfolio1.book.models.Post;

@Controller
public class PostController {

    @GetMapping("/post")
    public String index(@ModelAttribute Post post){
        return "post/index";
    }

    @PostMapping("/post/create")
    public String create(@Validated @ModelAttribute Post post, BindingResult result){
        
        //バリデーションエラー
        if (result.hasErrors()) {
            return "post/index";
        }
        return "post/create";
    }
}
