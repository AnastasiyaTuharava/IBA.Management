package by.iba.management.model.logic.impl;

import by.iba.management.dao.ProjectDAO;
import by.iba.management.dao.impl.ProjectDAOImpl;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.FindProject;

public class FindProjectImpl implements FindProject {

    private final ProjectDAO projectDAO = new ProjectDAOImpl();

    @Override
    public Project findProjectById(long projectId) {
        Project result = new Project();
        for (Project p : projectDAO.getProjects()) {
            if (p.getProjectId() == projectId) {
                result = p;
            }
        }
        return result;
    }

    @Override
    public Project findProjectByName(String projectName) {
        Project result = new Project();
        for (Project p : projectDAO.getProjects()) {
            if (p.getProjectName().equals(projectName)) {
                result = p;
            }
        }
        return result;
    }
}
