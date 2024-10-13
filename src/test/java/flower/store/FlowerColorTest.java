package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerColorTest {
    
    @Test
    public void testRedColorToString() {
        FlowerColor redColor = FlowerColor.RED;
        String expected = "#FF0000";
        Assertions.assertEquals(expected, redColor.toString(),
            "RED color should return correct string representation");
    }

    @Test
    public void testBlueColorToString() {
        FlowerColor blueColor = FlowerColor.BLUE;
        String expected = "#0000FF";
        Assertions.assertEquals(expected, blueColor.toString(),
            "BLUE color should return correct string representation");
    }

    @Test
    public void testEnumValues() {
        FlowerColor[] expectedValues = { FlowerColor.RED, FlowerColor.BLUE };
        Assertions.assertArrayEquals(expectedValues, FlowerColor.values(),
            "FlowerColor enum values should match the expected values");
    }

    @Test
    public void testEnumValueOf() {
        Assertions.assertEquals(FlowerColor.RED, 
            FlowerColor.valueOf("RED"), 
            "FlowerColor.valueOf(RED) should return FlowerColor.RED");
        Assertions.assertEquals(FlowerColor.BLUE, 
            FlowerColor.valueOf("BLUE"), 
            "FlowerColor.valueOf(BLUE) should return FlowerColor.BLUE");
    }
}
