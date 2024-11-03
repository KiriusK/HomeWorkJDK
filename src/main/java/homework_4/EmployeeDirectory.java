package homework_4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employesList;

    public EmployeeDirectory() {
        this.employesList = new ArrayList<>();
    }

    public boolean addEmployee(Employee employee) {
        employesList.add(employee);
        return true;
    }

    public List<Employee> getEmployesByExperience(int experience) {
        return employesList.stream().filter(emp -> emp.getExperience() == experience).toList();
    }

    public List<Long> getEmployesPhoneByName (String name) {
        return employesList.stream().filter(emp -> emp.getEmployeeName().equals(name)).mapToLong(Employee::getPhoneNumber).boxed().toList();
    }

    public Employee getEmployeeByNumber(int number) {
        for (Employee emp:employesList) {
            if(emp.getEmployeeNumber() == number) {
                return emp;
            }
        }
        return null;
    }
}
