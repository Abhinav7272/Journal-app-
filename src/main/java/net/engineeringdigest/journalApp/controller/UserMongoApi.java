package net.engineeringdigest.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserMongoApi {

    @Autowired
    UserService userServive ;



    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        // Method 2 : using Slf4j
        log.info("Updating User {} ", user.getUserJournals());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userServive.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userServive.saveUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
