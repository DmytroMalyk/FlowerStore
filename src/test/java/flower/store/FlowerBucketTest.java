package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucketTest {

    private FlowerBucket flowerBucket;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;

    private static final double ROSE_PRICE = 10.0;
    private static final double TULIP_PRICE = 15.0;
    private static final int ROSE_QUANTITY = 5;
    private static final int TULIP_QUANTITY = 3;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
        
        Flower rose = new Flower();
        rose.setPrice(ROSE_PRICE);
        rosePack = new FlowerPack(rose, ROSE_QUANTITY);
        
        Flower tulip = new Flower();
        tulip.setPrice(TULIP_PRICE);
        tulipPack = new FlowerPack(tulip, TULIP_QUANTITY);
    }

    @Test
    public void testConstructorWithList() {
        List<FlowerPack> packs = new ArrayList<>();
        packs.add(rosePack);
        packs.add(tulipPack);
        
        FlowerBucket customBucket = new FlowerBucket(packs);
        Assertions.assertEquals(packs, customBucket.getFlowerPacks(),
            "Flower packs should be set correctly in constructor");
    }

    @Test
    public void testAddFlowerPack() {
        flowerBucket.addFlowerPack(rosePack);
        flowerBucket.addFlowerPack(tulipPack);
        
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(rosePack),
            "Rose pack should be added to the bucket");
        Assertions.assertTrue(flowerBucket.getFlowerPacks().contains(tulipPack),
            "Tulip pack should be added to the bucket");
    }

    @Test
    public void testGetPrice() {
        flowerBucket.addFlowerPack(rosePack);
        flowerBucket.addFlowerPack(tulipPack);
        
        double expectedPrice = (ROSE_PRICE * ROSE_QUANTITY) + 
                               (TULIP_PRICE * TULIP_QUANTITY);
        Assertions.assertEquals(expectedPrice, flowerBucket.getPrice(),
            "Total price should be calculated correctly");
    }

    @Test
    public void testEmptyBucketPrice() {
        Assertions.assertEquals(0, flowerBucket.getPrice(),
            "Price of an empty bucket should be 0");
    }
}
