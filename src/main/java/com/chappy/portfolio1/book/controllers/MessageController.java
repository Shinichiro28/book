package com.chappy.portfolio1.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappy.portfolio1.book.models.Message;
import com.chappy.portfolio1.book.repository.MessageRepository;


@Controller
@RequestMapping("/chat/{chatId}")
public class MessageController {

    private final MessageRepository repository;
    public MessageController(MessageRepository repository){
        this.repository = repository;
    }

    //一覧ページ
    @GetMapping("/message")
    public String index(@ModelAttribute Message message, Model model){
        model.addAttribute("messages", repository.findAll());
        return "message/index";
    }
    
    //投稿
    @PostMapping("/message/create")
    public String create(@Validated @ModelAttribute Message message, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("messages", repository.findAll());
            return "message/index";
        }
        repository.saveAndFlush(message);
        return "redirect:/chat/1/message";
    }

    //削除
    @GetMapping("/message/delete/{id}")
    public String remove(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/chat/1/message";
    }
}
