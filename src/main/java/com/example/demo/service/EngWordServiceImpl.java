package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<EngWordForm> selectEngWordList() {
        List<EngWordForm> engWordList = engWordMapper.selectEngWordList();
        return engWordList;
    }
}
