package com.producedaily.productivityapp.task;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.producedaily.productivityapp.user.model.User;

import javax.persistence.*;

@Entity
@Table(name="task")
public class  Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    private String name;

    private String note;

    private boolean isFinished;

    //private TaskStatus taskStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Task() {
    }

    public Task(String name, boolean isFinished) {
        this.name = name;
        this.isFinished = isFinished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}