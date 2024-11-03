package homework_4;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.addEmployee(new CompanyEmployee("Вася", 89882347575L, 3, 1));
        directory.addEmployee(new CompanyEmployee("Саня", 89882347576L, 2, 2));
        directory.addEmployee(new CompanyEmployee("Коля", 89882347577L, 5, 3));
        directory.addEmployee(new CompanyEmployee("Саня", 89882347578L, 3, 4));
        directory.addEmployee(new CompanyEmployee("Тима", 89882347579L, 2, 5));
        directory.addEmployee(new CompanyEmployee("Вася", 89882347580L, 5, 6));

        System.out.println(directory.getEmployeeByNumber(3));
        System.out.println(directory.getEmployesByExperience(5));
        System.out.println(directory.getEmployesPhoneByName("Саня"));
    }
}
