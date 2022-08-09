package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {//входная точка приложения(главный метод JavaFX)
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
        primaryStage.setTitle("Millionare");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);//запуск приложения JavaFX

    }

}
