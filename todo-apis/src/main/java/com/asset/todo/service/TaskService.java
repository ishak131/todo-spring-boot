package com.asset.todo.service;

import com.asset.todo.model.CategoryModel;
import com.asset.todo.model.ProjectModel;
import com.asset.todo.model.TaskModel;
import com.asset.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskModel createTask(Long projectId,TaskModel task) {
        ProjectModel project = new ProjectModel();
        project.setId(projectId);
        task.setProject(project);
        task.setDate(LocalDate.now());
        task.setDone(false);
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskModel> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Optional<TaskModel> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Transactional
    public TaskModel updateTask(Long taskId, TaskModel updatedTask) {
        TaskModel task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("TaskModel not found with ID: " + taskId));
        task.setTitle(updatedTask.getTitle());
        task.setDone(updatedTask.isDone());

        return task;
    }

}