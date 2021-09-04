package com.example.demo.service;
// import org.springframework.validation.BindingResult; 
import java.util.List;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;
import com.example.demo.form.EngWordForm;
import com.example.demo.entity.SeisekiTbl;
import com.example.demo.entity.DogaData;
public interface DogaService {
    /**
     * ユーザーデータリストを取得
     * @return ユーザーデータリスト
     */
    public DogaData selectYoutubeUrl(int user_no);

}
