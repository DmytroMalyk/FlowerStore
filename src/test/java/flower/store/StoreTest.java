package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {

    private Store store;
    private FlowerBucket roseBucket;
    private FlowerBucket tulipBucket;

    private static final double ROSE_PRICE = 50.0;
    private static final double TULIP_PRICE = 30.0;
    private static final int ROSE_QUANTITY = 5;
    private static final int TULIP_QUANTITY = 3;

    @BeforeEach
    public void init() {
        store = new Store();

        // Create a flower pack for roses
        Flower rose = new Flower();
        rose.setPrice(ROSE_PRICE / ROSE_QUANTITY);
        rose.setFlowerType(FlowerType.ROSE);
        rose.setColor(FlowerColor.RED);
        FlowerPack rosePack = new FlowerPack(rose, ROSE_QUANTITY);
        roseBucket = new FlowerBucket();
        roseBucket.addFlowerPack(rosePack);

        // Create a flower pack for tulips
        Flower tulip = new Flower();
        tulip.setPrice(TULIP_PRICE / TULIP_QUANTITY);
        tulip.setFlowerType(FlowerType.TULIP);
        tulip.setColor(FlowerColor.BLUE);
        FlowerPack tulipPack = new FlowerPack(tulip, TULIP_QUANTITY);
        tulipBucket = new FlowerBucket();
        tulipBucket.addFlowerPack(tulipPack);

        // Add buckets to store
        store.addFlowerBucket(roseBucket);
        store.addFlowerBucket(tulipBucket);
    }

    @Test
    public void testAddFlowerBucket() {
        FlowerBucket chamomileBucket = new FlowerBucket();
        store.addFlowerBucket(chamomileBucket);
        Assertions.assertTrue(store.search(FlowerType.CHAMOMILE, 
                                           FlowerColor.RED, 
                                           0, 100).isEmpty(),
            "No chamomile buckets should be found in the search");
        store.removeFlowerBucket(chamomileBucket);
    }

    @Test
    public void testRemoveFlowerBucket() {
        store.removeFlowerBucket(roseBucket);
        Assertions.assertTrue(store.search(FlowerType.ROSE, 
                                           FlowerColor.RED, 
                                           0, 100).isEmpty(),
            "Rose bucket should be removed from the store");
    }

    @Test
    public void testSearchByTypeAndPrice() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE, 
                                                 FlowerColor.RED, 
                                                 40, 60);
        Assertions.assertFalse(result.isEmpty(),
            "Rose bucket should be found within the price range");
        Assertions.assertEquals(roseBucket, result.get(0),
            "The rose bucket should be returned in the search result");
    }

    @Test
    public void testSearchByTypeColorAndPrice() {
        List<FlowerBucket> result = store.search(FlowerType.TULIP, 
                                                 FlowerColor.BLUE, 
                                                 20, 40);
        Assertions.assertFalse(result.isEmpty(),
            "Tulip bucket should be found by type, color, and price");
        Assertions.assertEquals(tulipBucket, result.get(0),
            "The tulip bucket should be returned in the search result");
    }

    @Test
    public void testSearchOutOfRangePrice() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE, 
                                                 FlowerColor.RED, 
                                                 60, 100);
        Assertions.assertTrue(result.isEmpty(),
            "No buckets should be found outside the price range");
    }

    @Test
    public void testSearchWrongType() {
        List<FlowerBucket> result = store.search(FlowerType.CHAMOMILE, 
                                                 FlowerColor.RED, 
                                                 0, 100);
        Assertions.assertTrue(result.isEmpty(),
            "No chamomile buckets should be found in the store");
    }

    @Test
    public void testSearchWrongColor() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE, 
                                                 FlowerColor.BLUE, 
                                                 0, 100);
        Assertions.assertTrue(result.isEmpty(),
            "No buckets with blue roses should be found in the store");
    }
}
