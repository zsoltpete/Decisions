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
public class PopUpViewController implements Initializable {

    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    
    public Stage parentStage; 

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okButtonPushed(ActionEvent event) throws IOException {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        
        Stage parentWindow = (Stage) stage.getOwner();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/menuview.css");
        parentWindow.setWidth(600);
        parentWindow.setHeight(496);
        parentWindow.setScene(scene);
    }

    @FXML
    private void cancelButtonPushed(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        
    }
    
}
