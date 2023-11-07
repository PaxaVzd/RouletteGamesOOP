import GamePlay.Game;

/**
 * Клас Main містить метод main і використовує клас Game для створення та запуску ігрового процесу рулетки.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
