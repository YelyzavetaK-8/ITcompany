import abstracts.Employee;
import enums.Position;

public class ProjectManager extends Employee {

    public ProjectManager(int id, String name, String email, String phone, int experienceYears) {
        super(id, name, email, phone, experienceYears, Position.PM);
    }

    public int calculateSalary() {
        return CompanyConstants.BASE_PM_SALARY + experienceYears;
    }

    @Override
    public String toString() {
        return "PM{" + super.toString() + "}";
    }
}
