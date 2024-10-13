package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Random;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final double MAX_PRICE = 100.0;
    private static final double MAX_SEPAL_LENGTH = 10.0;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testSetAndGetPrice() {
        double price = RANDOM_GENERATOR.nextDouble() * MAX_PRICE;
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice(),
            "Price should be set correctly");
    }

    @Test
    public void testSetAndGetColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals(color.toString(), flower.getColor(),
            "Color should be set correctly");
    }

    @Test
    public void testSetAndGetSepalLength() {
        double sepalLength = RANDOM_GENERATOR.nextDouble() * MAX_SEPAL_LENGTH;
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength(),
            "Sepal length should be set correctly");
    }

    @Test
    public void testSetAndGetFlowerType() {
        FlowerType type = FlowerType.ROSE;
        flower.setFlowerType(type);
        Assertions.assertEquals(type, flower.getFlowerType(),
            "Flower type should be set correctly");
    }

    @Test
    public void testFlowerConstructor() {
        Flower newFlower = new Flower(flower);
        Assertions.assertEquals(flower.getPrice(), newFlower.getPrice(),
            "Price should be copied correctly");
        Assertions.assertEquals(flower.getSepalLength(), 
            newFlower.getSepalLength(), 
            "Sepal length should be copied correctly");
        Assertions.assertEquals(flower.getFlowerType(), 
            newFlower.getFlowerType(), 
            "Flower type should be copied correctly");
    }

    @Test
    public void testNullColor() {
        flower.setColor(null);
        Assertions.assertThrows(NullPointerException.class, flower::getColor,
            "Getting null color should throw NullPointerException");
    }
}
