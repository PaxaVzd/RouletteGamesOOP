package Constuct;

public class Bet {
    private int amount; // Вартість ставки
    private Outcome outcome; // Результат ставки

    public Bet(int amount, Outcome outcome) {
        this.amount = amount;
        this.outcome = outcome;
    }

    public int getAmount() {
        return amount;
    }

    public Outcome getOutcome() {
        return outcome;
    }
}