package com.asset.todo.controller;

import java.util.List;

import com.asset.todo.model.ProjectModel;
import com.asset.todo.model.UserModel;
import com.asset.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/{userId}")
    public ResponseEntity<ProjectModel> createProject(@PathVariable Long userId, @RequestBody ProjectModel project) {
        UserModel user = new UserModel();
        user.setId(userId);
        project.setUser(user);
        ProjectModel createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProjectModel>> getAllProjects() {
        List<ProjectModel> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ProjectModel>> getProjectsByUserId(@PathVariable String userId) {
        List<ProjectModel> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectModel> getProjectById(@PathVariable Long projectId) {
        Optional<ProjectModel> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProject(@PathVariable Long projectId, @RequestBody ProjectModel updatedProject) {
        try {
            ProjectModel project = projectService.updateProject(projectId, updatedProject);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to remove category from the product.");

        }
    }
}