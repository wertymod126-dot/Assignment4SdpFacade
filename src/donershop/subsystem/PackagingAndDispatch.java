package donershop.subsystem;

public class PackagingAndDispatch {
    public void packageOrder(String orderId, boolean isTakeout) {
        String packageType = isTakeout ? "Thermal Foil Wrap & Bag" : "Open Serving Tray";
        System.out.println("[Packaging] Order #" + orderId + " packed in " + packageType);
    }

    public void notifyCustomer(String orderId, String customerName) {
        System.out.println("[Dispatch] Pickup notification sent to " + customerName + " for Order #" + orderId);
    }
}