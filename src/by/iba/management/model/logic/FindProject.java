package by.iba.management.model.logic;

import by.iba.management.model.entity.Project;
import java.util.List;

public interface FindProject {

     Project findProjectById(long projectId);
     Project findProjectByName(String projectName);
}


