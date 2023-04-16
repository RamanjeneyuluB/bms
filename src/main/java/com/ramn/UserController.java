package com.ramn;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramn.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/")
    public List<User> getUsers() {
        // Create a list of dummy users
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "John", "Doe"));
        userList.add(new User(2, "Jane", "Smith"));
        userList.add(new User(3, "Alice", "Johnson"));
        userList.add(new User(4, "Bob", "Brown"));
        
        return userList;
    }
}
