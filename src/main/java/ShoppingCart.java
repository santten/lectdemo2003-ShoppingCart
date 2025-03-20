import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    static Scanner scanner = new Scanner(System.in);

    public static ResourceBundle getLanguageBundle(int choice) {
        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("sv", "SE");
                break;
            case 3:
                locale = new Locale("fi", "FI");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                System.out.println("Invalid choice. Defaulting to english.");
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid locale. Defaulting to english.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        return rb;
    }

    public static double calculatePrice(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        System.out.println("Select the language");
        System.out.println("[1] English");
        System.out.println("[2] Swedish");
        System.out.println("[3] Finnish");
        System.out.println("[4] Japanese");

        int choice = scanner.nextInt();

        ResourceBundle rb = getLanguageBundle(choice);

        System.out.print(rb.getString("itemAmountPrompt"));

        int itemAmount = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < itemAmount; i++) {
            System.out.printf(rb.getString("itemPricePrompt"), i + 1);
            double price = scanner.nextDouble();
            System.out.printf(rb.getString("itemQuantityPrompt"), i + 1);
            int quantity = scanner.nextInt();

            total += (calculatePrice(price, quantity));
        }

        System.out.printf((rb.getString("priceTotal")) + "%n", total);
    }
}
