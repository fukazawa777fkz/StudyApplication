package com.example.demo.service;
import com.example.demo.form.UserData;
import com.example.demo.mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDataService{

    /**
     * ユーザーデータテーブル(user_data)へアクセスするマッパー
     */
    @Autowired
    private UserDataMapper mapper;

    @Override
    public UserData selectUserData(int user_no){
        return mapper.selectUserData(user_no);
    }

}
