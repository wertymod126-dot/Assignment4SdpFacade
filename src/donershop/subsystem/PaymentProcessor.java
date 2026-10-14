package donershop.subsystem;

public class PaymentProcessor {
    public boolean processPayment(String orderId, double amount, String paymentMethod) {
        if (amount <= 0) {
            System.err.println("[Payment] Invalid payment amount: $" + amount);
            return false;
        }
        System.out.println("[Payment] Processed $" + String.format("%.2f", amount) + " via " + paymentMethod + " for Order #" + orderId);
        return true;
    }
}