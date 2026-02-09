import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class HorseTest {
    @Test
    public void constructorThrowsExceptionWhenNameIsNull() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 3d, 3d);
        });
        assertEquals("Name cannot be null.", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"' '", "'\n'", "'\t'", "''"})
    public void constructorThrowsExceptionWhenNameIsBlank(String value){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(value, 3d, 3d);
        });
        assertEquals("Name cannot be blank.", ex.getMessage());
    }
    @Test
    public void constructorThrowsExceptionWhenNegativeSpeed(){
        Exception ex = assertThrows(IllegalArgumentException.class, () ->{
            new Horse("Gass", -5d, 1d);
        });
        assertEquals("Speed cannot be negative.", ex.getMessage());
    }
    @Test
    public void constructorThrowsExceptionWhenNegativeDistance(){
        Exception ex = assertThrows(IllegalArgumentException.class, () ->{
            new Horse("Gass", 5d, -1d);
        });
        assertEquals("Distance cannot be negative.", ex.getMessage());
    }
}
