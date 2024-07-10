package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicControlerAPI {

    @Autowired
    UserService userService ;

    // method 1
    Logger logger = LoggerFactory.getLogger(PublicControlerAPI.class) ;

    @GetMapping("/healthcheck")
    public String checkhealth(){
        logger.info("healthcheck is good");
        return "OK" ;
    }

    @PostMapping("/adduser")
    ResponseEntity<User> createNewUser(@RequestBody User user) {
        User u = userService.saveUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
