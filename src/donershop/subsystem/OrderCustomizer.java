package donershop.subsystem;

import java.util.List;

public class OrderCustomizer {
    public double calculateTotalCost(double basePrice, List<String> toppings) {
        double total = basePrice;
        if (toppings != null) {
            total += toppings.size() * 0.50;
        }
        return total;
    }

    public String buildRecipeNote(String meatType, List<String> toppings, String spicyLevel) {
        String toppingsStr = (toppings == null || toppings.isEmpty()) ? "Standard veggies" : String.join(", ", toppings);
        return String.format("%s Döner | Spice: %s | Toppings: %s", meatType.toUpperCase(), spicyLevel, toppingsStr);
    }
}