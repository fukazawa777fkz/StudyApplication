package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HelloController {


    /**
     * Demoサービスクラスへのアクセス
     */
    @Autowired
    private DemoService demoService;

    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHello(Model model) {

        DemoForm demoFormList = demoService.demoFormList();
        demoFormList.getName();
        model.addAttribute("result", demoFormList.getName());
        model.addAttribute("title", "Hello いんでっくす!");
        model.addAttribute("message", "ようこそ、ばったん技術ブログへ");
        return "index";
    }
}
