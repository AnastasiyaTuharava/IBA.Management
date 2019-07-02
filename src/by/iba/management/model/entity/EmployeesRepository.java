package by.iba.management.model.entity;

import by.iba.management.util.DataParserEmployee;
import by.iba.management.util.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesRepository {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());
    private static final String FILE_PATH = "data/EmployeesList.xlsx";
    private static ArrayList<Employee> employeesList = new ArrayList<>();

    static {
        try {
            employeesList = DataParserEmployee.parseStringToCreateEmployee(FileReader.readFile(FILE_PATH));
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error reading file: ", e);
        }
    }

    private EmployeesRepository() {
    }

    public static ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }
}
