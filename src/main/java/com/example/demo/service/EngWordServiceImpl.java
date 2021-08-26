package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;

// import scala.collection.immutable.List;

import com.example.demo.form.EngWordForm;
import com.example.demo.mapper.EngWordMapper;
import com.example.demo.mapper.UserDataMapper;

@Service
public class EngWordServiceImpl implements EngWordService{

    /**
     * ユーザーデータテーブル(user_data)へアクセスするマッパー
     */
    @Autowired
    private UserDataMapper mapper;
    @Autowired
    private EngWordMapper  engWordMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public EngWordForm  demoFormList() {

        EngWordForm selectTest = mapper.selectTest();
        return selectTest;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EngWordForm> selectEngWordList(EngWordParamaterBean param) {
        
        int schoolType = param.getSchoolType();
        int schoolYear = param.getSchoolYear();
        int wordType = param.getWordType();
        List<EngWordForm> engWordList = engWordMapper.selectEngWordList(schoolType,schoolYear,wordType);
        return engWordList;
    }
}
