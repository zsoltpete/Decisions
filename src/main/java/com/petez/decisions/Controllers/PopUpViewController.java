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
 * Control pop up views.
 * @author petez
 */
public class PopUpViewController implements Initializable {

    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    
    /**
     * Use to contain parent stage.
     * Use when back to the parent.
     */
    public Stage parentStage; 

    /**
     * Set parent stage.
     * @param parentStage Represent the descent stage
     */
    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Run when user click ok button.
     * Go back to the parent stage.
     * @param event Click event, when the user click the button.
     * @throws IOException Input, Output Exception
     */
    @FXML
    public void okButtonPushed(ActionEvent event) throws IOException {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        
        Stage parentWindow = (Stage) stage.getOwner();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/menuview.css");
        parentWindow.setScene(scene);
    }

    /**
     * Run when user click cancel button.
     * @param event Click event, when the user click the button.
     */
    @FXML
    public void cancelButtonPushed(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        
    }
    
}
