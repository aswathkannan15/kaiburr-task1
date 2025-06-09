package com.aswathkannan.task1.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aswathkannan.task1.model.Task;
import com.aswathkannan.task1.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            Task task = taskService.getTaskById(id);
            return task != null ? List.of(task) : List.of();
        }
        return taskService.getAllTasks();
    }
    

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String name) {
        return taskService.searchTasksByName(name);
    }
    

    @PutMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
    

    @PutMapping("/{id}/execute")
    public Task executeTask(@PathVariable String id) throws Exception {
        return taskService.executeTask(id);
    }
}