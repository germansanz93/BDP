import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * aplicacion cliente
 * */
public class Main {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
    private static Order order = new Order();
    private static PaymentMethodStrategy strategy;

    static {
        priceOnProducts.put(1, 25000);
        priceOnProducts.put(2, 20000);
        priceOnProducts.put(3, 8000);
        priceOnProducts.put(4, 7000);
    }
    public static void main(String[] args) {
        while (!order.isClosed()){
            int cost;
            String continueChoice;

            do {
                System.out.print("Por favor seleccione un producto:\n" +
                                "1 - Motherboard\n" +
                                "2 - CPU\n" +
                                "3 - HDD\n" +
                                "4 - RAM\n");
                Integer choice = Integer.parseInt(input.nextLine());
                cost = priceOnProducts.get(choice);
                System.out.println("count: ");
                Integer count = Integer.parseInt(input.nextLine());
                order.setTotalCost(cost * count);
                System.out.println("Do you wish to continue selecting products? Y/N: ");
                continueChoice = input.nextLine();
            }while (continueChoice.equalsIgnoreCase("Y"));

            if(strategy == null){
                System.out.println("Por favor seleccione un metodo de pago: \n" +
                                    "1 - PayPal \n" +
                                    "2 - Credit card \n");
                String paymentMethod = input.nextLine();
                //El cliente crea las diferentes estrategias basado en el input del usuario
                if(paymentMethod.equals("1")){
                    strategy = new PayByPayPalStrategyImpl();
                } else {
                    strategy = new PayByCreditCardStrategyImpl();
                }
            }

            // El objeto orden delega la solicitud de la informacion de pago al objeto estrategia,
            // Solo la estrategia concreta sabe que informacion necesita para procesar el pago
            order.processOrder(strategy);
            System.out.println("Pay %s units or continue shopping? P/C: ");
            String proceed = input.nextLine();
            if(proceed.equalsIgnoreCase("P")){
                //Finalmente la estrategia maneja el pago
                if(strategy.pay(order.getTotalCost())){
                    System.out.println("Payment has been successful");
                } else {
                    System.out.println("FAIL! Please check your data.");
                }
                order.setClosed();
            }
        }
    }
}
