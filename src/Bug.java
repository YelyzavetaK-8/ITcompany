import abstracts_temp.Task;
import enums_temp.Priority;
import enums_temp.Status;
import interfaces_temp.Taskable;

public class Bug extends Task implements Taskable{

    private final String[] stepsToReproduce = new String[8];
    private int count = 0;

    public Bug(int id, String title, int estimatedHours, Status status, String desc, Priority priority) {
        super(id, title, estimatedHours, status, desc, priority);
    }

    public void addStep(String step) {
        stepsToReproduce[count] = step;
        count++;
    }

    public String[] getStepsToReproduce() {
        return this.stepsToReproduce;
    }

    @Override
    public int getTaskEstimation() {
        if (this.priority == Priority.CRITICAL)
            return estimatedHours + 2 + count;
        else
            return estimatedHours + 4 + count;
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
