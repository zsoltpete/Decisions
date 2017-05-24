/*
 * The MIT License
 *
 * Copyright 2017 Zsolt Pete.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
    int cash;
    ShopHandler shopHandler;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = UserSettings.user;
        cash = Integer.parseInt(user.getCash().get());
        
        shopHandler = new ShopHandler();
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
        user.getCash().setValue(String.valueOf(shopHandler.updateUserCash(cash,10)));
        user = shopHandler.incrementPotion(user, 0);
        bindComponents();
    }

    @FXML
    private void buyBusinessPotion(ActionEvent event) {
        user.getCash().setValue(String.valueOf(shopHandler.updateUserCash(cash,10)));
        user = shopHandler.incrementPotion(user, 1);
        bindComponents();
    }

    @FXML
    private void buyPeoplePotion(ActionEvent event) {
        user.getCash().setValue(String.valueOf(shopHandler.updateUserCash(cash,10)));
        user = shopHandler.incrementPotion(user, 2);
        bindComponents();
    }

    @FXML
    private void buyFunPotion(ActionEvent event) {
        
        user.getCash().setValue(String.valueOf(shopHandler.updateUserCash(cash,10)));
        user = shopHandler.incrementPotion(user, 3);
        bindComponents();
    }
    
    /**
     * Update buttons state.
     * If the user has no enough money can't buy anything.
     */
    public void updateButtons(){
        int cash = Integer.parseInt(user.getCash().get());
        if(shopHandler.userCanBuy(cash)){
            moneyButton.setDisable(true);
            businessButton.setDisable(true);
            peopleButton.setDisable(true);
            funButton.setDisable(true);
        }else{
            moneyButton.setDisable(false);
            businessButton.setDisable(false);
            peopleButton.setDisable(false);
            funButton.setDisable(false);
        }
    }
    
    /**
     * Binding properties to the view.
     */
    public void bindComponents(){
        userCoinLabel.textProperty().bind(user.getCash());
        updateButtons();
    }
    
    

    
}
