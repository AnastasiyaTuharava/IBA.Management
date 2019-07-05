package by.iba.management.model.logic.impl;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.FindProject;

public class FindProjectImpl implements FindProject {
    @Override
    public Project findProjectById(long projectId) {
        Project result = new Project();
        for (Project p : ProjectsRepository.getProjectList()) {
            if (p.getProjectId() == projectId) {
                result = p;
            }
        }
        return result;
    }

    @Override
    public Project findProjectByName (String projectName) {
        Project result = new Project();
        for (Project p : ProjectsRepository.getProjectList()) {
            if (p.getProjectName().equals(projectName)) {
                result = p;
            }
        }
        return result;
    }
}


