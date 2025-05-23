package com.example.task.controller;

import com.example.task.entity.Task;
import com.example.task.service.TaskCreationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskCreationService taskCreationService;

    @PostMapping("init")
    public void insert(){
     taskCreationService.init();
    }

    @PostMapping
    public String saveTask(@RequestBody Task myTask){
        taskCreationService.saveEntry(myTask);
        return "Saved";
    }

    @GetMapping
    public List<Task> getAllTask(){
        return taskCreationService.getAll();

    }

    @GetMapping("id/{myId}")
    public Optional<Task> getById(@PathVariable ObjectId myId){
        return taskCreationService.getById(myId);
    }

    @DeleteMapping
    public String deleteAll(){
        return taskCreationService.deleteEntry();
    }

    @DeleteMapping("id/{myId}")
    public String deleteById(@PathVariable String myId){
        return taskCreationService.deleteEntryById(new ObjectId(myId));
    }

    @PutMapping("id/{myId}")
    public String updateById(@RequestBody Task mytask,@PathVariable String myId){
        return taskCreationService.updateById(mytask,myId);
    }
}

