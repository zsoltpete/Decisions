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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author petez
 */
public class MenuViewController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button shopButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/gameview.css");
        stage.setScene(scene);
    }
    
}
