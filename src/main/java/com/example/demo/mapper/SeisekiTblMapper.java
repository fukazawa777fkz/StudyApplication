package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.SeisekiTbl;

@Mapper
public interface SeisekiTblMapper {

    SeisekiTbl selectSeisekiTbl(int user_no, int mondai_id);
    int insertSeisekiTbl(int user_no, int mondai_id);
    int updateSeisekiTbl(int user_no, int mondai_id, int OK_count, int NG_count);
   
}
