package by.iba.management.controller;

import by.iba.management.model.logic.impl.FindProjectImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ProjectsListController {

    @FXML
    Button fxFindProjectButton;
    RadioButton fxSearchByProjectId;
    RadioButton fxSearchByProjectName;
    TextField fxFindProjectTextField;

    @FXML
    private void findEmployee(ActionEvent event){
        String searchField = fxFindProjectTextField.getText();
        Boolean id = fxSearchByProjectId.isSelected();
        Boolean name = fxSearchByProjectName.isSelected();

        if (id){
            FindProjectImpl byId = new FindProjectImpl();
            byId.findProjectById(Long.parseLong(searchField));
            }
        else if (name){
            FindProjectImpl byName = new FindProjectImpl();
            byName.findProjectByName(searchField);
        }
    }
}