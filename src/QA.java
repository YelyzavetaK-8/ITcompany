import abstracts_temp.Employee;
import enums_temp.Position;

public class QA extends Employee {

    public QA(int id, String name, String email, String phone, int experienceYears) {
        super(id, name, email, phone, experienceYears, Position.QA);
    }

    public int calculateSalary() {
        return CompanyConstants.BASE_QA_SALARY + experienceYears * CompanyConstants.QA_BONUS_PER_YEAR;
    }

    @Override
    public String toString() {
        return "QA{" + super.toString() + "}";
    }

}
