package by.iba.management.model.logic.impl;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.logic.UpdateProjectTeamList;

import java.util.ArrayList;

public class UpdateProjectTeamListImpl implements UpdateProjectTeamList {
    private ArrayList<Employee> teamList = new ArrayList<>();

    @Override
    public void addTeamMember(Employee employee) {
        teamList.add(employee);
    }

    @Override
    public void removeTeamMember(Employee employee) {
        teamList.remove(employee);
    }
}
