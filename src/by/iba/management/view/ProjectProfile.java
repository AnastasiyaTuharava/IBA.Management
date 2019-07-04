package by.iba.management.view;

import by.iba.management.util.ProjectIdGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProjectProfile {
        JTextArea jProjectIdField;
        JTextField jProjectNameField;
        JTextField jProjectDescriptionField;
        JFrame jFrame;

        public ProjectProfile() {
            JLabel jprojectIdLabel = new JLabel("Project ID");
            JLabel jprojectNameLabel = new JLabel("Project Name");
            JLabel jProjectDescriptionLabel = new JLabel("Project Description");
            jFrame = new JFrame("Project Profile");
// применить поточную компоновку
            jFrame.setLayout(new FlowLayout());
// ввести текстовое поле на панель содержимого
            jProjectIdField = new JTextArea();
            jProjectNameField = new JTextField(15);
            jProjectNameField.setActionCommand("projectName");
            jProjectDescriptionField = new JTextField(15);
            jProjectDescriptionField.setActionCommand("projectDescription");
// установить исходные размеры фрейма
            jFrame.setSize(1000, 1000);
            ActionListener actionListener = ae -> {//отобразить текст, когда пользователь нажимает клавишу <Enter>
                if (jProjectNameField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Project Name cannot be empty!", "alert",
                            JOptionPane.ERROR_MESSAGE);
                }
                //jProjectIdField.setText(jProjectIdField.setText(String.valueOf(ProjectIdGenerator.getNewProjectId())));
                jProjectNameField.setText(jProjectNameField.getText());
                jProjectDescriptionField.setText("");

        };
//завершить работу приложения, если пользователь закрывает окно
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //jProjectIdField.addActionListener(actionListener);
            jProjectNameField.addActionListener(actionListener);
            jFrame.add(jprojectIdLabel);
            jFrame.add(jprojectNameLabel);
            jFrame.add(jProjectDescriptionLabel);
            jFrame.add(jProjectIdField);
            jFrame.add(jProjectNameField);
            jFrame.add(jProjectDescriptionField);
// отобразить фрейм
            jFrame.setVisible(true);
        }
        public static void main(String args[]) {
// создать фрейм в потоке диспетчеризации событий
            SwingUtilities.invokeLater(() -> new ProjectProfile());
        }
}
