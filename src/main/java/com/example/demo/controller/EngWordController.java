package com.example.demo.controller;


import java.util.List;

import com.example.demo.form.EngWordForm;
import com.example.demo.form.UserData;
import com.example.demo.service.EngWordService;
import com.example.demo.service.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EngWordController {

    /**
     * Demoサービスクラスへのアクセス
     */
    @Autowired
    private EngWordService englishService;

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHello(Model model) {

        EngWordForm demoFormList = englishService.demoFormList();

        // // INPUTデータ設定
        // CandidateParameterBean param = new CandidateParameterBean();
        // param.setProcessKb(CandidateProcessKb.GROUP_INIT_INDEX);
        // param.setUserInfo(super.getUserInfo());

        
        // EnglishForm demoFormList = englishService.demoFormList();
        // demoFormList.getName();

        // model.addAttribute("form", form);
        // model.addAttribute("candidateInfo", bean);

        List<EngWordForm> engWordList = englishService.selectEngWordList();

        int user_no = 1;
        UserData userData = userDataService.selectUserData(user_no);

        model.addAttribute("result", demoFormList.getName());
        model.addAttribute("userData",userData);
        model.addAttribute("title", "Hello いんでっくす!");
        model.addAttribute("message", "ようこそ、ばったん技術ブログへ");

        model.addAttribute("engWordList", engWordList);
        return "index";
    }
}
