package by.iba.management.view.fxml;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.impl.FindProjectImpl;
import by.iba.management.util.ProjectIdGenerator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProjectsListController {

    @FXML
    Button fxFindProjectButton;
    RadioButton fxSearchByProjectId;
    RadioButton fxSearchByProjectName;
    TextField fxFindProjectTextField;
    TableView projectsListTable;
    TableColumn fxProjectId;
    TableColumn fxProjectName;
    TableColumn fxProjectDescription;

    @FXML
    private void displayProjectsList() {
        ObservableList<Project> projectsList =
                FXCollections.observableArrayList(ProjectsRepository.getProjectList());
        for (Project p : projectsList) {
            fxProjectId.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectId());
            fxProjectName.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectName()));
            fxProjectDescription.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectDescription()));
            projectsListTable.setItems(projectsList);
        }
    }

    @FXML
    private void findProject(ActionEvent event) {
        fxFindProjectTextField.setPromptText("Search");
        ListView list = new ListView();

        list.setMaxHeight(180);
        ObservableList<Project> projectsList =
                FXCollections.observableArrayList(ProjectsRepository.getProjectList());
        projectsListTable.setItems(projectsList);

        String searchField = fxFindProjectTextField.getText();
        Boolean id = fxSearchByProjectId.isSelected();
        Boolean name = fxSearchByProjectName.isSelected();
        ToggleGroup tg = new ToggleGroup();
        fxSearchByProjectId.setToggleGroup(tg);
        fxSearchByProjectName.setToggleGroup(tg);

        fxFindProjectButton.setOnAction(event -> {
            RadioButton rb = (RadioButton)tg.getSelectedToggle();
            if (rb.equals(fxSearchByProjectId)){
                FindProjectImpl searchReasultById = new FindProjectImpl();
                searchReasultById.findProjectById(Long.parseLong(searchField));
            }
            if (rb.equals(fxSearchByProjectName)){
                FindProjectImpl searchResultByName = new FindProjectImpl();
                searchResultByName.findProjectByName(searchField);
            }
        });


    }
    public void handleSearchByKey2(String oldVal, String newVal) {
        ObservableList<Project> projectsList =
                FXCollections.observableArrayList(ProjectsRepository.getProjectList());
        // If the number of characters in the text box is less than last time
        // it must be because the user pressed delete
        if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
            // Restore the lists original set of entries
            // and start from the beginning
            projectsListTable.setItems(projectsList);
        }

        // Break out all of the parts of the search text
        // by splitting on white space
        String[] parts = newVal.toUpperCase().split(" ");

        // Filter out the entries that don't contain the entered text
        ObservableList<String> subentries = FXCollections.observableArrayList();
        for ( Object entry: projectsListTable.getItems() ) {
            boolean match = true;
            String entryText = (String)entry;
            for ( String part: parts ) {
                // The entry needs to contain all portions of the
                // search string *but* in any order
                if ( ! entryText.toUpperCase().contains(part) ) {
                    match = false;
                    break;
                }
            }

            if ( match ) {
                subentries.add(entryText);
            }
        }
        projectsListTable.setItems(subentries);
    }
}