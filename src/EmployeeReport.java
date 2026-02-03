import abstracts_temp.Employee;
import abstracts_temp.Report;
import interfaces_temp.Reportable;

public class EmployeeReport extends Report implements Reportable {

    private final Employee employee;
    private int completedTasks;

    public EmployeeReport(int id, String title, Employee employee) {
        super(id, title);
        this.employee = employee;
    }

    public void generateReport() {
        System.out.println("Employee Report: " + getTitle());
        System.out.println("Employee: " + employee.getName() + ", Position: " + employee.getPosition());
    }

    public void calculateMetrics() {
        completedTasks = 5;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public Employee getEmployee() {
        return employee;
    }
}
