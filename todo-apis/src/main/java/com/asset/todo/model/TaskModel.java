package com.asset.todo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "task")
@Entity
public class TaskModel {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean isDone;

    @ManyToOne()
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }
}

