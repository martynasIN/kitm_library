package org.benedict.library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.benedict.library.Models.Model;
import org.benedict.library.Utilities.AlertUtility;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
       if(Model.getInstance().hasRegisteredUsers()){
           Model.getInstance().getViewFactory().showLoginWindow();
       }else{
           AlertUtility.displayInformation("Prieš pradedant darbą su sistema. Turite registruoti vartototoją");
           Model.getInstance().getViewFactory().showRegsiterWindow();
       }
    }

    public static void main(String[] args) {
        launch();
    }
}