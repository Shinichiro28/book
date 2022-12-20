package com.chappy.portfolio1.book.controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chappy.portfolio1.book.models.Post;
import com.chappy.portfolio1.book.repository.PostRepository;

@Controller
public class PostController {

    private final PostRepository repository;
    public PostController(PostRepository repository){
        this.repository = repository;
    }

    @GetMapping("/post")
    public String index(@ModelAttribute Post post, Model model){
        model.addAttribute("posts", repository.findAll());
        return "post/index";
    }

    @PostMapping("/post/create")
    public String create(@Validated @ModelAttribute Post post, BindingResult result, Model model){
        
        //バリデーションエラー
        if (result.hasErrors()) {
            model.addAttribute("posts", repository.findAll());
            return "post/index";
        }
        repository.saveAndFlush(post);
        return "redirect:/post";
    }

    //削除
    @GetMapping("/post/delete/{id}")
    public String remove(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/post";
    }

    //初期データ
    @PostConstruct
    public void dataInit(){
        Post nyumon = new Post();
        nyumon.setName("Java入門");
        nyumon.setIntroduction("Javaの基本がわかる");
        repository.saveAndFlush(nyumon);
    }
}
