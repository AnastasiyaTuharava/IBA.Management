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
            stmt.execute("delete FROM EMPLOYEE where id = " + id);
        } catch (SQLException ec) {
            ec.printStackTrace();
        }
    }

    public static void unassignEmployee(long projectId){
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("update EMPLOYEE set PROJECT_ID = null where project_id = " + projectId);
        } catch (SQLException ec) {
            ec.printStackTrace();
        }
    }

    public static void updateEmployee(Employee employee) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("UPDATE EMPLOYEE SET " +
                    "NAME ='" + employee.getFirstName() + "' , " +
                    "SURNAME ='" + employee.getLastName() + "' , " +
                    "PROJECT_ID ='" + employee.getProjectId() + "' , " +
                    "IS_TEAMLEAD ='" + employee.isTeamLead() + "' , " +
                    "POSITION ='" + employee.getFirstName() + "' , " +
                    "ENGLISH_LEVEL ='" + employee.getEnglishLanguageLevel() + "' , " +
                    "JAVA ='" + employee.getProgrammingLanguage().isJava() + "' , " +
                    "C_PLUS_PLUS ='" + employee.getProgrammingLanguage().iscPlusPlus() + "' , " +
                    "C_SHARP ='" + employee.getProgrammingLanguage().iscSharp() + "' , " +
                    "PHP ='" + employee.getProgrammingLanguage().isPhp() + "' , " +
                    "DOT_NET ='" + employee.getProgrammingLanguage().isDotNet() + "' , " +
                    "SQL ='" + employee.getSkills().isSql() + "' , " +
                    "JS ='" + employee.getSkills().isJavaScript() + "' , " +
                    "HTML ='" + employee.getSkills().isHtml() + "' , " +
                    "CSS ='" + employee.getSkills().isCss() + "' , " +
                    "J_QUERY ='" + employee.getSkills().isjQuery() + "' , " +
                    "MANUAL_QA ='" + employee.getTesting().isManual() + "' , " +
                    "AUTO_QA ='" + employee.getTesting().isAutomation() + "' , " +
                    "DESKTOP_TESTING ='" + employee.getTesting().isTestingDeskTopApplications() + "' , " +
                    "MOBILE_TESTING ='" + employee.getTesting().isTestingMobileApplications() + "' , " +
                    "VISUAL_STUDIO ='" + employee.getTools().isVisualStudio() + "' , " +
                    "INTELLIJ_IDEA ='" + employee.getTools().isIntellijIdea() + "' , " +
                    "ECLIPSE ='" + employee.getTools().isEclipse() + "' , " +
                    "NET_BEANS ='" + employee.getTools().isNetBeans() + "' " +

                    "WHERE ID =" + employee.getEmployeeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeProjectFormEmployee(long projectId, List<Long> employeeIds, List<Long> teamEmployeeIds) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            for (Long id : employeeIds) {
                stmt.executeUpdate("UPDATE EMPLOYEE SET " +
                        "PROJECT_ID = NULL " +
                        "WHERE ID=" + id);
            }
            for (Long id : teamEmployeeIds) {
                stmt.executeUpdate("UPDATE EMPLOYEE SET " +
                        "PROJECT_ID = '" + projectId + "'" +
                        "WHERE ID=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee getEmployee(long id) {
        Connection connection = DBConnector.getConnection();
        Employee employee = new Employee();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + id);
            while (rs.next()) {

                employee.setEmployeeId(rs.getInt("id"));
                employee.setFirstName(rs.getString("name"));
                employee.setLastName(rs.getString("surname"));
                employee.setProjectId(rs.getInt("project_id"));
                employee.setTeamLead(rs.getBoolean("is_teamlead"));
                employee.setPosition(Position.valueOf(rs.getString("position")));
                employee.setEnglishLanguageLevel(EnglishLanguageLevel.valueOf(rs.getString("english_level")));

                ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
                programmingLanguage.setJava(rs.getBoolean("java"));
                programmingLanguage.setcPlusPlus(rs.getBoolean("c_plus_plus"));
                programmingLanguage.setcSharp(rs.getBoolean("c_sharp"));
                programmingLanguage.setDotNet(rs.getBoolean("dot_net"));
                programmingLanguage.setPhp(rs.getBoolean("php"));
                employee.setProgrammingLanguage(programmingLanguage);

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

                Testing testing = new Testing();
                testing.setAutomation(rs.getBoolean("auto_qa"));
                testing.setManual(rs.getBoolean("manual_qa"));
                testing.setTestingDeskTopApplications(rs.getBoolean("desktop_testing"));
                testing.setTestingMobileApplications(rs.getBoolean("mobile_testing"));
                employee.setTesting(testing);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getEmployee(String firstName, String lastName) {
        List<Employee> employees = new ArrayList<>();
        // TODO: 30.06.2020
        return employees;
    }

    public static void addEmployee(Employee employee) {
            Connection connection = DBConnector.getConnection();
            try {
                Statement stmt = connection.createStatement();
                stmt.execute("INSERT INTO EMPLOYEE (name, surname, project_id, is_teamLead, position, " +
                        "english_level, java, c_plus_plus, c_sharp,php, dot_net, sql, js, html, css, j_query, " +
                        "manual_qa, auto_qa,desktop_testing,mobile_testing, visual_studio,intellij_idea,eclipse,net_beans) " + "VALUES ('"
                                + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getProjectId() + "', '" +
                                        employee.isTeamLead() + "', '" + employee.getPosition() + "', '" +
                                        employee.getEnglishLanguageLevel() + "', '" + employee.getProgrammingLanguage().isJava() + "', '" +
                                        employee.getProgrammingLanguage().iscPlusPlus() + "', '" + employee.getProgrammingLanguage().iscSharp() + "', '" +
                                        employee.getProgrammingLanguage().isPhp() + "', '" + employee.getProgrammingLanguage().isDotNet() + "', '" +
                                        employee.getSkills().isSql() + "', '" + employee.getSkills().isJavaScript() + "', '" +
                                        employee.getSkills().isHtml() + "', '" + employee.getSkills().isCss() + "', '" + employee.getSkills().isjQuery() + "', '" +
                                        employee.getTesting().isManual() + "', '" + employee.getTesting().isAutomation() + "', '" +
                                        employee.getTesting().isTestingDeskTopApplications() + "', '" + employee.getTesting().isTestingMobileApplications() + "', '" +
                                        employee.getTools().isVisualStudio() + "', '" +  employee.getTools().isIntellijIdea() + "', '" +
                                employee.getTools().isEclipse() + "', '" + employee.getTools().isNetBeans() + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static List<Employee> getEmployeesAndProject() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE e LEFT JOIN PROJECT p ON p.ID_PROJECT = e.PROJECT_ID");
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("id"));
                employee.setFirstName(rs.getString("name"));
                employee.setLastName(rs.getString("surname"));
                employee.setProjectId(rs.getInt("project_id"));
                employee.setProjectName(rs.getString("name_project"));
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

    public static List<Employee> findEmployeesByName(String employeeName) {
        Connection connection = DBConnector.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE NAME LIKE '%" + employeeName.toLowerCase() + "%' OR " +
                    "NAME LIKE '%" + employeeName.toUpperCase() + "%' OR SURNAME LIKE '%" + employeeName.toLowerCase() + "%' OR " +
                    "SURNAME LIKE '%" + employeeName.toUpperCase() + "%'");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
