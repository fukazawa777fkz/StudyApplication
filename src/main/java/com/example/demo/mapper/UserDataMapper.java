package com.example.demo.mapper;

import com.example.demo.form.EnglishForm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDataMapper {

    EnglishForm selectTest();
   
}
