package com.todoapp.controller;

import com.todoapp.model.Task;
import com.todoapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model, @RequestParam(required = false) Boolean completed, Principal principal) {
        String username = principal.getName();
        if (completed != null) {
            model.addAttribute("tasks", taskService.getTasksByStatusAndUser(completed, username));
        } else {
            model.addAttribute("tasks", taskService.getAllTasksByUser(username));
        }
        model.addAttribute("newTask", new Task());
        return "tasks/list";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute("newTask") Task task,
                           BindingResult result,
                           RedirectAttributes redirectAttributes,
                           Principal principal) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al crear la tarea");
            return "redirect:/tasks";
        }
        String username = principal.getName();
        taskService.createTaskForUser(task, username);
        redirectAttributes.addFlashAttribute("success", "Tarea creada exitosamente");
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTaskStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.toggleTaskStatus(id);
        redirectAttributes.addFlashAttribute("success", "Estado de la tarea actualizado");
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.deleteTask(id);
        redirectAttributes.addFlashAttribute("success", "Tarea eliminada exitosamente");
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable Long id,
                           @Valid @ModelAttribute("task") Task task,
                           BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar la tarea");
            return "redirect:/tasks/" + id + "/edit";
        }
        taskService.updateTask(id, task);
        redirectAttributes.addFlashAttribute("success", "Tarea actualizada exitosamente");
        return "redirect:/tasks";
    }
} 