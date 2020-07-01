package by.iba.management.model.logic;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.model.entity.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeLogic {
    public static void editEmployee(Employee employee) {
        EmployeeDAO.updateEmployee(employee);
    }

    public static void removeEmployee(long employeeId) throws IOException {
        EmployeeDAO.removeEmployee(employeeId);

    }

    public static void addEmployee(Employee employee) {
        EmployeeDAO.addEmployee(employee);
    }

    public static Employee getEmployee(long employeeId) {
        return EmployeeDAO.getEmployee(employeeId);
    }

    public static List<Employee> getEmployee(String firstName, String lastName) {
        return EmployeeDAO.getEmployee(firstName, lastName);
    }

    public static List<Employee> getEmployees() {
        return EmployeeDAO.getEmployees();
    }
}
