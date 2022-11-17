package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);
    User updateUser(User user,Long id);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByName(String name);
    List<User> getListUsers();




}
