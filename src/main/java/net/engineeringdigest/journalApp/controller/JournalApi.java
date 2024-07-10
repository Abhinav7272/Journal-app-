package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalApi {
    HashMap<ObjectId, Journal> journalList = new HashMap<ObjectId, Journal>() ;
    @PostMapping("/post")
     String createJournal(@RequestBody Journal body){
        journalList.put( body.getId() ,  body) ;
        return "CREATED" ;
    }

    @GetMapping("/get" )
    List<Journal> returnList(){
        return new ArrayList<>(journalList.values()) ;
    }

    @GetMapping("/get/{Id}")
    Journal returnById(@PathVariable Long Id) {
        return journalList.get(Id) ;
    }

    @PutMapping("/put")
    String changeJournal(@RequestBody Journal body) {
        journalList.put(body.getId(), body);
        return "CHANGED";
    }

    @DeleteMapping("/delete/{Id}")
    String deleteJournal(@PathVariable Long Id){
        journalList.remove(Id) ;
        return "DELETED" ;
    }

}
