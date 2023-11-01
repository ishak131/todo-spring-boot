package com.asset.todo.controller;

import com.asset.todo.model.CategoryModel;
import com.asset.todo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<CategoryModel>> search(@PathVariable String keyword) {
        List<CategoryModel> categories = categoryService.search(keyword);
        return  ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody CategoryModel category) {
        categoryService.createCategory(category);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<?> addCategoryToTask(@PathVariable Long categoryId, @PathVariable Long productId) {
        try {
            categoryService.addCategoryToTask(categoryId, productId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add category to the product.");
        }
    }

    @DeleteMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<?> removeCategoryFromTask(@PathVariable Long categoryId, @PathVariable Long productId) {
        try {
            categoryService.removeCategoryFromTask(categoryId, productId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to remove category from the product.");
        }
    }
}