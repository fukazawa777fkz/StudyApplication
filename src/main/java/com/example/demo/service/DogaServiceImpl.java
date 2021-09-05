package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.mapper.DogaMapper;
import com.example.demo.entity.*;

@Service
public class DogaServiceImpl implements DogaService {

    @Autowired
    private DogaMapper dogaMapper;

	public DogaData selectYoutubeUrl(int user_no){
		// return null;
		List<DogaData> dtoList =  dogaMapper.selectYoutubeUrl(user_no);
		return dtoList.get(0);
	}
}
