package GamePlay;

import Constuct.Bet;
import Constuct.Outcome;
import Constuct.Player;
import Constuct.RouletteWheel;

import java.util.List;
import java.util.Scanner;

/**
 * Клас Game представляє ігровий процес рулетки, де гравець може робити ставки та грати.
 */
public class Game {
    /** Гравець, який бере участь у грі та має баланс. */
    private Player player;
    /** Рулетка для визначення результату ставки. */
    private RouletteWheel rouletteWheel;
    /** Поточний результат ставки після обертання рулетки. */
    private Outcome currentResult;

    /**
     * Конструктор класу Game, який ініціалізує гравця, рулетку та визначає можливі результати ставок.
     */
    public Game() {
        player = new Player(1000);
        rouletteWheel = new RouletteWheel();

        Outcome red = new Outcome("Red", 2);
        Outcome black = new Outcome("Black", 2);
        Outcome green = new Outcome("Green", 36);

        rouletteWheel.addOutcome(red);
        rouletteWheel.addOutcome(black);
        rouletteWheel.addOutcome(green);
    }

    /**
     * Розміщує ставку та визначає результат гри.
     *
     * @param bet Ставка, яку гравець розміщує.
     */
    public void placeBet(Bet bet) {
        if (player.getBalance() >= bet.getAmount()) {
            Outcome spinResult = rouletteWheel.spin();
            currentResult = spinResult;

            if (spinResult == bet.getOutcome()) {
                int winAmount = bet.getAmount() * bet.getOutcome().getOdds();
                player.adjustBalance(winAmount);
                System.out.println("Result: " + currentResult.getName());
                System.out.println("You won!");
            } else {
                player.adjustBalance(-bet.getAmount());
                System.out.println("Result: " + currentResult.getName());
                System.out.println("You lost.");
            }
        } else {
            System.out.println("Insufficient balance for the bet.");
        }
    }

    /**
     * Починає гру та дозволяє гравцю робити ставки, доки є гроші на балансі.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (player.getBalance() > 0) {
            System.out.println("Your balance: " + player.getBalance());

            int betAmount = -1;
            while (betAmount < 0 || betAmount > player.getBalance()) {
                System.out.print("Enter bet amount: ");
                betAmount = scanner.nextInt();
                if (betAmount < 0 || betAmount > player.getBalance()) {
                    System.out.println("Invalid bet amount.");
                }
            }

            scanner.nextLine();

            System.out.println("Possible bets:");
            List<Outcome> possibleOutcomes = rouletteWheel.getOutcomes();
            for (int i = 0; i < possibleOutcomes.size(); i++) {
                Outcome outcome = possibleOutcomes.get(i);
                System.out.println(i + 1 + ". " + outcome.getName() + " (x" + outcome.getOdds() + ")");
            }

            int selectedOutcomeIndex = -1;
            while (selectedOutcomeIndex < 0 || selectedOutcomeIndex >= possibleOutcomes.size()) {
                System.out.print("Choose a bet number: ");
                selectedOutcomeIndex = scanner.nextInt() - 1;
                if (selectedOutcomeIndex < 0 || selectedOutcomeIndex >= possibleOutcomes.size()) {
                    System.out.println("Invalid bet number.");
                }
            }

            Outcome selectedOutcome = possibleOutcomes.get(selectedOutcomeIndex);
            Bet bet = new Bet(betAmount, selectedOutcome);
            placeBet(bet);
        }
    }
}
