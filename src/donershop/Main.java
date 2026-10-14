package donershop;

import donershop.facade.DonerShopFacade;
import donershop.subsystem.KitchenGrillQueue;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- 1. Standard Client Execution (Using Facade) ---
        DonerShopFacade cashierFacade = new DonerShopFacade();

        // Successful Order Call
        cashierFacade.placeDonerOrder(
                "Rinat",
                "beef",
                List.of("extra_cheese", "jalapeno"),
                "Medium",
                true,
                "Kaspi QR",
                10.00
        );

        // Failed Order Call (Insufficient Payment)
        cashierFacade.placeDonerOrder(
                "Alex",
                "chicken",
                List.of("garlic_sauce"),
                "Mild",
                false,
                "Card",
                2.00
        );

        // --- 2. Advanced Client Execution (Bypassing Facade directly to Subsystem) ---
        System.out.println("\n=== Advanced Client Direct Subsystem Access ===");
        KitchenGrillQueue headChefKitchenConsole = new KitchenGrillQueue();
        headChefKitchenConsole.startGrilling("PRIORITY-VIP-01");
    }
}