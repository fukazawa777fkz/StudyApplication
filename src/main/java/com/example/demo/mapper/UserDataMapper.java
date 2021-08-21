package com.example.demo.mapper;

import com.example.demo.form.EngWordForm;
import com.example.demo.form.UserData;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDataMapper {

    EngWordForm selectTest();

    UserData selectUserData(int user_no);
    

   
}
