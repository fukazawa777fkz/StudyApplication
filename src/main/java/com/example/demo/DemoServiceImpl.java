package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{

    /**
     * ユーザーデータテーブル(user_data)へアクセスするマッパー
     */
    @Autowired
    private UserDataMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public DemoForm  demoFormList() {

        DemoForm selectTest = mapper.selectTest();
        // DemoForm selectTest = new DemoForm();
        // selectTest.setName("fukazaw !!!");
        return selectTest;
    }
}
