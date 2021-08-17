package com.example.demo.service;
// import org.springframework.validation.BindingResult; 
// import java.util.List;

import com.example.demo.form.EnglishForm;

public interface EnglishService {
    
    /**
     * ユーザーデータリストを取得
     * @return ユーザーデータリスト
     */
    EnglishForm demoFormList();
    
}
