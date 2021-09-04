package com.example.demo.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.DogaData;
import java.util.List;

@Mapper
public interface DogaMapper {

    /**
     * ユーザーデータリストを取得
     * @return ユーザーデータリスト
     */
    List<DogaData> selectYoutubeUrl(int user_no);
}
