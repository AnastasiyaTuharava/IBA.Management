package by.iba.management.model.logic.impl;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import by.iba.management.dao.impl.ProjectDAOImpl;
import by.iba.management.model.entity.Employee;
import by.iba.management.model.logic.EditProject;

public class EditProjectImpl implements EditProject {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private final ProjectDAO projectDAO = new ProjectDAOImpl();

    @Override
    public void editProjectName(long projectId, String newProjectName) {
        new FindProjectImpl().findProjectById(projectId).setProjectName(newProjectName);
    }

    @Override
    public void editProjectDescription(long projectId, String newProjectDescription) {
        new FindProjectImpl().findProjectById(projectId).setProjectDescription(newProjectDescription);
    }

    @Override
    public void removeProject(long projectId) {
        for (Employee e : employeeDAO.getEmployees()) {
            if (e.getProjectId() == projectId) {
                e.setProjectId(0);
            }
        }
        projectDAO.removeProject(projectId);
    }
}
