package observer;

import subject.Subject;

import java.math.BigDecimal;

public class AppUser implements Observer{

    private final Subject subject;
    private BigDecimal price;
    private String userInfo;

    public AppUser(Subject subject, String userInfo) {
        this.subject = subject;
        this.userInfo = userInfo;
    }

    @Override
    public void update(String description, BigDecimal price) {
        System.out.printf("%s price was updated to: %.2f\n", description, price);
        this.price = price;
    }

    @Override
    public void subscribe() {
        System.out.printf("Subscribing %s to %s...\n", userInfo, subject.subjectDetails());
        this.subject.subscribeObserver(this);
        System.out.println("Subscribed successfully");
    }

    @Override
    public void unSubscribe() {
        System.out.printf("Unsubscribing %s to %s...", userInfo, subject.subjectDetails());
        this.subject.unSubscribeObserver(this);
        System.out.println("Unsubscribed successfully");
    }
}
