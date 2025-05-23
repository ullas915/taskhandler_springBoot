package com.example.task.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "titleDb")
@Data
public class Task {
    @Id
    private ObjectId id;

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter that returns ObjectId as String
    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    // Setter to accept String id
    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }
}
