package GamePlay;

import Constuct.Outcome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RouletteWheel {
    private List<Outcome> outcomes;
    private Random random;

    public RouletteWheel() {
        outcomes = new ArrayList<>();
        random = new Random();
    }

    // Додає переданий результат ставки (outcome) до списку можливих результатів ставок
    public void addOutcome(Outcome outcome) {
        outcomes.add(outcome);
    }

    public Outcome spin() {
        int randomIndex = random.nextInt(outcomes.size());
        return outcomes.get(randomIndex);
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    } // Список можливих результатів
}