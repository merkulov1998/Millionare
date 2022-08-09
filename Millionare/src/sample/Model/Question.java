package sample.Model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String name;
    private List<String> answers;

    private int balance;

    private ArrayList<String> answer = new ArrayList<>();
    private int correctAnswer;

    // конструктор для создания вопроса
    public Question(String name, int balance, String question1, String question2, String question3, String question4, int correctAnswer) {
        this.name = name;
        this.balance = balance;
        answer.add(question1);
        answer.add(question2);
        answer.add(question3);
        answer.add(question4);
        this.correctAnswer = correctAnswer;
    }

    // методы для доступа к инкапсулированными полям(private)

    public int getCorrectAnswer() {
        return correctAnswer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}