package by.iba.management.model.logic;

import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Project;
import java.util.List;

public class ProjectLogic {

    public static void editProject(Project project) {

    }

    public static void removeProject(long projectId) {
        ProjectDAO.removeProject(projectId);
    }

    public static void addProject(Project project) {

    }

    public static Project getProject(long projectId) {
        return null;
    }

    public static Project getProject(String projectName) {
        return null;
    }

    public static List<Project> getProjects() {
        return ProjectDAO.getProjects();
    }
}
