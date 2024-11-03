package homework_4;

import java.util.StringJoiner;

public class CompanyEmployee implements Employee{
    private final int employeeNumber;
    private final long phoneNumber;
    private final int experience;
    private final String name;

    public CompanyEmployee(String name, long phoneNumber, int experience, int employeeNumber) {
        this.employeeNumber = employeeNumber;
        this.experience = experience;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public String getEmployeeName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CompanyEmployee.class.getSimpleName() + "[", "]")
                .add("experience=" + experience)
                .add("employeeNumber=" + employeeNumber)
                .add("name='" + name + "'")
                .add("phoneNumber=" + phoneNumber)
                .toString();
    }
}
