import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class HippodromeTest {

    @Test
    public void constructorThrowsExceptionWhenParameterIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
        assertEquals("Horses cannot be null.", ex.getMessage());
    }

    @Test
    public void constructorThrowsExceptionWhenParameterIsEmpty() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(new ArrayList<>());
        });
        assertEquals("Horses cannot be empty.", ex.getMessage());
    }

    @Test
    public void getHorsesReturnsCorrectListHorses() {
        List<Horse> horseArrayList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            horseArrayList.add(
                    new Horse(String.valueOf(i), i * 0.1, i * 0.5));
        }

        Hippodrome hippodrome = new Hippodrome(horseArrayList);
        assertSame(horseArrayList, hippodrome.getHorses());
    }

    @Test
    public void moveInvokesMoveForEachHorse() {
        List<Horse> horsesMockList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            horsesMockList.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horsesMockList);
        hippodrome.move();

        for (Horse horse : horsesMockList) {
            Mockito.verify(horse, times(1)).move();
        }
    }

    @Test
    public void getWinnerHorseMaxDistance() {
        ArrayList<Horse> horseList = new ArrayList<>();

        Horse storm = new Horse("Storm", 68.2, 95d);
        Horse shadow = new Horse("Shadow", 70.0, 110d);
        Horse blaze = new Horse("Blaze", 80.3, 130d);
        Horse thunder = new Horse("Thunder", 77.8, 125d);

        horseList.add(storm);
        horseList.add(shadow);
        horseList.add(blaze);
        horseList.add(thunder);

        Hippodrome hippodrome = new Hippodrome(horseList);
        assertEquals(blaze, hippodrome.getWinner());
    }
}
