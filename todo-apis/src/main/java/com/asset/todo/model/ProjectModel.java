package com.asset.todo.model;

import jakarta.persistence.*;
import java.util.List;
@Table(name = "project")
@Entity

public class ProjectModel {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TaskModel> tasks;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
