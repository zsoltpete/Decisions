/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petez.decisions.Controllers;

import com.petez.decisions.Models.Question;
import com.petez.decisions.Models.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.input.MouseEvent;
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
    
    @FXML
    private Label questionLabel;
    
    
    Question actualQuestion;
    List<Question> questions;
    StringProperty years = new SimpleStringProperty("0");
    User user;
    @FXML
    private Label yearsLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new User(1, "Petez", 0);
        System.out.println(user.getName());
        
        questions = questions = JSONHandler.readQuestions("file1.txt");
        actualQuestion = questions.get(0);
        bindComponents();
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
    public void bindComponents(){
        cashLabel.textProperty().bind(user.getCash());
        
        coinProgress.progressProperty().bind(user.getSkills().get(0));
        businessProgress.progressProperty().bind(user.getSkills().get(1));
        peopleProgress.progressProperty().bind(user.getSkills().get(2));
        funProgress.progressProperty().bind(user.getSkills().get(3));
        
        coinPotionLabel.textProperty().bind(user.getPotions().get(0));
        businessPotionLabel.textProperty().bind(user.getPotions().get(1));
        peoplePotionLabel.textProperty().bind(user.getPotions().get(2));
        funPotionLabel.textProperty().bind(user.getPotions().get(3));
        
        questionLabel.textProperty().bind(actualQuestion.getName());
        option1Button.textProperty().bind(actualQuestion.getAnswer1());
        option2Button.textProperty().bind(actualQuestion.getAnswer2());
        
    }
    
    public List<Question> initQuestions(){
        List<Question> questions = new ArrayList<Question>();
        
        int i=1;
        questions.add(new Question(i++, "Hogy vagy?", "Jol", "Nem jol", 0.05, 0.1, -0.05, 0.01));
        questions.add(new Question(i++, "Jol szorakozol?", "Nem", "Igen", 0.05, 0.1, -0.05, 0.01));
        questions.add(new Question(i++, "Hideg van", "Nagyon", "Nem", 0.05, 0.1, -0.05, 0.01));

        return questions;
        
    }
    
    public void nextQuestion(){
        int nextYear = Integer.parseInt(years.getValue())+1;
        actualQuestion = questions.get(nextYear);
        years.setValue(String.valueOf(nextYear));
        bindComponents();
    }

    @FXML
    public void option1(ActionEvent event) {
        nextQuestion();
        System.out.println(actualQuestion.getName().getValue());
        
    }

    @FXML
    public void option2(ActionEvent event) {
        nextQuestion();
    }

    @FXML
    public void useCoinPotion(MouseEvent event) throws IOException {
        int selectedPotion = 0;
        updatePotion(selectedPotion);
        
        
    }

    @FXML
    public void useBusinessPotion(MouseEvent event) {
        int selectedPotion = 1;
        updatePotion(selectedPotion);
    }

    @FXML
    public void usePeoplePotion(MouseEvent event) {
        int selectedPotion = 2;
        updatePotion(selectedPotion);
    }

    @FXML
    public void useFunPotion(MouseEvent event) {
        int selectedPotion = 3;
        updatePotion(selectedPotion);
    }
    
    public void updatePotion(int selectedPotion){
        int potionCount = Integer.parseInt(user.getPotions().get(selectedPotion).getValue())-1;
        if(potionCount >=0){
            
            user.getPotions().set(selectedPotion, new SimpleStringProperty(String.valueOf(potionCount)));
            bindComponents();
        }
    }
    
    
}
