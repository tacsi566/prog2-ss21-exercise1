import java.io.File;

public class App {

    public static void main(String[] args) {
        Fuel fuel = new Fuel(new File("puzzle.txt"));
        System.out.println(fuel.calculateTotalFuel());
    }
}
