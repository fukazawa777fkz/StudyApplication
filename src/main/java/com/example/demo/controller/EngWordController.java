package com.example.demo.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;
import com.example.demo.form.EngWordForm;
import com.example.demo.form.UserData;
import com.example.demo.service.EngWordService;
import com.example.demo.service.UserDataService;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String topPage(Model model) {
        return "login";
    }

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(value = "/eng", method = RequestMethod.GET)
    public String showHello( Model model
                            ,@RequestParam(name = "user_no", required = false) int user_no
                            ,@RequestParam(name = "schoolType", required = false) int schoolType
                            ,@RequestParam(name = "schoolYear", required = false) int schoolYear
                            ,@RequestParam(name = "engWordType", required = false) int engWordType
                            ) {
        EngWordParamaterBean param = new EngWordParamaterBean();

        param.setSchoolType(schoolType);
        param.setSchoolYear(schoolYear);
        param.setWordType(engWordType);
        EngWordForm demoFormList = englishService.demoFormList();

        List<EngWordForm> engWordList = englishService.selectEngWordList(param);

        UserData userData = userDataService.selectUserData(user_no);

        if(schoolType == -1){
            schoolType = userData.getSchool_type();
        }
        if(schoolYear == -1){
            schoolYear = userData.getSchool_year();
        }
        if(engWordType == -1){
            engWordType = 0;
        }

        model.addAttribute("result", demoFormList.getName());
        model.addAttribute("userData",userData);
        model.addAttribute("title", "Hello いんでっくす!");
        model.addAttribute("message", "ようこそ、ばったん技術ブログへ");

        model.addAttribute("engWordList", engWordList);

        Map<Integer, String> scoolTypeMap = new LinkedHashMap<Integer, String>();
        scoolTypeMap.put(null ,"選択してください");
        scoolTypeMap.put(1 , "小学校");
        scoolTypeMap.put(2 , "中学校");
        scoolTypeMap.put(3 , "高校");
        model.addAttribute("scoolTypeMap", scoolTypeMap);
        model.addAttribute("selectedSchoolType", schoolType);


        Map<Integer, String> schoolYearMap = new LinkedHashMap<Integer, String>();
        schoolYearMap.put(null ,"選択してください");
        schoolYearMap.put(1 , "1年");
        schoolYearMap.put(2 , "2年");
        schoolYearMap.put(3 , "3年");
        schoolYearMap.put(4 , "4年");
        schoolYearMap.put(5 , "5年");
        schoolYearMap.put(6 , "6年");
        model.addAttribute("schoolYearMap", schoolYearMap);
        model.addAttribute("selectedSchoolYear", schoolYear);        

        Map<Integer, String> engWordTypeMap = new LinkedHashMap<Integer, String>();
        engWordTypeMap.put(null ,"選択してください");
        engWordTypeMap.put(1,"名刺");
        engWordTypeMap.put(2,"動詞");
        engWordTypeMap.put(3,"形容詞・副詞");
        engWordTypeMap.put(4,"季節/月/曜日");
        engWordTypeMap.put(5,"形容詞");
        engWordTypeMap.put(6,"数");
        engWordTypeMap.put(7,"副詞");
        engWordTypeMap.put(8,"代名詞");
        model.addAttribute("engWordTypeMap", engWordTypeMap);
        model.addAttribute("selectedEngWordType", engWordType);        


        return "index";

        // // INPUTデータ設定
        // CandidateParameterBean param = new CandidateParameterBean();
        // param.setProcessKb(CandidateProcessKb.GROUP_INIT_INDEX);
        // param.setUserInfo(super.getUserInfo());
    }
}
