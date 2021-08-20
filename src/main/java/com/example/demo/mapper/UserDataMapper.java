package com.example.demo.mapper;

import com.example.demo.form.EngWordForm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDataMapper {

    EngWordForm selectTest();
   
}
