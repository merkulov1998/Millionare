package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    // инициализируем переменные с формы fxml
    @FXML
    private Button btn_newPlay;

    @FXML
    private Button btn_newQuestion;

    @FXML
    private Button btn_record;
    /*  @FXML
      private Button btn_record;*/
    Parent root;

    // метод для обработки нажатия кнопок на форме
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btn_newPlay) {
            loadStage("/sample/fxml/start.fxml");
        } else if (mouseEvent.getSource() == btn_newQuestion) {
            loadStage("/sample/fxml/addQuestion.fxml");
        }
        else if (mouseEvent.getSource() == btn_record) {
            loadStage("/sample/fxml/Record.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    // загрузка сцены
    private void loadStage(String fxml) {
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.initModality(Modality.NONE);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
