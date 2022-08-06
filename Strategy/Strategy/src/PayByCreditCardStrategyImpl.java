import java.io.IOException;
import java.util.Scanner;

/**
 * Implementacion de la estrategia para el metodo de pago de tarjeta de credito
 * */

public class PayByCreditCardStrategyImpl implements PaymentMethodStrategy{
    private final Scanner input = new Scanner(System.in);
    private CreditCard card;


    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter the card number: ");
        String cardNumber = input.nextLine();
        System.out.println("Enter the card expiration date mm/yy: ");
        String date = input.nextLine();
        System.out.println("Enter the CVV code: ");
        String cvv = input.nextLine();
        card = new CreditCard(cardNumber, date, cvv);
    }

    @Override
    public boolean pay(Integer amount) {
        if(cardIsPresent()){
            System.out.println(String.format("Paying %s amount with credit card.", amount));
            card.setAmount(card.getAmount() - amount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent(){
        return card != null;
    }
}
