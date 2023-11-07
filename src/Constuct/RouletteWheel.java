package Constuct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Клас RouletteWheel представляє рулетку для гри та забезпечує функціональність для вибору випадкового результату ставки.
 */
public class RouletteWheel {
    /** Список можливих результатів ставок на рулетці */
    private List<Outcome> outcomes;
    /** Генератор випадкових чисел */
    private Random random;

    /**
     * Конструктор класу RouletteWheel, який ініціалізує об'єкт рулетки та створює порожній список можливих результатів ставок.
     */
    public RouletteWheel() {
        outcomes = new ArrayList<>();
        random = new Random();
    }

    /**
     * Додає переданий результат ставки до списку можливих результатів ставок на рулетці.
     *
     * @param outcome Результат ставки для додавання.
     */
    public void addOutcome(Outcome outcome) {
        outcomes.add(outcome);
    }

    /**
     * Виконує рулетку та повертає випадковий результат ставки зі списку можливих результатів.
     *
     * @return Випадковий результат ставки, який визначається обертанням рулетки.
     */
    public Outcome spin() {
        int randomIndex = random.nextInt(outcomes.size());
        return outcomes.get(randomIndex);
    }

    /**
     * Отримати список можливих результатів ставок на рулетці.
     *
     * @return Список можливих результатів ставок.
     */
    public List<Outcome> getOutcomes() {
        return outcomes;
    }
}
