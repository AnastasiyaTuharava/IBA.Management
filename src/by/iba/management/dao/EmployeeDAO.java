package by.iba.management.dao;

import by.iba.management.db.DBConnector;
import by.iba.management.model.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static void removeEmployee(long id) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("delete FROM EMPLOYEE where id = " + id);
        } catch (SQLException ec) {

        }
    }

    public static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("id"));
                employee.setFirstName(rs.getString("name"));
                employee.setLastName(rs.getString("surname"));
                employee.setProjectId(rs.getInt("project_id"));
                employee.setTeamLead(rs.getBoolean("is_teamlead"));
                employee.setPosition(Position.valueOf(rs.getString("position")));
                employee.setEnglishLanguageLevel(EnglishLanguageLevel.valueOf(rs.getString("english_level")));

                Skills skills = new Skills();
                skills.setCss(rs.getBoolean("css"));
                skills.setHtml(rs.getBoolean("html"));
                skills.setJavaScript(rs.getBoolean("js"));
                skills.setjQuery(rs.getBoolean("j_query"));
                skills.setSql(rs.getBoolean("sql"));
                employee.setSkills(skills);

                Tools tools = new Tools();
                tools.setEclipse(rs.getBoolean("eclipse"));
                tools.setIntellijIdea(rs.getBoolean("intellij_idea"));
                tools.setNetBeans(rs.getBoolean("net_beans"));
                tools.setVisualStudio(rs.getBoolean("visual_studio"));
                employee.setTools(tools);

                employeeList.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employeeList;
    }
}
