package flower.store;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Store {
    private List<FlowerBucket> buckets;

    public Store() {
        this.buckets = new ArrayList<FlowerBucket>();
    }

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        buckets.add(flowerBucket);
    }

    public void removeFlowerBucket(FlowerBucket flowerBucket) {
        buckets.remove(flowerBucket);
    }

    public List<FlowerBucket> search(FlowerType flowerType, 
                                     FlowerColor flowerColor, 
                                     double minBudget, 
                                     double maxBudget) {
        List<FlowerBucket> result = new ArrayList<>();

        for (FlowerBucket bucket : buckets) {
            double price = bucket.getPrice();
            if (minBudget <= price && price <= maxBudget) {
                for (FlowerPack pack : bucket.getFlowerPacks()) {
                    Flower flower = pack.getFlower();
                    if (flowerType.equals(flower.getFlowerType()) && 
                        flowerColor.toString().equals(flower.getColor())) {
                        result.add(bucket);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
