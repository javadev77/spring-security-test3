package fr.maison.javadev.springsecuritytest3.controller;

import fr.maison.javadev.springsecuritytest3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        user.setPassword (passwordEncoder.encode (user.getPassword () ));
        userDetailsManager.createUser(user);
    }

}
