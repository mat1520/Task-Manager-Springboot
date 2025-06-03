package com.todoapp.service;

import com.todoapp.model.Task;
import com.todoapp.repository.TaskRepository;
import com.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompletedOrderByCreatedAtDesc(completed);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    @Transactional
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        return taskRepository.save(task);
    }

    @Transactional
    public Task toggleTaskStatus(Long id) {
        Task task = getTaskById(id);
        task.setCompleted(!task.isCompleted());
        task.setCompletedAt(task.isCompleted() ? LocalDateTime.now() : null);
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    public List<Task> getAllTasksByUser(String username) {
        return taskRepository.findAllByUserUsernameOrderByCreatedAtDesc(username);
    }

    public List<Task> getTasksByStatusAndUser(boolean completed, String username) {
        return taskRepository.findByCompletedAndUserUsernameOrderByCreatedAtDesc(completed, username);
    }

    public Task createTaskForUser(Task task, String username) {
        var user = userRepository.findByUsername(username).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }
} 