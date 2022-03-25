import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FuelTest {


    @Test
    @DisplayName("Calculation test 1")
    public void testCalculateFuel1(){
        Fuel fuel = new Fuel(12);
        assertEquals(2, fuel.calculateFuel(fuel.getMass()));
    }

    @Test
    @DisplayName("Calculation test 2")
    public void testCalculateFuel2(){
        Fuel fuel = new Fuel(14);
        assertEquals(2, fuel.calculateFuel(fuel.getMass()));
    }

    @Test
    @DisplayName("Calculation test 3")
    public void testCalculateFuel3(){
        Fuel fuel = new Fuel(1969);
        assertEquals(654, fuel.calculateFuel(fuel.getMass()));
    }

    @Test
    @DisplayName("Calculation test 4")
    public void testCalculateFuel4(){
        Fuel fuel = new Fuel(100756);
        assertEquals(33583, fuel.calculateFuel(fuel.getMass()));
    }

    @Test
    @DisplayName("Calculate Fuel Requirements - Null Case")
    public void testCalculateFuel_Scenario1(){
        assertThrows(NullPointerException.class, () -> new Fuel(null));
    }

    @Test
    @DisplayName("Calculate Fuel Requirements")
    public void testCalculateFuel_Scenario2(){
        Fuel fuel = new Fuel(new File("test_data"));
        assertEquals(34241, fuel.calculateTotalFuel());
    }

    @Test
    @DisplayName("Calculate Fuel Requirements")
    public void testCalculateFuel_Scenario3(){
        Fuel fuel = new Fuel(new File("puzzle.txt"));
        assertEquals(3497998, fuel.calculateTotalFuel());
    }


    @Test
    @DisplayName("Calculate Fuel Loop Method 1")
    public void testCalculateFuelLoop_Scenario1(){
        Fuel fuel = new Fuel(14);
        assertEquals(2, fuel.calculateFuelLoop(fuel.getMass()));
    }

    @Test
    @DisplayName("Calculate Fuel Loop Method 2")
    public void testCalculateFuelLoop_Scenario2(){
        Fuel fuel = new Fuel(1969);
        assertEquals(966, fuel.calculateFuelLoop(fuel.getMass()));
    }


    @Test
    @DisplayName("Calculate Fuel Consumption Loop Method")
    public void testCalculateTotalFuel2_Scenario1(){
        Fuel fuel = new Fuel(new File("puzzle.txt"));
        assertEquals(5244112, fuel.calculateTotalFuel2());
    }





}
