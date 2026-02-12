import abstracts.Task;
import enums.Priority;
import enums.Status;
import interfaces.Taskable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bug extends Task implements Taskable {

    private static final int MAX_STEPS = 8;
    private final List<String> stepsToReproduce = new ArrayList<>();

    public Bug(int id, String title, int estimatedHours, Status status, String desc, Priority priority) {
        super(id, title, estimatedHours, status, desc, priority);
    }

    public void addStep(String step) {
        if (stepsToReproduce.size() < MAX_STEPS) {
            stepsToReproduce.add(step);
        }
    }

    public List<String> getStepsToReproduce() {
        return Collections.unmodifiableList(stepsToReproduce);
    }

    @Override
    public int getTaskEstimation() {
        if (this.priority == Priority.CRITICAL)
            return estimatedHours + 2 + stepsToReproduce.size();
        else
            return estimatedHours + 4 + stepsToReproduce.size();
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", title='" + getTitle() + '\'' +
                ", estimatedHours=" + getTaskEstimation() +
                ", status=" + getStatus() +
                ", desc='" + getDescription() + '\'' +
                '}';
    }

    @Override
    public Priority getPriority() {
        return priority;
    }
}
