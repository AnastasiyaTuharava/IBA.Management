package by.iba.management.model.logic;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Project;

import java.util.List;

public class ProjectLogic {

    public static void updateProject(Project project, List<Long> employeeIds, List<Long> teamEmployeeIds) {
        ProjectDAO.updateProject(project);
        EmployeeDAO.removeProjectFormEmployee(project.getProjectId(), employeeIds, teamEmployeeIds);
    }

    public static void removeProject(long projectId) {
        ProjectDAO.removeProject(projectId);
    }

    public static void removeProject(Project project) {
        long id = ProjectLogic.getProject(project.getProjectName()).getProjectId();
        ProjectDAO.removeProject(id);
    }

    public static void unassignEmployee(long projectId){
        EmployeeDAO.unassignEmployee(projectId);
    }

    public static void addProject(Project project) {
        ProjectDAO.addProject(project);
    }

    public static Project getProject(long projectId) {
        return ProjectDAO.getProject(projectId);
    }

    public static Project getProject(String projectName) {
        return ProjectDAO.getProject(projectName);
    }

    public static List<Project> getProjects() {
        return ProjectDAO.getProjects();
    }

    public static List<Project> findProjectsByName(String name) {
        return ProjectDAO.findProjectsByName(name);
    }
}
