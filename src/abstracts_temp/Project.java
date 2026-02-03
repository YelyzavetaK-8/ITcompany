package abstracts_temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Project {
    protected final int id;
    protected final String title;
    protected List<Task> tasks = new ArrayList<>();
    protected final int totalHours;

    public Project(int id, String title, List<Task> tasks, int totalHours) {
        this.id = id;
        this.title = title;
        this.tasks = tasks;
        this.totalHours = totalHours;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Project project = (Project) o;
        return id == project.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", totalHours=" + totalHours +
                ", tasks=" + tasks +
                '}';
    }
}