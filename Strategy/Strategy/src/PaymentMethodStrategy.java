/**
 * Interfaz comun a todas las estrategias
 * */
public interface PaymentMethodStrategy {
    void collectPaymentDetails();
    boolean pay(Integer amount);
}
