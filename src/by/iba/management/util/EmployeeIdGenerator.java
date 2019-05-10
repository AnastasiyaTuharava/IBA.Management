package by.iba.management.util;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EmployeesRepository;

public class EmployeeIdGenerator {
    private static long employeeId = findLastId();
    public static long getEmployeeId() {
        return ++employeeId;
    }
    private static long findLastId () {
        long last = 0;
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getEmployeeId() > last) {
                last = e.getEmployeeId();
            }
        }
        return last;
    }
}