/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petez.decisions.Controllers;

import com.petez.decisions.MainApp;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 * Use to navigate to the shop or start the game.
 * @author petez
 */
public class MenuViewController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button shopButton;

    private static Logger logger = LoggerFactory.getLogger(MenuViewController.class);
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logger.debug("MenuViewController initialized");
    }    

    /**
     * Run when user click start button.
     * @param event Click event, when the user click the button.
     * @throws IOException Input, Output Exception
     */
    @FXML
    public void startGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/gameview.css");
        stage.setScene(scene);
    }

    /**
     * Run when user click shop button.
     * @param event Click event, when the user click the button.
     * @throws IOException Input, Output Exception
     */
    @FXML
    public void goShop(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ShopView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/shopview.css");
        stage.setScene(scene);
    }
    
}
