package com.yacine.DocumentRules.Service;

import com.yacine.DocumentRules.Entity.User;
import com.yacine.DocumentRules.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
        public User updateUser(User user, Long id) {
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user=userRepo.findById(id).get();
        userRepo.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getUserByName(String name) {

        return userRepo.findByUserName(name);
    }

    @Override
    public List<User> getListUsers() {
        return userRepo.findAll();
    }
}
