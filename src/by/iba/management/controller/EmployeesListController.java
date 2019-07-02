package by.iba.management.controller;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.logic.FindEmployee;
import by.iba.management.model.logic.impl.FindEmployeeImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class EmployeesListController {

    @FXML
    private Button fxFindEmployeeButton;
    private RadioButton fxSearchByEmployeeId;
    private RadioButton fxSearchByEmployeeName;


    @FXML
    private void findEmployee(ActionEvent event, Employee employee){
        if (fxSearchByEmployeeId.isSelected()){
            findEmployee(event, employee);
        }
    }

}