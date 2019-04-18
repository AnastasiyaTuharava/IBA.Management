package by.iba.management.model.logic;

import by.iba.management.model.entity.*;

import java.util.ArrayList;
import java.util.List;


public class FindEmployee {
    private FindEmployee () {}
    public static List<Employee> findEmployeeByName (String firstName, String lastName) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByProjectId (long projectId) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getProjectId() == projectId) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByEmployeeId (long employeeId) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getEmployeeId() == employeeId) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findTeamLeadEmployee (boolean teamLead) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.isTeamLead()) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByEnglishLanguageLevel (String englishLanguageLevel) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getEnglishLanguageLevel().equals(englishLanguageLevel)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByProgrammingLanguage (ProgrammingLanguage programmingLanguage) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getProgrammingLanguage().equals(programmingLanguage)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeBySkills (Skills skills) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getSkills().equals(skills)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByTesting (Testing testing) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getTesting().equals(testing)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    public static List<Employee> findEmployeeByTools (Tools tools) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getTools().equals(tools)) {
                listResult.add(e);
            }
        }
        return listResult;
    }
}
