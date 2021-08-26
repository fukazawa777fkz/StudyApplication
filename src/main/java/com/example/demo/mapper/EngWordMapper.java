package com.example.demo.mapper;

import java.util.List;

import com.example.demo.form.EngWordForm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EngWordMapper {
    EngWordForm selectTest();
    List<EngWordForm> selectEngWordList(int schoolType, int schoolYear, int wordType);
}

