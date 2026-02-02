import java.util.*;
import Abstracts.*;
import Enums.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Developer dev = new Developer(1, "John", "john@mail.com", "123", 0);
        QA qa = new QA(2, "Sophie", "sophie@mail.com", "456", 2);
        ProjectManager pm = new ProjectManager(3, "J", "pm@mail.com", "789", 5);

        List<Employee> employees = Arrays.asList(dev, qa, pm);

        System.out.println("Enter client name:");
        String clientName = scanner.nextLine();
        Client client = new Client(1, clientName, "client@mail.com", "000", 500);

        List<Task> tasks = new ArrayList<>();

        System.out.println("How many tasks?");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Task #" + (i + 1) + " type (BUG/FEATURE):");
            String type = scanner.nextLine().toUpperCase();

            System.out.println("Title:");
            String title = scanner.nextLine();

            System.out.println("Estimated hours:");
            int est = Integer.parseInt(scanner.nextLine());

            if (type.equals("BUG")) {
                System.out.println("Description:");
                String desc = scanner.nextLine();
                System.out.println("Priority (LOW/NORMAL/HIGH/CRITICAL):");
                Priority p = Priority.valueOf(scanner.nextLine().toUpperCase());
                Bug bug = new Bug(i + 1, title, est, Status.TODO, desc, p);

                System.out.println("How many steps to reproduce?");
                int stepsCount = Integer.parseInt(scanner.nextLine());
                for (int s = 0; s < stepsCount; s++) {
                    System.out.println("Step #" + (s + 1) + ":");
                    bug.addStep(scanner.nextLine());
                }
                tasks.add(bug);

            } else if (type.equals("FEATURE")) {
                System.out.println("Priority (LOW/NORMAL/HIGH/CRITICAL):");
                Priority p = Priority.valueOf(scanner.nextLine().toUpperCase());
                Feature feature = new Feature(i + 1, title, est, Status.TODO, "", p);

                System.out.println("How many requirements?");
                int reqCount = Integer.parseInt(scanner.nextLine());
                List<String> reqs = new ArrayList<>();
                for (int r = 0; r < reqCount; r++) {
                    System.out.println("Requirement #" + (r + 1) + ":");
                    reqs.add(scanner.nextLine());
                }
                feature.addRequirements(reqs);
                tasks.add(feature);
            }
        }

        ITProject project = new ITProject(1, "Internal App", tasks, 0, client, 500);

        int totalTasksCost = tasks.stream().mapToInt(Task::getTaskEstimation).sum();
        int totalSalaries = employees.stream().mapToInt(Employee::calculateSalary).sum();
        int totalCost = totalTasksCost + totalSalaries;

        System.out.println("\n=== Project Report ===");
        System.out.println("Project: " + project.getTitle());
        System.out.println("Client: " + client.getName());
        System.out.println("Budget: " + project.getBudget());
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Within Budget: " + (totalCost <= project.getBudget()));
        System.out.println("Tasks:");
        for (Task t : tasks) {
            System.out.print(" - " + t.getTitle() + " [" + t.getStatus() + "] Est: " + t.getTaskEstimation() + "h");
            if (t instanceof Bug) {
                Bug b = (Bug) t;
                List<String> steps = new ArrayList<>();
                for (String s : b.getStepsToReproduce()) if (s != null) steps.add(s);
                System.out.print(" Steps: " + steps);
            } else if (t instanceof Feature) {
                Feature f = (Feature) t;
                System.out.print(" Requirements: " + f.getRequirements());
            }
            System.out.println();
        }

        System.out.println("\n=== Employees ===");
        for (Employee e : employees) {
            System.out.println(e.getPosition() + ": " + e.getName() + ", Salary: " + e.calculateSalary());
        }
        scanner.close();
    }

}
