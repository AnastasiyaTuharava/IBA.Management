package by.iba.management.model.entity;

import by.iba.management.dao.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class ProjectTeamRepository {
    private static final ArrayList<Employee> teamList = new ArrayList<>();
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    private ProjectTeamRepository() {
    }

    public static int getTeamSize(long projectId) {
        return teamList.size();
    }

    public List<Employee> getTeamList(long projectId) {
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getProjectId() == projectId) {
                teamList.add(e);
            }
        }
        return teamList;
    }
}
