package com.yacine.DocumentRules.Controller;

import com.yacine.DocumentRules.Entity.User;
import com.yacine.DocumentRules.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class UserController {

    UserService userService;
    @PostMapping("users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping("users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user,id);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    /*
    @GetMapping("users")
    public User getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }*/
    @GetMapping("users")
    public List<User> getListUsers() {
        return userService.getListUsers();
    }




}
