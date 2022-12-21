package com.chappy.portfolio1.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappy.portfolio1.book.models.Message;


@Controller
@RequestMapping("/chat/{chatId}")
public class MessageController {

    @GetMapping("/message")
    public String index(@ModelAttribute Message message){
        return "message/index";
    }
    
    @PostMapping("/message/create")
    public String create(@ModelAttribute Message message){
        return "message/create";
    }
}
