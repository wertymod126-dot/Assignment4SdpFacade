package donershop.facade;

import donershop.subsystem.*;
import java.util.List;
import java.util.UUID;

public class DonerShopFacade {
    private final IngredientInventory inventory;
    private final OrderCustomizer customizer;
    private final PaymentProcessor paymentProcessor;
    private final KitchenGrillQueue kitchenQueue;
    private final PackagingAndDispatch dispatch;

    public DonerShopFacade() {
        this.inventory = new IngredientInventory();
        this.customizer = new OrderCustomizer();
        this.paymentProcessor = new PaymentProcessor();
        this.kitchenQueue = new KitchenGrillQueue();
        this.dispatch = new PackagingAndDispatch();
    }

    public boolean placeDonerOrder(String customerName, String meatType, List<String> toppings,
                                   String spicyLevel, boolean isTakeout, String paymentMethod, double paymentAmount) {
        String orderId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        System.out.println("\n=== Processing Order #" + orderId + " for " + customerName + " ===");

        // 1. Validate Stock
        if (!inventory.checkAndReserve(meatType, 1)) {
            System.err.println("[Facade Error] Order failed: Out of ingredients for " + meatType + " döner.");
            return false;
        }

        // 2. Customization & Pricing
        double basePrice = 6.50;
        double totalPrice = customizer.calculateTotalCost(basePrice, toppings);
        String recipeNote = customizer.buildRecipeNote(meatType, toppings, spicyLevel);

        if (paymentAmount < totalPrice) {
            System.err.println("[Facade Error] Payment failed: Insufficient payment ($" + paymentAmount + " < required $" + totalPrice + ")");
            return false;
        }

        // 3. Payment Processing
        if (!paymentProcessor.processPayment(orderId, totalPrice, paymentMethod)) {
            System.err.println("[Facade Error] Transaction failed.");
            return false;
        }

        // 4. Kitchen Execution
        kitchenQueue.enqueueOrder(orderId, recipeNote);
        kitchenQueue.startGrilling(orderId);

        // 5. Dispatch
        dispatch.packageOrder(orderId, isTakeout);
        dispatch.notifyCustomer(orderId, customerName);

        System.out.println("=== Order #" + orderId + " Successfully Completed ===");
        return true;
    }
}