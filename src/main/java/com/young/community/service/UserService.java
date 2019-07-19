package com.young.community.service;

import com.young.community.model.User;

public interface UserService {
    void insertUser(User user);
    void findByToken(String token);
}
