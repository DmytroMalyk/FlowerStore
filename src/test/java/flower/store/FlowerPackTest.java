package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {

    private static final double FLOWER_PRICE = 10.0;
    private static final int FLOWER_QUANTITY = 5;
    private static final double NEW_FLOWER_PRICE = 20.0;
    private static final int NEW_QUANTITY = 10;

    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flower.setPrice(FLOWER_PRICE);
        flowerPack = new FlowerPack(flower, FLOWER_QUANTITY);
    }

    @Test
    public void testFlowerPackConstructor() {
        FlowerPack copyPack = new FlowerPack(flower, FLOWER_QUANTITY);
        Assertions.assertEquals(flower.getPrice(), 
            copyPack.getFlower().getPrice());
        Assertions.assertEquals(FLOWER_QUANTITY, 
            copyPack.getQuantity());
    }

    @Test
    public void testSetAndGetFlower() {
        Flower newFlower = new Flower();
        newFlower.setPrice(NEW_FLOWER_PRICE);
        flowerPack.setFlower(newFlower);
        Assertions.assertEquals(newFlower, 
            flowerPack.getFlower());
    }

    @Test
    public void testSetAndGetQuantity() {
        flowerPack.setQuantity(NEW_QUANTITY);
        Assertions.assertEquals(NEW_QUANTITY, 
            flowerPack.getQuantity());
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = FLOWER_PRICE * FLOWER_QUANTITY;
        Assertions.assertEquals(expectedPrice, 
            flowerPack.getPrice());
    }
}
