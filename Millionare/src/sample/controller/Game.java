package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Model.Player;
import sample.Model.Question;
import sample.Start;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Game implements Initializable {

    // инициализируем кнопки и текстовые поля на форме
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Button answer4;

    @FXML
    private TextField questionName;
    @FXML
    private Text question1;

    @FXML
    private Text question2;
    @FXML
    private Text question3;
    @FXML
    private Text question4;

    @FXML
    private VBox vBox;

    @FXML
    private Text player_name;
    @FXML
    private Text player_balance;


    @FXML
    private Text number_question;
    @FXML
    private Text question_price;

    @FXML
    private Button btn_skipQuestion;

    @FXML
    private Text answerTrue;
    @FXML
    private Text answerFalse;

    @FXML
    private Text Text_error;
    // верный ответ
    int rightNumber;
    // текуший вопрос
    int currentQuestion;
    // баллы за вопрос
    int balanceQuestion;
    // ссылка на объект Question
    Question question;
    // создаем нового пользователя
    Player player = new Player("andrey", 0);
    // делаем ссылку для передачи итогов игры
    ControllerFinishGame finishGame = new ControllerFinishGame();
    int[] checkNumber = new int[10];
    // объявляем 2 массива для списка всех существующих вопросов
    ArrayList<Question> questions = new ArrayList<>();
    // тут будет хранится вопросы в текущей игре
    ArrayList<Question> questionsGame = new ArrayList<>();
    // счетчики для вопросов
    int counterAnswerTrue;
    int counterAnswerFalse;
    //int current = 1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // создаем блок вопросов и заполняем arraylist номера после вопросов добавил для проверки работоспособности
        questions.add(new Question("Какой оператор не может использоваться в условном выражении в цикле for?", 5, "!>", "!=", "==", ">", 1));
        questions.add(new Question("Что используется для завершения цикла?", 5, "catch", "break", "switch", "continue", 2));
        questions.add(new Question("Циклы какого типа считаются циклами после тестирования?", 5, "while", "for", "do-while", "foreach", 3));
        questions.add(new Question("Какое утверждение о бесконечном цикле неверно?", 5, "Чтобы избежать бесконечного цикла, в результате выполнения тела цикла while в конечном итоге условие должно принять значение false.", "Бесконечный цикл обычно является результатом синтаксической ошибки", "Бесконечный цикл обычно вызван ошибкой программирования.", "Бесконечный цикл — это код, который выполняется до тех пор, пока пользователь не прервет программу.", 2));

        questions.add(new Question("Что означает ключевое слово extends?", 5, "Что данные класс наследуется от другого.", "Что это дополнительный модуль класса, который расширяет его свойства.", "Что два класса делают одно и то же.", "\n" +
                "Что это самый большой класс в программе.", 1));
        questions.add(new Question("Для чего используется оператор NEW?", 5, "Для создания новой переменной.", "Для объявления нового класса.", "Для создания экземпляра класса.", "Это антагонист оператора OLD.", 3));
        questions.add(new Question("Как объявить класс в коде?", 5, "class MyClass {}", "new class MyClass {}", "select * from class MyClass {}", "MyClass extends class {}", 1));
        questions.add(new Question("Что такое класс в Java?", 5, "Уровень сложности программы. Все операторы делятся на классы в зависимости от сложности их использования.", "Базовый элемент объектно-ориентированного программирования в языке Java.", "Просто одно из возможных названий переменной.", "\n" +
                "Такое понятие есть только в C++, в Java такого понятия нет.", 2));
        questions.add(new Question("Как можно уничтожить объект в Java?", 5, "присвоить null всем ссылкам на объект", "вызвать Runtime.getRuntime().gc()", " вызвать метод finalize() у объекта", "этого нельзя сделать вручную", 3));
        questions.add(new Question("java.lang.ArrayIndexOutOfBoundsException Что оно означает ?", 5, "Ошибка означает переполнение памяти.", "Ошибка означает выход за рамки границ массива.", "ошибка заполнения массива" +
                "Ошибка означает попытку вставить в массив некорректное значение.", "На самом деле этот код не вызовет ошибку.", 2));
        questions.add(new Question("Что означает перегрузка метода в Java (overload).", 5, "Изменение поведения метода класса относительно родительского.", "Изменение поведения метода класса относительно дочернего.", "Несколько методов с одинаковым названием, но разным набором параметров." +
                "Несколько методов с одинаковым названием, но разным набором параметров.", "Несколько разных классов с одинаковым методом.", 3));

        // создаем список вопросов для игры из общего списка
        if (currentQuestion == 0) {
            try {
                questionsGame(questions);
            } catch (NullPointerException e) {
                Text_error.setText("Ошибка. Не хватает вопросов для игры (((");
            }
        }
        try {
            // устанавливаем текущий вопрос
            setQuestion(questionsGame.get(currentQuestion));
        } catch (IndexOutOfBoundsException e) {
            Text_error.setText("Ошибка. Вышли за границы сознания и вопросов нет");
        }

        // ФИО и баланс пользователя
        information_player();

    }


    // создаем список вопросов для игры из общего списка
    public void questionsGame(ArrayList<Question> questions) throws NullPointerException {
        ArrayList<Question> clone = questions;
        // создаем объект для рандомного номера
        Random random = new Random();
        int i = 0;
        // заполняем массив. максимум  10 вопросов. список вопросов не должен быть пустой
        while (clone != null && i < 10) {

            // получаем рандомный номер вопроса от 0 до максимального размера arraylist всех вопросов (questions)
            int numberQuestion = random.nextInt(clone.size());
            // проверяем на пустой массив
            questionsGame.add(clone.get(numberQuestion));
            clone.remove(numberQuestion);

            i++;


        }
    }

    // для передачи добавленного вопроса из сцены добавления вопроса в общий масив вопросов
    public void addQuestionToArray(Question question) {
        questions.add(question);
    }

    // устанавливаем вопросы в панель интерфейса
    // throws нужен для обработки исключений выход за границы массива
    public void setQuestion(Question question) throws NullPointerException {


        ArrayList<String> answer = question.getAnswer();
        questionName.setText(question.getName());

        question1.setText(answer.get(0));

        question2.setText(answer.get(1));
        question3.setText(answer.get(2));
        question4.setText(answer.get(3));
        rightNumber = question.getCorrectAnswer();
        balanceQuestion = question.getBalance();
    }

    // информация о пользователе в блоке
    public void information_player() {
        player_name.setText(player.getName());
        player_balance.setText(Integer.toString(player.getBalance()));

    }

    // информация о игре
    public void information_game() {
        question_price.setText(Integer.toString(balanceQuestion));
        number_question.setText(Integer.toString(currentQuestion));

        answerTrue.setText(Integer.toString(counterAnswerTrue));
        answerFalse.setText(Integer.toString(counterAnswerFalse));
    }

    // при правильном ответе вызываем следующий вопрос
    public void nextQuestionWin() {

        if (checkNumberQuestion() == true) {
            // переходим на следующий вопрос
            currentQuestion++;

            try {
                // устанавливаем текущий вопрос
                setQuestion(questionsGame.get(currentQuestion));
            } catch (IndexOutOfBoundsException e) {
                Text_error.setText("Ошибка. Вышли за границы сознания и вопросов нет");
            }
            // добавляем баллы за вопрос
            player.setBalance(player.getBalance() + balanceQuestion);
            counterAnswerTrue++;
            // current++;
            // обновляем панель информации о игроке
            information_player();
            // обновляем панель информации о игре
            information_game();
        } else {

            try {
                counterAnswerTrue++;
                player.setBalance(player.getBalance() + balanceQuestion);
                finishGame.setData(player.getName(), player.getBalance(), counterAnswerTrue);
                closeWindow();
                Text_error.setText("Конец игры ! Спасибо");
            } catch (IOException e) {
                System.out.println("ошибка, невозможно открыть финальную сцену");
            } catch (NullPointerException e) {
                System.out.println(player.getBalance() + " " + counterAnswerTrue);

            }

        }
    }

    // при ошибке вызывается метод
    public void nextQuestionLose() {
        if (checkNumberQuestion() == true) {
            // переходим на следующий вопрос
            currentQuestion++;
            try {
                // устанавливаем текущий вопрос
                setQuestion(questionsGame.get(currentQuestion));
            } catch (IndexOutOfBoundsException e) {
                Text_error.setText("Ошибка. Вышли за границы сознания и вопросов нет");
            }
            counterAnswerFalse++;
            // current++;
            // обновляем панель информации о игроке
            information_player();
            // обновляем панель информации о игре
            information_game();
        } else {
            counterAnswerFalse++;
            finishGame.setData(player.getName(), player.getBalance(), counterAnswerTrue);
            try {
                closeWindow();
            } catch (IOException e) {
                System.out.println("ошибка, невозможно открыть финальную сцену");
            }
            Text_error.setText("Конец игры ! Спасибо");
        }
    }

    // платим за прохождение следующего вопроса
    public void nextQuestionPay() {
        // проверяем . может ли пользователь оплатить 30 баллов
        if (checkNumberQuestion() == true && player.getBalance() >= 30) {
            // переходим на следующий вопрос
            currentQuestion++;
            // снимаем со счета баллы
            player.setBalance(player.getBalance() - 30);
            try {
                // устанавливаем текущий вопрос
                setQuestion(questionsGame.get(currentQuestion));
            } catch (IndexOutOfBoundsException e) {
                Text_error.setText("Ошибка. Вышли за границы сознания и вопросов нет");
            }
            counterAnswerTrue++;
            // обновляем панель информации о игроке
            information_player();
            // обновляем панель информации о игре
            information_game();
        } else {
            Text_error.setText("Конец игры ! Спасибо");
        }


    }

    // проверяет номер вопроса, чтобы мы не выходили за границы массива IndexOutOfBoundsException
    public boolean checkNumberQuestion() {
        if (currentQuestion < 9) {
            return true;
        }
        return false;
    }

    // обработка нажатия на кнопку блока правильных ответов
    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) {

        // если нажата клавиша 1
        if (mouseEvent.getSource() == answer1) {

            if (rightNumber == 1) {
                nextQuestionWin();
            } else {
                nextQuestionLose();
            }

        }

        if (mouseEvent.getSource() == answer2) {
            if (rightNumber == 2) {

                nextQuestionWin();
            } else {
                nextQuestionLose();
            }
        }
        if (mouseEvent.getSource() == answer3) {
            if (rightNumber == 3) {

                nextQuestionWin();
            } else {
                nextQuestionLose();
            }
        }
        if (mouseEvent.getSource() == answer4) {
            if (rightNumber == 4) {

                nextQuestionWin();
            } else {
                nextQuestionLose();
            }
        }
    }


    // при нажатии на пропустить вопрос перескакиваем на следующий вопрос без штрафа
    @FXML
    public void skipQuestion(ActionEvent mouseEvent) {
        nextQuestionLose();

    }

    // обработка кнопки (ответить правильно)
    @FXML
    public void answerTrue(ActionEvent mouseEvent) {
        nextQuestionPay();

    }

    // заканчиваем игру, подводим итоги, открываем новое окно
    public void closeWindow() throws IOException {
        //получаем сцену
        Stage stage = (Stage) answer1.getScene().getWindow();
        // do what you have to do
        stage.close();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/FinishGame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Итоги игры");
        stage.setScene(new Scene(root1));
        stage.show();

    }
}
