package org.benedict.library.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.benedict.library.Models.Model;
import org.benedict.library.Views.MenuItems;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button logout_btn;
    public Text current_user_text;
    public Button authors_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Show logged user name in menu
       current_user_text.setText(Model.getInstance().getLoggedUserName());
        //Add listeners to the menu buttons
        addListeners();
    }

    private void addListeners(){

        logout_btn.setOnAction(event -> onLogout());
        authors_btn.setOnAction(event -> onAuthors());
    }


    /**
     * Handle authors window
     */

    public void onAuthors(){
        //Navigate to author window
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(MenuItems.AUTHORS);
    }

    /**
     * Handle logout event
     */

    public void onLogout(){
        //Create stage
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        //Close stage
        Model.getInstance().getViewFactory().closeStage(stage);
        //Show login window
        Model.getInstance().getViewFactory().showLoginWindow();
        //Destroy login flag
        Model.getInstance().setLoginSuccessFlag(false);
    }
}
