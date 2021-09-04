package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.bean.paramaterBean.EngWordParamaterBean;

// import scala.collection.immutable.List;

import com.example.demo.form.EngWordForm;
import com.example.demo.mapper.EngWordMapper;
import com.example.demo.mapper.SeisekiTblMapper;
import com.example.demo.mapper.UserDataMapper;
import com.example.demo.entity.SeisekiTbl;

@Service
public class EngWordServiceImpl implements EngWordService{

    /**
     * ユーザーデータテーブル(user_data)へアクセスするマッパー
     */
    @Autowired
    private UserDataMapper mapper;
    @Autowired
    private EngWordMapper  engWordMapper;
    @Autowired
    private SeisekiTblMapper seisekiTblMapper;

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

    @Override
    public int insertSeisekiTbl(EngWordParamaterBean param){
        return seisekiTblMapper.insertSeisekiTbl(param.getUser_no(), param.getMondai_id());
    }

    @Override
    public int updateSeisekiTbl(EngWordParamaterBean param){
        return seisekiTblMapper.updateSeisekiTbl(param.getUser_no(), param.getMondai_id(), param.getOK_count(), param.getNG_count());
    }

    @Override
    public SeisekiTbl selectSeisekiTbl(int user_no, int mondai_id){
        return  seisekiTblMapper.selectSeisekiTbl(user_no, mondai_id);
    }

    
}
