package com.springbootsecurity.services;

import com.springbootsecurity.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User("karthik" , "karthik" , "karthik.b1921@gmail.com"));
        users.add(new User("bhargav" , "bhargav" , "bhargav@gmail.com"));
        users.add(new User("swaroop", "swaroop", "swaroop@gmail.com"));
    }

    public List<User> getUsers(){
        return this.users;
    }
    public User getUserwithName(String username){
        return this.users.stream().filter(user -> user.getUser().equals(username)).findAny().orElse(null);
    }
    public User saveUser(User user){
        if(Objects.nonNull(user) && !StringUtils.isEmpty(user.getUser())){
            System.out.println(user.toString());
            this.users.add(user);
        }
        return user;
    }
}

