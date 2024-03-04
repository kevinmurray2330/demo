package aydin.demo;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.util.StringConverter;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Button signinButton;
    @FXML
    Slider fontSizeSlider;
    @FXML
    TextField fontSizeTextField;

    public void initialize(){

        //example of adding a unidirectional binding:
        // if username or password is empty, signin buttom is disabled
        signinButton.disableProperty().bind(
                usernameTextField.textProperty().isEmpty().or(passwordTextField.textProperty().isEmpty()));

        // example of bidirectional binding:
        // the fontSize text field and fontSize slider grow or reduce together
        fontSizeTextField.textProperty().bindBidirectional(fontSizeSlider.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return number.toString();
            }

            @Override
            public Number fromString(String s) {
                return Double.parseDouble(s);
            }
        });

        // example of adding a listener to a property (observable value): value property of the fontSize slider
        // tahat will cause the text field fonts to change according to the slider value
        fontSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue,
                                Number oldValue, Number newValue) {

                usernameTextField.setFont(new Font(newValue.doubleValue()));
                passwordTextField.setFont(new Font(newValue.doubleValue()));

            }
        });
    }
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