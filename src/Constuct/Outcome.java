package Constuct;

/**
 * Клас Outcome представляє результат ставки в грі та зберігає інформацію про його назву та коефіцієнт виграшу.
 */
public class Outcome {
    /** Назва результату ставки */
    private String name;
    /** Коефіцієнт виграшу */
    private int odds;

    /**
     * Конструктор класу Outcome, який ініціалізує об'єкт результату ставки з визначеною назвою та коефіцієнтом виграшу.
     *
     * @param name Назва результату ставки.
     * @param odds Коефіцієнт виграшу, який визначає виграш гравця у випадку правильної ставки.
     */
    public Outcome(String name, int odds) {
        this.name = name;
        this.odds = odds;
    }

    /**
     * Отримати назву результату ставки.
     *
     * @return Назва результату ставки.
     */
    public String getName() {
        return name;
    }

    /**
     * Отримати коефіцієнт виграшу для цього результату ставки.
     *
     * @return Коефіцієнт виграшу.
     */
    public int getOdds() {
        return odds;
    }
}
