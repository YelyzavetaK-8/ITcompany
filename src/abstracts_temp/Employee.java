package abstracts;

import java.util.Objects;

import enums.Position;
import interfaces.Salaried;

public abstract class Employee extends Human implements Salaried {

    protected final int experienceYears;
    protected final Position position;

    public Employee(int id, String name, String email, String phone, int experienceYears, Position position) {
        super(id, name, email, phone);
        this.experienceYears = experienceYears;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", position=" + position +
                ", experienceYears=" + experienceYears;
    }
}
