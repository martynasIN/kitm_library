package org.benedict.library.Utilities;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.benedict.library.Models.Author;


import java.util.Optional;

public class DialogUtility {

    /**
     * Displays dialog for editing Author information
     * @param author - the Author object fo editing
     */

    public static Optional<Author> showEditAuthorDialog(Author author){
        Dialog<Author> dialog = new Dialog();
        dialog.setTitle("Redaguoti autoriu");
        dialog.setHeaderText("Redaguokite pasirinkto autoriaus duomenis");

        ButtonType saveButtonType = new ButtonType("Issaugoti", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField firstNameField = new TextField(author.getFirstName());
        TextField lastNameField = new TextField(author.getLastName());
        TextField emailField = new TextField(author.getEmail());
        TextField cityField = new TextField(author.getCity());

        grid.add(new Label("Vardas:"),0,0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Pavarde:"),0,1);
        grid.add(lastNameField, 1,1);
        grid.add(new Label("El. pastas:"),0,2);
        grid.add(emailField,1,2);
        grid.add(new Label("Miestas:"), 0,3);
        grid.add(cityField, 1,3);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton ->{
             if(dialogButton == saveButtonType){
                 author.setFirstName(firstNameField.getText().trim());
                 author.setLastName(lastNameField.getText().trim());
                 author.setEmail(emailField.getText().trim());
                 author.setCity(cityField.getText().trim());
             }
             return author;
        });

        return dialog.showAndWait();
    }


}
