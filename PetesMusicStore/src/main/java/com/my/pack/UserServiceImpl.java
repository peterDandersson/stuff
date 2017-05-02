package com.my.pack;

import javax.faces.bean.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new ConcurrentHashMap<String, User>();

    public User getUser(String userName) {
        return users.get(userName);
    }

    public void saveUser(User user) {
        users.put(user.getUserName(), user);
    }
}
