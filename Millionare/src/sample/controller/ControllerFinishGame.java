package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Model.Record;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFinishGame implements Initializable {
    static String name;
    static int finishBalance;
    static int correctAnswer;

    @FXML
    private Text playerName;
    @FXML
    private Text writeAnswer;
    @FXML
    private Text pointForPlay;

    Record record;
    ControllerRecord controllerRecord = new ControllerRecord();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        informationGame();

    }

    // метод для передачи данных из игры в этот контроллер
    public void setData(String name, int finishBalance, int correctAnswer) {
        this.name = name;
        this.finishBalance = finishBalance;
        this.correctAnswer = correctAnswer;
    }


    // передаем все данные на форму
    public void informationGame() {
        playerName.setText(name);
        pointForPlay.setText(Integer.toString(finishBalance));
        writeAnswer.setText(Integer.toString(correctAnswer));
    }


    // открываем новую форму со всеми результами игр
    @FXML
    public void openRecord() throws IOException {
        //получаем сцену
        Stage stage = (Stage) playerName.getScene().getWindow();
        // закрыаем эту сцену
        stage.close();


        // подгружаем новую сцену
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Record.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Рекорды");
        stage.setScene(new Scene(root1));
        stage.show();
        // создаем новый объект с рекордом
        record = new Record(name, finishBalance, correctAnswer);
        // передаем эти результаты в новую форму
        controllerRecord.addRecord(record);
    }

}
