import java.util.ArrayList;
import java.util.List;

import abstracts_temp.Task;
import enums_temp.Priority;
import enums_temp.Status;
import interfaces_temp.Taskable;

public class Feature extends Task implements Taskable {

    private List<String> requirements = new ArrayList<>();

    public Feature(int id, String title, int estimatedHours, Status status, String desc, Priority priority) {
        super(id, title, estimatedHours, status, desc, priority);
    }

    public void addRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    @Override
    public int getTaskEstimation() {
        return estimatedHours * requirements.size();
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", title='" + getTitle() + '\'' +
                ", estimatedHours=" + getTaskEstimation() +
                ", status=" + getStatus() +
                ", requirements='" + getRequirements() + '\'' +
                '}';
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

}
