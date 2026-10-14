package donershop.subsystem;

public class KitchenGrillQueue {
    public void enqueueOrder(String orderId, String recipeNote) {
        System.out.println("[Kitchen Queue] Ticket #" + orderId + " queued: " + recipeNote);
    }

    public void startGrilling(String orderId) {
        System.out.println("[Kitchen Queue] Grilling started for Order #" + orderId + "...");
    }
}