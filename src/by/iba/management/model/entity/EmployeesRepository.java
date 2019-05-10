package by.iba.management.model.entity;

import by.iba.management.util.DataParserEmployee;
import by.iba.management.util.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeesRepository {
    private static ArrayList<Employee> employeesList = new ArrayList<>();
    private static final Logger logger = LogManager.getRootLogger();
    private static final String FILE_PATH = "data/EmployeesList.xlsx";
    static {
        try {
            employeesList = DataParserEmployee.parseStringToCreateEmployee(FileReader.readFile(FILE_PATH));
        } catch (IOException e) {
            logger.error("Error reading file: ", e);
        }
    }
    private EmployeesRepository() {
    }

    public static ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }
}
