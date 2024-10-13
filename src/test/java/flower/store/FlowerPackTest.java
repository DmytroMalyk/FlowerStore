package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {

    private Flower flower;
    private FlowerPack flowerPack;

    private static final double FLOWER_PRICE = 10.0;
    private static final int FLOWER_QUANTITY = 5;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flower.setPrice(FLOWER_PRICE);
        flowerPack = new FlowerPack(flower, FLOWER_QUANTITY);
    }

    @Test
    public void testFlowerPackConstructor() {
        FlowerPack copyPack = new FlowerPack(flower, FLOWER_QUANTITY);
        Assertions.assertEquals(flower.getPrice(), copyPack.getFlower().getPrice(),
            "Price of flower in FlowerPack should be copied correctly");
        Assertions.assertEquals(FLOWER_QUANTITY, copyPack.getQuantity(),
            "Quantity should be set correctly in the constructor");
    }

    @Test
    public void testSetAndGetFlower() {
        Flower newFlower = new Flower();
        newFlower.setPrice(20.0);
        flowerPack.setFlower(newFlower);
        Assertions.assertEquals(newFlower, flowerPack.getFlower(),
            "New flower should be set correctly in FlowerPack");
    }

    @Test
    public void testSetAndGetQuantity() {
        int newQuantity = 10;
        flowerPack.setQuantity(newQuantity);
        Assertions.assertEquals(newQuantity, flowerPack.getQuantity(),
            "New quantity should be set correctly in FlowerPack");
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = FLOWER_PRICE * FLOWER_QUANTITY;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice(),
            "Price should be calculated correctly based on quantity");
    }
}
