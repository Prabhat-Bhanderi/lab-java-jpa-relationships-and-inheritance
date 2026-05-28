package com.springdatajpa.demo.repository;


import com.springdatajpa.demo.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}