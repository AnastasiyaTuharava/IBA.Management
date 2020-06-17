package by.iba.management.dao.impl;

import by.iba.management.dao.ProjectDAO;
import by.iba.management.db.DBConnector;
import by.iba.management.model.entity.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    public List<Project> getProjects() {
        List<Project> projectList = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("id"));
                project.setProjectName(rs.getString("name"));
                project.setProjectDescription(rs.getString("description"));
                projectList.add(project);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return projectList;
    }

    @Override
    public void removeProject(long id) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery("DELETE FROM PROJECT WHERE ID=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
