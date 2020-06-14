package by.iba.management.util;

import by.iba.management.model.entity.Position;
import by.iba.management.model.entity.*;
import java.util.ArrayList;

public class DataParserEmployee {
    private static final String REGEX_SPACE = "\\s";
    public static ArrayList<Employee> parseStringToCreateEmployee(ArrayList<String> list) {
        ArrayList<Employee> employeesList = new ArrayList<>();
        DataValidatorEmployee validator = new DataValidatorEmployee();
        for (String str: list) {
            if (validator.validate(str)) {
                String[] s = str.split(REGEX_SPACE);
                Employee employee = new Employee(Long.parseLong(s[0]), s[1], s[2], Long.parseLong(s[3]), Boolean.parseBoolean(s[4]),
                        Position.valueOf(s[5]), EnglishLanguageLevel.valueOf(s[6]),
                        new ProgrammingLanguage(Boolean.parseBoolean(s[7]), Boolean.parseBoolean(s[8]),
                                Boolean.parseBoolean(s[9]), Boolean.parseBoolean(s[10]), Boolean.parseBoolean(s[11])),
                        new Skills(Boolean.parseBoolean(s[12]), Boolean.parseBoolean(s[13]), Boolean.parseBoolean(s[14]),
                                Boolean.parseBoolean(s[15]), Boolean.parseBoolean(s[16])),
                        new Testing(Boolean.parseBoolean(s[17]), Boolean.parseBoolean(s[18]), Boolean.parseBoolean(s[19]),
                                Boolean.parseBoolean(s[20])),
                        new Tools(Boolean.parseBoolean(s[21]), Boolean.parseBoolean(s[22]), Boolean.parseBoolean(s[23]), Boolean.parseBoolean(s[24])));
                employeesList.add(employee);
            }
        }
        return employeesList;
    }
}
