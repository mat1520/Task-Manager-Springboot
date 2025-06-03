package com.todoapp.repository;

import com.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByCreatedAtDesc();
    List<Task> findByCompletedOrderByCreatedAtDesc(boolean completed);
    List<Task> findAllByUserUsernameOrderByCreatedAtDesc(String username);
    List<Task> findByCompletedAndUserUsernameOrderByCreatedAtDesc(boolean completed, String username);
} 