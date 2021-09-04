package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;
import com.example.demo.entity.*;
import com.example.demo.form.*;
import com.example.demo.service.DogaService;
import com.example.demo.service.EngWordService;
import com.example.demo.service.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EngWordController {

    /**
     * Demoサービスクラスへのアクセス
     */
    @Autowired
    private EngWordService englishService;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private DogaService dogaService;

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

        // ***************************
        // * ユーザーデータを取得
        // ***************************
        UserData userData = userDataService.selectUserData(user_no);
        if(schoolType == 0){
            schoolType = userData.getSchool_type();
        }
        if(schoolYear == 0){
            schoolYear = userData.getSchool_year();
        }
        // if (engWordType != 0 ){
            userDataService.updateUseEngWord(engWordType, user_no);
        // }

        // ***************************
        // * 英単語取得
        // ***************************
        EngWordParamaterBean param = new EngWordParamaterBean();
        param.setSchoolType(schoolType);
        param.setSchoolYear(schoolYear);
        param.setWordType(engWordType);
        EngWordForm demoFormList = englishService.demoFormList();

        List<EngWordForm> engWordList = englishService.selectEngWordList(param);


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
        schoolYearMap.put(0 ,"全学年");
        schoolYearMap.put(1 , "1年");
        schoolYearMap.put(2 , "2年");
        schoolYearMap.put(3 , "3年");
        if (schoolType <2 ){
            schoolYearMap.put(4 , "4年");
            schoolYearMap.put(5 , "5年");
            schoolYearMap.put(6 , "6年");
        }
        model.addAttribute("schoolYearMap", schoolYearMap);
        model.addAttribute("selectedSchoolYear", schoolYear);        

        Map<Integer, String> engWordTypeMap = new LinkedHashMap<Integer, String>();
        engWordTypeMap.put(0 ,"ランダム");
        engWordTypeMap.put(1,"名刺");
        engWordTypeMap.put(2,"動詞");
        engWordTypeMap.put(3,"形容詞・副詞");
        engWordTypeMap.put(4,"季節/月/曜日");
        engWordTypeMap.put(5,"形容詞");
        engWordTypeMap.put(6,"数");
        engWordTypeMap.put(7,"副詞");
        engWordTypeMap.put(8,"代名詞");
        model.addAttribute("engWordTypeMap", engWordTypeMap);
        // if (engWordType == 0){
        //     engWordType = userData.getWord_type();
        // }
        model.addAttribute("selectedEngWordType", engWordType);        

        Map<Integer, String> viewTypeMap = new LinkedHashMap<Integer, String>();
        viewTypeMap.put(0 ,"選択してください");
        viewTypeMap.put(1,"正解した奴。");
        viewTypeMap.put(2,"不正解した奴");
        viewTypeMap.put(15,"正解率50%は出さない");
        model.addAttribute("viewTypeMap", viewTypeMap);


        DogaData dogaData = dogaService.selectYoutubeUrl(user_no);
        model.addAttribute("dogaData", dogaData);

        return "index";

        // // INPUTデータ設定
        // CandidateParameterBean param = new CandidateParameterBean();
        // param.setProcessKb(CandidateProcessKb.GROUP_INIT_INDEX);
        // param.setUserInfo(super.getUserInfo());
    }

    @PostMapping(value = "/eng/resultCommit/{user_no}/{mondai_id}/{judgResult}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> resultCommit(
            @ModelAttribute("form") @Validated EngWordForm form,
            @PathVariable("user_no") int user_no,
            @PathVariable("mondai_id") int mondai_id,
            @PathVariable("judgResult") int judgResult,
            Model model
    ) {

        SeisekiTbl selectSeisekiTbl = englishService.selectSeisekiTbl(user_no, mondai_id);
    
        EngWordParamaterBean param = new EngWordParamaterBean();
        param.setUser_no(user_no);
        param.setMondai_id(mondai_id);
        if (selectSeisekiTbl == null){
            englishService.insertSeisekiTbl(param);
            if (judgResult == 1){
                param.setOK_count(1);
                param.setNG_count(0);
            }else{
                param.setOK_count(0);
                param.setNG_count(1);
            }
        }
        else{
            if (judgResult == 1){
                param.setOK_count(selectSeisekiTbl.getOK_count() + 1);
                param.setNG_count(selectSeisekiTbl.getNG_count());
            }else{
                param.setOK_count(selectSeisekiTbl.getOK_count());
                param.setNG_count(selectSeisekiTbl.getNG_count() + 1);
            }
        }
        englishService.updateSeisekiTbl(param);

        return null;
    }    


    @PostMapping(value = "/eng/updateEngWordInfo/{user_no}/{word_type}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> updateEngWordInfo(
            @ModelAttribute("form") @Validated EngWordForm form,
            @PathVariable("user_no") int user_no,
            @PathVariable("word_type") int word_type,
            Model model
    ) {
        userDataService.updateUseEngWord(form.getWord_type(), user_no);
        return null;
    }    


}
