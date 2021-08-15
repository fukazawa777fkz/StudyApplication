package com.example.demo;
// import org.springframework.validation.BindingResult; 
// import java.util.List;

public interface DemoService {
    
    /**
     * ユーザーデータリストを取得
     * @return ユーザーデータリスト
     */
    DemoForm demoFormList();
    
}
