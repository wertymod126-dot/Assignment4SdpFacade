package donershop.subsystem;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventory {
    private final Map<String, Integer> stock = new HashMap<>();

    public IngredientInventory() {
        stock.put("chicken", 20);
        stock.put("beef", 15);
        stock.put("lavash", 30);
        stock.put("garlic_sauce", 50);
    }

    public boolean checkAndReserve(String meatType, int quantity) {
        String meatKey = meatType.toLowerCase();
        int availableMeat = stock.getOrDefault(meatKey, 0);
        int availableLavash = stock.getOrDefault("lavash", 0);

        if (availableMeat < quantity || availableLavash < quantity) {
            return false;
        }

        stock.put(meatKey, availableMeat - quantity);
        stock.put("lavash", availableLavash - quantity);
        System.out.println("[Inventory] Reserved " + quantity + "x " + meatType + " döner ingredients.");
        return true;
    }
}