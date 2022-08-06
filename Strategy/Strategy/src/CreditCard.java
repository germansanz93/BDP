/**
 * Clase para representar una tarjeta de credito
 * */

public class CreditCard {
    private Integer amount;
    private final String number;
    private final String date;
    private final String cvv;

    CreditCard(String number, String date, String cvv){
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public Integer getAmount(){
        return amount;
    }

}
