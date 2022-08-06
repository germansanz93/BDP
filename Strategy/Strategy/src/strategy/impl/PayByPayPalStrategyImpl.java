package strategy.impl;

import strategy.PaymentMethodStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Estrategia concreta, implementa paypal como medio de pago
 */
public class PayByPayPalStrategyImpl implements PaymentMethodStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final Scanner input = new Scanner(System.in);
    private String email;
    private String password;
    private boolean signedIn;

    @Override
    public void collectPaymentDetails() {
        while (!signedIn) {
            System.out.println("Enter the user's email: ");
            email = input.nextLine();
            System.out.println("Enter the password: ");
            password = input.nextLine();
            if (verify()) {
                System.out.println("Data verification has been successful");
            } else {
                System.out.println("Wrong email or password");
            }
        }
    }

    @Override
    public boolean pay(Integer amount) {
        if(signedIn){
            System.out.println(String.format("Paying %s using PayPal", amount));
            return true;
        } else {
            return false;
        }
    }

    private boolean verify(){
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn){
        this.signedIn = signedIn;
    }
}
