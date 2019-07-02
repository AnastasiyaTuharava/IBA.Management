package by.iba.management.util;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;

public class ProjectIdGenerator {
    private static long projectId = findLastId();

    public static long getNewProjectId() {
        return ++projectId;
    }

    private static long findLastId() {
        long last = 0;
        for (Project p : ProjectsRepository.getProjectList()) {
            if (p.getProjectId() > last) {
                last = p.getProjectId();
            }
        }
        return last;
    }
}