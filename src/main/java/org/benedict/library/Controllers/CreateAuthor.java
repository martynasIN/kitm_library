package org.benedict.library.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.benedict.library.Models.Model;
import org.benedict.library.Utilities.AlertUtility;
import org.benedict.library.Views.MenuItems;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAuthor implements Initializable {
    public TextField fld_firstName;
    public TextField fld_lastName;
    public TextField fld_email;
    public Button create_author_btn;
    public TextField fld_city;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     create_author_btn.setOnAction(event -> onAuthpr());
    }
    private void onAuthpr(){
        String fName = fld_firstName.getText();
        String lName = fld_lastName.getText();
        String email = fld_email.getText();
        String city = fld_city.getText();

        //Create the author
        Model.getInstance().createAuthor(fName, lName,email,city);

        AlertUtility.displayInformation("Autorius sėkmingai sukurtas");

        emptyFields();
    }

    private void emptyFields(){
        fld_firstName.setText("");
        fld_lastName.setText("");
        fld_email.setText("");
        fld_city.setText("");
    }




}
