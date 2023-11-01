package com.asset.todo.service;

import com.asset.todo.model.CategoryModel;
import com.asset.todo.model.ProjectModel;
import com.asset.todo.model.TaskModel;
import com.asset.todo.repository.CategoryRepository;
import com.asset.todo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final TaskRepository taskRepository;

    public CategoryService(CategoryRepository categoryRepository, TaskRepository taskRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
    }

    public List<CategoryModel> search(String keyword) {
        Pageable pageable = PageRequest.of(0, 10); // Limiting to 10 categories
        return categoryRepository.findByNameContainingIgnoreCase(keyword, pageable).getContent();
    }
    public CategoryModel createCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public void addCategoryToTask(Long categoryId, Long taskId) {
        CategoryModel category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.getCategories().add(category);
        category.getTasks().add(task);

        taskRepository.save(task);
        categoryRepository.save(category);
    }

    @Transactional
    public void removeCategoryFromTask(Long categoryId, Long taskId) {
        CategoryModel category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        TaskModel task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.getCategories().remove(category);
        category.getTasks().remove(task);

        taskRepository.save(task);
        categoryRepository.save(category);
    }
}