package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.reporistory.JournalRepo;
import net.engineeringdigest.journalApp.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JournalService {

    @Autowired
    JournalRepo repo ;

    public Journal addtodb(Journal myjounal){
        return repo.insert(myjounal);
    }

    public List<Journal> getallfromdb(){
        return repo.findAll();
    }

    public Optional<Journal> getbyidmongo(ObjectId id){
        return repo.findById(id);
    }
}
