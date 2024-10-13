package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerTypeTest {

    @Test
    public void testEnumValues() {
        FlowerType[] expectedValues = {
            FlowerType.CHAMOMILE, FlowerType.ROSE, FlowerType.TULIP
        };
        Assertions.assertArrayEquals(expectedValues, FlowerType.values(),
            "FlowerType enum values should match the expected values");
    }

    @Test
    public void testEnumValueOfChamomile() {
        Assertions.assertEquals(FlowerType.CHAMOMILE, 
            FlowerType.valueOf("CHAMOMILE"), 
            "FlowerType.valueOf(CHAMOMILE) should return FlowerType.CHAMOMILE");
    }

    @Test
    public void testEnumValueOfRose() {
        Assertions.assertEquals(FlowerType.ROSE, 
            FlowerType.valueOf("ROSE"), 
            "FlowerType.valueOf(ROSE) should return FlowerType.ROSE");
    }

    @Test
    public void testEnumValueOfTulip() {
        Assertions.assertEquals(FlowerType.TULIP, 
            FlowerType.valueOf("TULIP"), 
            "FlowerType.valueOf(TULIP) should return FlowerType.TULIP");
    }
}
