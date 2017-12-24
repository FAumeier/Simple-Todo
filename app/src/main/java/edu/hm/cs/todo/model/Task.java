package edu.hm.cs.todo.model;

import java.util.Date;

/**
 * Created by Sam on 24/12/2017.
 */

public class Task {
    private Date created;
    private String name;
    private String description;
    private boolean isDone;

    public Task(Date created, String name, String description, boolean isDone) {
        this.created = created;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (isDone != task.isDone) return false;
        if (!created.equals(task.created)) return false;
        if (!name.equals(task.name)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = created.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (isDone ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "created=" + created +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
