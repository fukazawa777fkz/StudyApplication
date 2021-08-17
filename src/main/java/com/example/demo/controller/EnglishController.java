package com.example.demo.controller;


import com.example.demo.form.EnglishForm;
import com.example.demo.service.EnglishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EnglishController {

    /**
     * Demoサービスクラスへのアクセス
     */
    @Autowired
    private EnglishService englishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHello(Model model) {

        EnglishForm demoFormList = englishService.demoFormList();
        demoFormList.getName();
        model.addAttribute("result", demoFormList.getName());
        model.addAttribute("title", "Hello いんでっくす!");
        model.addAttribute("message", "ようこそ、ばったん技術ブログへ");
        return "index";
    }
}
