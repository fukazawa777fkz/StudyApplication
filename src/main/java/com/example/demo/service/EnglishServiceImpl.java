package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.form.EnglishForm;
import com.example.demo.mapper.UserDataMapper;

@Service
public class EnglishServiceImpl implements EnglishService{

    /**
     * ユーザーデータテーブル(user_data)へアクセスするマッパー
     */
    @Autowired
    private UserDataMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public EnglishForm  demoFormList() {

        EnglishForm selectTest = mapper.selectTest();
        // DemoForm selectTest = new DemoForm();
        // selectTest.setName("fukazaw !!!");
        return selectTest;
    }
}
