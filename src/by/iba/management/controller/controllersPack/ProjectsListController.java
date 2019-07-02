package by.iba.management.controller.controllersPack;

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
        String search = fxFindProjectTextField.getText();
        Boolean id = fxSearchByProjectId.isSelected();
        Boolean name = fxSearchByProjectName.isSelected();
        if (id){
            FindProjectImpl byId = new FindProjectImpl();
            byId.findProjectById(Long.parseLong(search));
            }
        else if (name){
            FindProjectImpl byName = new FindProjectImpl();
            byName.findProjectByName(search);
        }
    }
}