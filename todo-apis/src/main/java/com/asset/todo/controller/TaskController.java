package com.asset.todo.controller;

import com.asset.todo.model.TaskModel;
import com.asset.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@PathVariable Long projectId, @RequestBody TaskModel task) {

        TaskModel createdTask = taskService.createTask(projectId,task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks(@PathVariable Long projectId) {
        List<TaskModel> tasks = taskService.getTasksByProjectId(projectId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long taskId) {
        Optional<TaskModel> task = taskService.getTaskById(taskId);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable Long taskId, @RequestBody TaskModel updatedTask) {
        TaskModel task = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(task);
    }
}