package by.iba.management.dao;

import by.iba.management.model.entity.Project;

import java.util.List;

public interface ProjectDAOold {

    List<Project> getProjects();

    void removeProject(long projectId);

    void addProject(Project project);

    void editProject(Project project);

    Project getProject(long projectId);
}
