package com.aswathkannan.task1.service;



import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.aswathkannan.task1.model.Task;
import com.aswathkannan.task1.model.TaskExecution;
import com.aswathkannan.task1.repository.TaskRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repository;

    public List<Task> getAllTasks() { return repository.findAll(); }

    public Task getTaskById(String id) { return repository.findById(id).orElse(null); }

    public List<Task> searchTasksByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    public Task executeTask(String id) throws Exception {
        Task task = getTaskById(id);
        if (task == null) throw new Exception("Task not found");
        
        ProcessBuilder builder = new ProcessBuilder("bash", "-c", task.getCommand());
        builder.redirectErrorStream(true);
        long start = System.currentTimeMillis();
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) output.append(line).append("\n");
        process.waitFor();
        long end = System.currentTimeMillis();

        TaskExecution exec = new TaskExecution();
        exec.setStartTime(new Date(start));
        exec.setEndTime(new Date(end));
        exec.setOutput(output.toString());
        task.getTaskExecutions().add(exec);

        return repository.save(task);
    }
}