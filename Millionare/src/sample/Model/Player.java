package sample.Model;

public class Player {

    private String name;
    private int balance;

    // конструктор для создания нового пользователя
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    // методы для доступа к инкапсулированными полям(private)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
