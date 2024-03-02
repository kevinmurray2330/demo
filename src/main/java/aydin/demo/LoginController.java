package aydin.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Button signinButton;


    @FXML
    protected void onSigninButtonClick() throws IOException {

         FXMLLoader fxmlLoader = new FXMLLoader(DemoApp.class.getResource("dbAccess.fxml"));
         Stage stage = DemoApp.getStage();
         Scene scene = DemoApp.getScene();
        try {
            scene.setRoot(fxmlLoader.load());
            stage.setTitle("Demo: DBAccess");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}