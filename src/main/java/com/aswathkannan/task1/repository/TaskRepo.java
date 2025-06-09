package com.aswathkannan.task1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aswathkannan.task1.model.Task;

import java.util.List;

@Repository
public interface TaskRepo  extends MongoRepository<Task, String> {
    List<Task> findByNameContainingIgnoreCase(String name);
}