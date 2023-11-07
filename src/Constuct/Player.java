package Constuct;

/**
 * Клас Player представляє гравця в грі та зберігає інформацію про його баланс.
 */
public class Player {
    /** Баланс гравця */
    private int balance;

    /**
     * Конструктор класу Player, який ініціалізує об'єкт гравця з визначеним балансом.
     *
     * @param balance Початковий баланс гравця.
     */
    public Player(int balance) {
        this.balance = balance;
    }

    /**
     * Отримати поточний баланс гравця.
     *
     * @return Баланс гравця.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Змінити баланс гравця на певну суму.
     *
     * @param amount Сума, на яку потрібно змінити баланс. Позитивне значення збільшить баланс, від'ємне - зменшить.
     */
    public void adjustBalance(int amount) {
        balance += amount;
    }
}
