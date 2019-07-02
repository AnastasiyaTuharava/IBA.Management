package by.iba.management.model.logic;

import by.iba.management.model.entity.Project;
import java.util.List;

public interface FindProject {

     List<Project> findProjectById(long projectId);
     List<Project> findProjectByName(String projectName);
}


