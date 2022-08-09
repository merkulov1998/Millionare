package sample.Model;

public class Record {

    String name;
    int finishBalance;
    int correctsAnswer;
    // конструктор
    public Record(String name, int finishBalance, int correctsAnswer) {
        this.name = name;
        this.finishBalance = finishBalance;
        this.correctsAnswer = correctsAnswer;
    }
    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFinishBalance() {
        return finishBalance;
    }

    public void setFinishBalance(int finishBalance) {
        this.finishBalance = finishBalance;
    }

    public int getCorrectsAnswer() {
        return correctsAnswer;
    }

    public void setCorrectsAnswer(int correctsAnswer) {
        this.correctsAnswer = correctsAnswer;
    }
}
