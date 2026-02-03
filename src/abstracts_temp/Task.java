package abstracts_temp;

import java.util.Objects;

import enums_temp.Priority;
import enums_temp.Status;
import interfaces_temp.Prioritizable;

public abstract class Task implements Prioritizable{

    protected final int id;
    protected String title;
    protected final int estimatedHours;
    protected Status status;
    protected String desc;
    protected final Priority priority;

    public Task(int id, String title, int estimatedHours, Status status, String desc, Priority priority) {
        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = status;
        this.desc = desc;
        this.priority = priority;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle(){
        return title;
    }

    public int getTaskEstimation(){
        return estimatedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", estimatedHours=" + estimatedHours +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }

}
