/**
 * Clase orden. La orden no sabe el metodo concreto de pago (strategy) que el usuario seleccionara. Se utiliza una
 * interfaz para delegar la recoleccion de los datos del pago al objeto strategy.
 * */
public class Order {
    private Integer totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PaymentMethodStrategy strategy){
        strategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost){
        this.totalCost += cost;
    }

    public Integer getTotalCost(){
        return totalCost;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(){
        isClosed = true;
    }
}
