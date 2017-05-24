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
import javafx.scene.control.Label;
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
    @FXML
    private Label highScoreLabel;
    
    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logger.debug("MenuViewController initialized");
        String location = ".files/last-score.json";
        if(!JSONHandler.isExistLastScore(location)){
            JSONHandler.createFolder(".files");
            JSONHandler.lastScoreWrite(0, location);
        }
        String lastScore = String.valueOf(JSONHandler.lastScoreRead(location));
        highScoreLabel.setText(lastScore);
    }    

    /**
     * An Action Event which run when user click start button.
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
     * An Action Event which run when user click shop button.
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
