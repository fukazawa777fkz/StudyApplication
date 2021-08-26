package com.example.demo.service;
// import org.springframework.validation.BindingResult; 
import java.util.List;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;
import com.example.demo.form.EngWordForm;

public interface EngWordService {
    
    /**
     * ユーザーデータリストを取得
     * @return ユーザーデータリスト
     */
    public EngWordForm demoFormList();
    
    /**
     * 英単語リストを取得
     * @param param
     * @return 英単語リスト
     */
    public List<EngWordForm> selectEngWordList(EngWordParamaterBean param);

}
