package subject;

import observer.Observer;

import java.math.BigDecimal;
import java.util.List;

public class ProductImpl implements Subject, Product {
    private final List<Observer> observers;
    private final String description;
    private BigDecimal price;

    public ProductImpl(List<Observer> observers, String description, BigDecimal price) {
        this.observers = observers;
        this.description = description;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }

    @Override
    public void notifyObservers() {
        System.out.printf("%s updated: Notifying observers\n", description);
        observers.forEach(observer -> observer.update(description, price));
    }

    @Override
    public String subjectDetails() {
        return this.description;
    }

    @Override
    public void updatePrice(BigDecimal price){
        this.price = price;
        notifyObservers();
    }
}