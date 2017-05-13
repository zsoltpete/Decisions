/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petez.decisions.Controllers;

import com.petez.decisions.Models.User;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author petez
 */
public class ShopViewController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Label userCoinLabel;
    @FXML
    private Button moneyButton;
    @FXML
    private Button businessButton;
    @FXML
    private Button peopleButton;
    @FXML
    private Button funButton;

    User user;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = UserSettings.user;
        updateButtons();
        bindComponents();
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/menuview.css");
        stage.setScene(scene);
    }

    @FXML
    private void buyCoinPotion(ActionEvent event) {
        updateUserCash(10);
        bindComponents();
    }

    @FXML
    private void buyBusinessPotion(ActionEvent event) {
        updateUserCash(10);
        bindComponents();
    }

    @FXML
    private void buyPeoplePotion(ActionEvent event) {
        updateUserCash(10);
        bindComponents();
    }

    @FXML
    private void buyFunPotion(ActionEvent event) {
        updateUserCash(10);
        bindComponents();
    }
    
    public void updateButtons(){
        int cash = Integer.parseInt(user.getCash().get());
        if(cash<10){
            moneyButton.setDisable(true);
            businessButton.setDisable(true);
            peopleButton.setDisable(true);
            funButton.setDisable(true);
        }
    }
    
    public void bindComponents(){
        userCoinLabel.textProperty().bind(user.getCash());
    }
    
    public void updateUserCash(int value){
        int cash = Integer.parseInt(user.getCash().get());
        user.getCash().setValue(String.valueOf(cash-value));
    }
    
}
