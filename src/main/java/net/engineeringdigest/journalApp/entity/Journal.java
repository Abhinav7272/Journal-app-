package net.engineeringdigest.journalApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

// Using LomBok
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "journal_entites")
public class Journal {

    @Id
    private ObjectId id  ;
    private String title;
    private  String content;
    private LocalDate date ;

}
