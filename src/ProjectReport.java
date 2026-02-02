
import Abstracts.Report;
import Abstracts.Task;
import Interfaces.Reportable;

import java.util.List;

public class ProjectReport extends Report implements Reportable {

    private final List<Task> tasks;

    public ProjectReport(int id, String title, List<Task> tasks) {
        super(id, title);
        this.tasks = tasks;
    }

    public void generateReport() {
        System.out.println("Project Report: " + getTitle());
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public int calculateTotalHours() {
        return tasks.stream().mapToInt(Task::getTaskEstimation).sum();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
