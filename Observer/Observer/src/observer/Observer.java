package observer;

import java.math.BigDecimal;

public interface Observer {
    public void update(String description, BigDecimal price);
    public void subscribe();
    public void unSubscribe();
}
