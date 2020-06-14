package by.iba.management.dao;

import by.iba.management.model.entity.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getProjects();

    void removeProject(long id);
}
