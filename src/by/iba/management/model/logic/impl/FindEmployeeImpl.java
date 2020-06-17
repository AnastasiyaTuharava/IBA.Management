package by.iba.management.model.logic.impl;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import by.iba.management.model.entity.*;
import by.iba.management.model.logic.FindEmployee;

import java.util.ArrayList;
import java.util.List;

public class FindEmployeeImpl implements FindEmployee {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> findEmployeeByName(String firstName, String lastName) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByProjectId(long projectId) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getProjectId() == projectId) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByEmployeeId(long employeeId) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getEmployeeId() == employeeId) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findTeamLeadEmployee(boolean teamLead) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.isTeamLead()) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByEnglishLanguageLevel(String englishLanguageLevel) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getEnglishLanguageLevel().equals(englishLanguageLevel)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getProgrammingLanguage().equals(programmingLanguage)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeBySkills(Skills skills) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getSkills().equals(skills)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByTesting(Testing testing) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getTesting().equals(testing)) {
                listResult.add(e);
            }
        }
        return listResult;
    }

    @Override
    public List<Employee> findEmployeeByTools(Tools tools) {
        List<Employee> listResult = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getTools().equals(tools)) {
                listResult.add(e);
            }
        }
        return listResult;
    }
}
