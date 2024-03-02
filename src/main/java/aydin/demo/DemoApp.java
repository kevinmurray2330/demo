package aydin.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoApp extends Application {
    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage theStage) throws IOException {

        stage = theStage;
        FXMLLoader fxmlLoader = new FXMLLoader(DemoApp.class.getResource("login.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);
        stage.setTitle("Demo: Login");
        stage.show();
      }

      static Scene getScene(){
        return scene;
      }

    static Stage getStage(){
        return stage;
    }


    public static void main(String[] args) {
        launch();
    }
}
