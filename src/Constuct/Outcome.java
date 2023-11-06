package Constuct;

public class Outcome {
    private String name;
    private int odds;

    public Outcome(String name, int odds) {
        this.name = name;
        this.odds = odds;
    }

    public String getName() {
        return name;
    } // Назва результату ставки

    public int getOdds() {
        return odds;
    } // Коефіціент виграшу
}