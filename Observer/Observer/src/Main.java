import observer.AppUser;
import observer.Observer;
import subject.Product;
import subject.ProductImpl;
import subject.Subject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductImpl guaymallen = new ProductImpl(new ArrayList<>(),"Alfajor guaymallen", BigDecimal.valueOf(125.10));
        ProductImpl fideos = new ProductImpl(new ArrayList<>(), "Fideos di maria", BigDecimal.valueOf(100));
        Observer observer = new AppUser(guaymallen, "Chino Maidana");
        observer.subscribe();

        guaymallen.updatePrice(BigDecimal.valueOf(220));
        observer.unSubscribe();
        guaymallen.updatePrice(BigDecimal.valueOf(250));
    }
}