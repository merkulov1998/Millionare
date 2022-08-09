package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Model.Question;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerQuestion implements Initializable {
    @FXML
    private TextField answers1;
    @FXML
    private TextField answers2;
    @FXML
    private TextField answers3;
    @FXML
    private TextField answers4;
    @FXML
    private TextField question_names;
    @FXML
    private TextField question_balances;
    @FXML
    private ComboBox correct_answer;
    Question question;
    ObservableList<Integer> numbers = FXCollections.observableArrayList(1, 2, 3, 4);
    ArrayList<Question> addQuestion = new ArrayList<>();
    Game game = new Game();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        correct_answer.setItems(numbers);

    }


    public void addQuestion() {
        if (answers1.getText() != null && answers2.getText() != null && answers3.getText() != null && answers4.getText() != null) {
            question = new Question(question_names.getText(),
                    Integer.parseInt(question_balances.getText()),
                    answers1.getText(),
                    answers2.getText(),
                    answers3.getText(),
                    answers4.getText(),
                    ((Integer) correct_answer.getSelectionModel().getSelectedItem()));
            game.addQuestionToArray(question);
            //addQuestion.add(question);
        } else {
            System.out.println("ошибка");
        }

    }

    // очищаем все поля формы
    public void clearForm() {
        question_names.clear();
        question_balances.clear();
        answers1.clear();
        answers2.clear();
        answers3.clear();
        answers4.clear();

    }


    // обработчик кнопки для добавления вопроса
    @FXML
    private void handleButtonClick(ActionEvent mouseEvent) {
        addQuestion();
        // checkArray(addQuestion);
    }

    // при нажатии на кнопку очистка формы
    @FXML
    private void button_clear(ActionEvent mouseEvent) {
        clearForm();
    }
}