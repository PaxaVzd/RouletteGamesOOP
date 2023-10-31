import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {
    private Player player;
    private RouletteWheel rouletteWheel;
    private Outcome currentResult;

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
