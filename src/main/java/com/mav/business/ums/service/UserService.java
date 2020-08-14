package com.mav.business.ums.service;


import com.mav.business.ums.domain.User;

public interface UserService {
    public User findUserByEmail(String email) ;
    public User saveUser(User user);
}
