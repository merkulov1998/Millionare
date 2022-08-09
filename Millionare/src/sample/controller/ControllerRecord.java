package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Model.Record;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRecord implements Initializable {


    static ObservableList<Record> observableList = FXCollections.observableArrayList();
    @FXML
    private TableView<Record> tableRecord;

    @FXML
    private TableColumn<Record, String> columnName;
    @FXML
    private TableColumn<Record, Integer> balance;
    @FXML
    private TableColumn<Record, Integer> correctAnswer;

    Record record;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // устанавливаем тип и значение которое должно хранится в колонке
        columnName.setCellValueFactory(new PropertyValueFactory<Record, String>("name"));
        balance.setCellValueFactory(new PropertyValueFactory<Record, Integer>("finishBalance"));
        correctAnswer.setCellValueFactory(new PropertyValueFactory<Record, Integer>("correctsAnswer"));


        // заполняем таблицу данными
        tableRecord.setItems(observableList);

    }

    // добавляем результаты игры в таблицу
    public void addRecord(Record record) {

        observableList.add(record);
    }


}
