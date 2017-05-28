package com.petez.decisions;

import com.petez.decisions.Controllers.UserSettings;
import com.petez.decisions.Models.User;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class of Decisions.
 * @author petez
 */
public class MainApp extends Application {

    /**
     * Start the program.
     * @param stage Main window
     * @throws Exception Exception if file doesn't exist
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameView.fxml"));
        
        User user = new User(11, "Petez", 0);
        UserSettings.user = user;
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/menuview.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
