package com.my.pack;


public interface UserService {
    User getUser(String userName);
    void saveUser(User user);
}
