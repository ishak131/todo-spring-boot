package com.asset.todo.service;
import com.asset.todo.model.ProjectModel;
import com.asset.todo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectModel createProject(ProjectModel project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<ProjectModel> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Transactional
    public ProjectModel updateProject(Long projectId, ProjectModel updatedProject) {
        ProjectModel project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));
        project.setTitle(updatedProject.getTitle());
        project.setDescription(updatedProject.getDescription());
        return project;
    }
}