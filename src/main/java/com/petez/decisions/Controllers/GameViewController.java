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
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
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
    @FXML
    private Button option1Button;
    @FXML
    private Button option2Button;
    @FXML
    private Label cashLabel;
    @FXML
    private ProgressBar coinProgress;
    @FXML
    private ProgressBar peopleProgress;
    @FXML
    private ProgressBar funProgress;
    @FXML
    private ProgressBar businessProgress;
    @FXML
    private ImageView coinPotionImageView;
    @FXML
    private Label coinPotionLabel;
    @FXML
    private ImageView businessPotionImageView;
    @FXML
    private Label businessPotionLabel;
    @FXML
    private ImageView peoplePotionImageView;
    @FXML
    private Label peoplePotionLabel;
    @FXML
    private ImageView funPotionImageView;
    @FXML
    private Label funPotionLabel;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User(1, "Petez", 0);
        System.out.println(user.getName());
        bindComponents(user);
        
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

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private void gameOver(ActionEvent event) throws IOException {
        Stage window = (Stage) option2Button.getScene().getWindow();
        Stage popUpWindow = new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Game Over");
        Parent popUp = FXMLLoader.load(getClass().getResource("/fxml/GameOverPopUpView.fxml"));
        popUpWindow.initOwner(window);
        Scene scene = new Scene(popUp);
        scene.getStylesheets().add("/styles/gameoverpopupview.css");
        popUpWindow.setScene(scene);
        popUpWindow.showAndWait();
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void bindComponents(User user){
        cashLabel.textProperty().bind(user.getCash());
        
        coinProgress.progressProperty().bind(user.getSkills().get(0));
        businessProgress.progressProperty().bind(user.getSkills().get(1));
        peopleProgress.progressProperty().bind(user.getSkills().get(2));
        funProgress.progressProperty().bind(user.getSkills().get(3));
        
        coinPotionLabel.textProperty().bind(user.getPotions().get(0));
        businessPotionLabel.textProperty().bind(user.getPotions().get(1));
        peoplePotionLabel.textProperty().bind(user.getPotions().get(2));
        funPotionLabel.textProperty().bind(user.getPotions().get(3));
        
    }
    
}
