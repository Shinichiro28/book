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

import com.chappy.portfolio1.book.models.Chat;
import com.chappy.portfolio1.book.repository.ChatRepository;

@Controller
public class ChatController {
    
    //Chatクラスのフィールドをfinalにする
    private final ChatRepository repository;
    public ChatController(ChatRepository repository){
        this.repository = repository;
    }
    
    //一覧ページ
    @GetMapping("/chat")
    public String index(@ModelAttribute Chat chat, Model model){
        model.addAttribute("chats", repository.findAll());
        return "chat/index";
    }

    //詳細ページ
    @GetMapping("/chat/{id}")
    public String show(@PathVariable Long id, Model model){
        model.addAttribute("chat", repository.findById(id));
        return "chat/show";
    }

    
    @PostMapping("/chat/create")
    public String create(@Validated @ModelAttribute Chat chat, BindingResult result, Model model){

        //バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            model.addAttribute("chats", repository.findAll());
            return "chat/index";
        }
        repository.saveAndFlush(chat);
        return "redirect:/chat";
    }

    @GetMapping("/chat/delete/{id}") //データの削除
    public String remove(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/chat";
    }

    //編集
    @GetMapping("/chat/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("chat", repository.findById(id)); 
        return "chat/edit";
    }

    //更新
    @PostMapping("/chat/update/{id}")
    public String update(@PathVariable long id, @Validated @ModelAttribute Chat chat, BindingResult result){
        if (result.hasErrors()) {
            return "chat/edit";
        }
        repository.save(chat);
        return "redirect:/chat";
    }

    //初期データの投入
    @PostConstruct
    public void dataInt(){
        Chat sauna = new Chat();
        sauna.setName("Java SpringBootについて");
        repository.saveAndFlush(sauna);
    }
}
