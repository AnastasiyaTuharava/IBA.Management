package by.iba.management.model.logic;

import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Project;
import java.util.List;

public class ProjectLogic {

    public static void editProject(Project project) {
        ProjectDAO.editProject(project);
    }

    public static void removeProject(long projectId) {
        ProjectDAO.removeProject(projectId);
    }

    public static void removeProject(Project project) {
        long id = ProjectLogic.getProject(project.getProjectName()).getProjectId();
        ProjectDAO.removeProject(id);
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
}
