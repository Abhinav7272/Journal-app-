package net.engineeringdigest.journalApp.reporistory;


import net.engineeringdigest.journalApp.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<Journal, ObjectId> {
}
