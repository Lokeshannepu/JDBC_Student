package Demo;
import java.util.*;
class Item {
    int weight;
    int value;
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class FractionalKnapsack {
    public static double solve(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(
            (double) b.value / b.weight, 
            (double) a.value / a.weight
        ));
        double totalValue = 0.0;
        int currentWeight = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } 
            else {
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.value * ((double) remainingCapacity / item.weight);
                break; 
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50;
        double maxValue = solve(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}