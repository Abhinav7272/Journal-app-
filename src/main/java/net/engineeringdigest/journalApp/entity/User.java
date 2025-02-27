package net.engineeringdigest.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import net.engineeringdigest.journalApp.entity.Journal;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Document(collection = "user_entities")
public class User {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;
    @DBRef
    private List<Journal> userJournals = new ArrayList<>();

    List<String> roles;
}
