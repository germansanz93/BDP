package observer;

import subject.Subject;

import java.math.BigDecimal;

public interface Observer {
    public void update(String description, BigDecimal price);
    public void subscribe(Subject subject);
    public void unSubscribe(Subject subject);
}
