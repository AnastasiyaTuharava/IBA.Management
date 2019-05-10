package by.iba.management.controller;

import by.iba.management.model.entity.*;
import by.iba.management.util.DataWriterEmployee;
import by.iba.management.util.DataWriterProject;
import by.iba.management.util.EmployeeIdGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Project p1 = new Project("HelloWorld", "First line");
        ProjectsRepository.getProjectList().add(p1);
        for (Project p : ProjectsRepository.getProjectList()) {
            System.out.println(p);
        }
        DataWriterProject.writeProjectToFile(ProjectsRepository.getProjectList());
        /*ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(EmployeeIdGenerator.getEmployeeId(), "Bob", "Marley",
                7, true, Position.JUNIOR_QA, EnglishLanguageLevel.C1,
                new ProgrammingLanguage(true, false, false, false, false),
                new Skills(true, true, true, true, false),
                new Testing(false, false,false, false),
                new Tools(true, true, false, true)));
        DataWriterEmployee.writeEmployeeToFile(employeeList, p1);*/

    }
}
