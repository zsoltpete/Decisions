/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petez.decisions.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author petez
 */
public class GameViewController implements Initializable {

    @FXML
    private Button backButton;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    /**
     * Action to go back to the Main menu
     * @param event
     */
    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Stage window = (Stage) backButton.getScene().getWindow();
        Stage popUpWindow = new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Are you sure?");
        Parent popUp = FXMLLoader.load(getClass().getResource("/fxml/PopUpView.fxml"));
        popUpWindow.initOwner(window);
        Scene scene = new Scene(popUp);
        scene.getStylesheets().add("/styles/popupview.css");
        popUpWindow.setScene(scene);
        popUpWindow.showAndWait();
    }
    
}
