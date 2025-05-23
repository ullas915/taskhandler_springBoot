package com.example.task.service;

import com.example.task.entity.Task;

import com.example.task.repository.TaskRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCreationService {
    @Autowired
    public TaskRepo taskRepo;


    public void init() {
        Task task = new Task();
        task.setTitle("Test Task");
        taskRepo.save(task);
    }

    public void saveEntry(Task myTask){
        taskRepo.save(myTask);
    }

    public List<Task> getAll(){
        return taskRepo.findAll();
    }

    public Optional<Task> getById(ObjectId myId){
        return taskRepo.findById(myId);
    }

    public String deleteEntryById(ObjectId myId){
        taskRepo.deleteById(myId);
        return "Deleted task";
    }

    public String deleteEntry(){
        taskRepo.deleteAll();
        return "Deleted All";
    }

    public String updateById(Task myTask, String myId){
        myTask.setId(String.valueOf(myId));
        taskRepo.save(myTask);
        return "updated";
    }



}
