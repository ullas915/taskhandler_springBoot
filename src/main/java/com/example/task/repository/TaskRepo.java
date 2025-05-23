package com.example.task.repository;

import com.example.task.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepo extends MongoRepository<Task, ObjectId> {
}
