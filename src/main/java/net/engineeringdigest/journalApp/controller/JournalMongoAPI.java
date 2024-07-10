package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.reporistory.UserRepo;
import net.engineeringdigest.journalApp.service.JournalService;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.entity.Journal;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalMongoAPI {
    @Autowired
    JournalService serviceClassForDB ;

    @Autowired
    UserService userServive;

    @Autowired
    UserRepo userRepo;


     @PostMapping("/add")
     Journal addtodb(@RequestBody Journal body){
         body.setDate(LocalDate.now());
         return serviceClassForDB.addtodb(body);
     }

     @GetMapping("/getmongo")
     List<Journal> getalltodb(){
         return serviceClassForDB.getallfromdb();
     }
    @GetMapping("/getmongo/{id}")
    ResponseEntity<Journal> getByIdMongo(@PathVariable ObjectId id){
        Optional<Journal> j =  serviceClassForDB.getbyidmongo(id);
        if(j.get() == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT) ;
        }
        else
            return  new ResponseEntity<>(j.get(),HttpStatus.FOUND);
    }

    @PostMapping("/add/{Username}")
    Journal postwithuser(@RequestBody Journal body, @PathVariable String Username){
        User user = userServive.getUser(Username);
        Journal j = serviceClassForDB.addtodb(body);
        user.getUserJournals().add(j);
        userRepo.save(user);
        body.setDate(LocalDate.now());
        return j;
    }
}
