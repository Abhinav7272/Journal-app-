package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.reporistory.UserRepo;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
public class UserService {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepo userRepo ;

    public User createUser(User user){
        return userRepo.insert(user);
    }
    public User getUser(String name){
        return userRepo.findByUserName(name);
    }
    public List<User> getAll() {
        return userRepo.findAll();
    }
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepo.save(user);

    }
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        return userRepo.save(user);

    }
    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }


}
