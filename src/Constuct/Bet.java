package Constuct;

/**
 * Клас Bet представляє ставку, що робить гравець у грі.
 */
public class Bet {
    /** Вартість ставки */
    private int amount;
    /** Результат ставки */
    private Outcome outcome;

    /**
     * Конструктор класу Bet, який ініціалізує об'єкт ставки.
     *
     * @param amount Вартість ставки, яку вносить гравець.
     * @param outcome Результат ставки, який гравець обирає.
     */
    public Bet(int amount, Outcome outcome) {
        this.amount = amount;
        this.outcome = outcome;
    }

    /**
     * Отримати вартість ставки.
     *
     * @return Вартість ставки.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Отримати результат ставки.
     *
     * @return Результат ставки.
     */
    public Outcome getOutcome() {
        return outcome;
    }
}
