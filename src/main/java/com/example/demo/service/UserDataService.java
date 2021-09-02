package com.example.demo.service;

import com.example.demo.form.UserData;
public interface UserDataService {
    public UserData selectUserData(int user_no);
    public int updateUseEngWord(int word_type, int user_no);
}
