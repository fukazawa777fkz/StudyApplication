package com.example.demo.service;
// import org.springframework.validation.BindingResult; 
import java.util.List;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;
import com.example.demo.form.EngWordForm;
import com.example.demo.entity.SeisekiTbl;

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

    /**
     * 成績テーブル
     */
    public int updateSeisekiTbl(EngWordParamaterBean param);
    public int insertSeisekiTbl(EngWordParamaterBean param);
    public SeisekiTbl selectSeisekiTbl(int user_no, int mondai_id);

}
