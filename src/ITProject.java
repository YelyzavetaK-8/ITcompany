import java.util.ArrayList;
import java.util.List;

import abstracts_temp.Employee;
import abstracts_temp.Project;
import abstracts_temp.Task;
import interfaces_temp.Budgetable;

public class ITProject extends Project implements Budgetable {
    private final Client client;
    private final int budget;
    private List<Employee> employees = new ArrayList<>();

    public ITProject(int id, String title, List<Task> tasks, int totalHours, Client client, int budget) {
        super(id, title, tasks, totalHours);
        this.client = client;
        this.budget = budget;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    @Override
    public int calculateTotalCost() {
        int total = 0;
        for (Task t : tasks)
            total += t.getTaskEstimation();
        for (Employee e : employees)
            total += e.calculateSalary();
        return total;
    }
    

    public boolean isWithinBudget() {
        return calculateTotalCost() <= budget;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "ITProject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", totalHours=" + totalHours +
                ", client=" + client.getName() +
                ", budget=" + budget +
                ", totalCost=" + calculateTotalCost() +
                ", withinBudget=" + isWithinBudget() +
                ", tasks=" + tasks +
                '}';
    }

}
