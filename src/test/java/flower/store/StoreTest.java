package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {

    private static final double ROSE_PRICE = 50.0;
    private static final double TULIP_PRICE = 30.0;
    private static final int ROSE_QUANTITY = 5;
    private static final int TULIP_QUANTITY = 3;
    
    private static final double MIN_PRICE = 0.0;
    private static final double MAX_PRICE = 100.0;
    private static final double SEARCH_MIN_PRICE = 40.0;
    private static final double SEARCH_MAX_PRICE = 60.0;
    private static final double TULIP_SEARCH_MIN_PRICE = 20.0;
    private static final double TULIP_SEARCH_MAX_PRICE = 40.0;

    private Store store;
    private FlowerBucket roseBucket;
    private FlowerBucket tulipBucket;

    @BeforeEach
    public void init() {
        store = new Store();

        Flower rose = new Flower();
        rose.setPrice(ROSE_PRICE / ROSE_QUANTITY);
        rose.setFlowerType(FlowerType.ROSE);
        rose.setColor(FlowerColor.RED);
        FlowerPack rosePack = new FlowerPack(rose, ROSE_QUANTITY);
        roseBucket = new FlowerBucket();
        roseBucket.addFlowerPack(rosePack);

        Flower tulip = new Flower();
        tulip.setPrice(TULIP_PRICE / TULIP_QUANTITY);
        tulip.setFlowerType(FlowerType.TULIP);
        tulip.setColor(FlowerColor.BLUE);
        FlowerPack tulipPack = new FlowerPack(tulip, TULIP_QUANTITY);
        tulipBucket = new FlowerBucket();
        tulipBucket.addFlowerPack(tulipPack);

        store.addFlowerBucket(roseBucket);
        store.addFlowerBucket(tulipBucket);
    }

    @Test
    public void testAddFlowerBucket() {
        FlowerBucket chamomileBucket = new FlowerBucket();
        store.addFlowerBucket(chamomileBucket);
        Assertions.assertTrue(store.search(FlowerType.CHAMOMILE,
            FlowerColor.RED,
            MIN_PRICE, MAX_PRICE).isEmpty());
        store.removeFlowerBucket(chamomileBucket);
    }

    @Test
    public void testRemoveFlowerBucket() {
        store.removeFlowerBucket(roseBucket);
        Assertions.assertTrue(store.search(FlowerType.ROSE,
            FlowerColor.RED, 
            MIN_PRICE, MAX_PRICE).isEmpty());
    }

    @Test
    public void testSearchByTypeAndPrice() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE,
            FlowerColor.RED, 
            SEARCH_MIN_PRICE, SEARCH_MAX_PRICE);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(roseBucket, result.get(0));
    }

    @Test
    public void testSearchByTypeColorAndPrice() {
        List<FlowerBucket> result = store.search(FlowerType.TULIP,
            FlowerColor.BLUE, 
            TULIP_SEARCH_MIN_PRICE, TULIP_SEARCH_MAX_PRICE);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(tulipBucket, result.get(0));
    }

    @Test
    public void testSearchOutOfRangePrice() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE,
            FlowerColor.RED,
            SEARCH_MAX_PRICE, MAX_PRICE);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchWrongType() {
        List<FlowerBucket> result = store.search(FlowerType.CHAMOMILE,
            FlowerColor.RED,
            MIN_PRICE, MAX_PRICE);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchWrongColor() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE,
            FlowerColor.BLUE,
            MIN_PRICE, MAX_PRICE);
        Assertions.assertTrue(result.isEmpty());
    }
}
