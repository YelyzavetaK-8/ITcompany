import Abstracts.Employee;
import Enums.Position;

public class Developer extends Employee {

    public Developer(int id, String name, String email, String phone, int experienceYears) {
        super(id, name, email, phone, experienceYears, Position.DEV);
    }

    public int calculateSalary() {
        return CompanyConstants.BASE_DEV_SALARY + experienceYears * CompanyConstants.DEV_BONUS_PER_YEAR;
    }

    @Override
    public String toString() {
        return "DEV{" + super.toString() + "}";
    }

}
