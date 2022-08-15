package observer;

import subject.Subject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppUser implements Observer{

    private final ArrayList<Subject> subjects;
    private BigDecimal price;
    private final String userInfo;

    public AppUser(ArrayList<Subject> subjects, String userInfo) {
        this.subjects = subjects;
        this.userInfo = userInfo;
    }

    @Override
    public void update(String description, BigDecimal price) {
        System.out.printf("\u001B[36m -%s: %s price was updated to: %.2f\u001B[0m\n", userInfo,description, price);
        this.price = price;
    }

    @Override
    public void subscribe(Subject subject) {
        System.out.println("\u001B[32m**********************************************************");
        System.out.printf("Subscribing %s to %s...\n", userInfo, subject.subjectDetails());
        subject.subscribeObserver(this);
        subjects.add(subject);
        System.out.println("Subscribed successfully");
        System.out.println("**********************************************************\u001B[0m");
    }

    @Override
    public void unSubscribe(Subject subject) {
        System.out.printf("\u001B[31mUnsubscribing %s to %s...", userInfo, subject.subjectDetails());
        subject.unSubscribeObserver(this);
        subjects.remove(subject);
        System.out.println("Unsubscribed successfully\u001B[0m");
    }
}
