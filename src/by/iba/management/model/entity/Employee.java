package by.iba.management.model.entity;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private long projectId;
    private String projectName;
    private boolean teamLead;
    private Position position;
    private EnglishLanguageLevel englishLanguageLevel;
    private ProgrammingLanguage programmingLanguage;
    private Skills skills;
    private Testing testing;
    private Tools tools;

    public Employee() {
    }

    public Employee(String firstName, String lastName, boolean teamLead, Position position,
                    EnglishLanguageLevel englishLanguageLevel, ProgrammingLanguage programmingLanguage, Skills skills,
                    Testing testing, Tools tools) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamLead = teamLead;
        this.position = position;
        this.englishLanguageLevel = englishLanguageLevel;
        this.programmingLanguage = programmingLanguage;
        this.skills = skills;
        this.testing = testing;
        this.tools = tools;
    }

    public Employee(long employeeId, String firstName, String lastName, long projectId, boolean teamLead,
                    Position position, EnglishLanguageLevel englishLanguageLevel, ProgrammingLanguage programmingLanguage,
                    Skills skills, Testing testing, Tools tools) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectId = projectId;
        this.teamLead = teamLead;
        this.position = position;
        this.englishLanguageLevel = englishLanguageLevel;
        this.programmingLanguage = programmingLanguage;
        this.skills = skills;
        this.testing = testing;
        this.tools = tools;
    }

    //constructor for DEV pattern creation:
    public Employee(boolean teamLead, Position position, EnglishLanguageLevel englishLanguageLevel,
                    ProgrammingLanguage programmingLanguage, Skills skills, Tools tools) {
        this.teamLead = teamLead;
        this.position = position;
        this.englishLanguageLevel = englishLanguageLevel;
        this.programmingLanguage = programmingLanguage;
        this.skills = skills;
        this.tools = tools;
    }

    //constructor for QA pattern creation:
    public Employee(boolean teamLead, Position position, EnglishLanguageLevel englishLanguageLevel,
                    Testing testing) {
        this.teamLead = teamLead;
        this.position = position;
        this.englishLanguageLevel = englishLanguageLevel;
        this.testing = testing;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public boolean isTeamLead() {
        return teamLead;
    }

    public void setTeamLead(boolean teamLead) {
        this.teamLead = teamLead;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EnglishLanguageLevel getEnglishLanguageLevel() {
        return englishLanguageLevel;
    }

    public void setEnglishLanguageLevel(EnglishLanguageLevel englishLanguageLevel) {
        this.englishLanguageLevel = englishLanguageLevel;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Testing getTesting() {
        return testing;
    }

    public void setTesting(Testing testing) {
        this.testing = testing;
    }

    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID " + employeeId +
                ", first name " + firstName +
                ", last name " + lastName +
                ", project ID " + projectId +
                ", team lead " + teamLead +
                ", position " + position +
                ", English level " + englishLanguageLevel + ", " +
                programmingLanguage + ", " + skills + ", " + testing + ", " + tools + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) {
            return false;
        }
        if (projectId != employee.projectId) {
            return false;
        }
        if (teamLead != employee.teamLead) {
            return false;
        }
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) {
            return false;
        }
        if (position != employee.position) {
            return false;
        }
        if (englishLanguageLevel != employee.englishLanguageLevel) {
            return false;
        }
        if (programmingLanguage != null ? !programmingLanguage.equals(employee.programmingLanguage) : employee.programmingLanguage != null) {
            return false;
        }
        if (skills != null ? !skills.equals(employee.skills) : employee.skills != null) {
            return false;
        }
        if (testing != null ? !testing.equals(employee.testing) : employee.testing != null) {
            return false;
        }
        return tools != null ? tools.equals(employee.tools) : employee.tools == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (teamLead ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (englishLanguageLevel != null ? englishLanguageLevel.hashCode() : 0);
        result = 31 * result + (programmingLanguage != null ? programmingLanguage.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (testing != null ? testing.hashCode() : 0);
        result = 31 * result + (tools != null ? tools.hashCode() : 0);
        return result;
    }
}
