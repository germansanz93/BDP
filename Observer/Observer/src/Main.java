import observer.AppUser;
import observer.Observer;
import subject.ProductImpl;
import subject.Subject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductImpl guaymallen = new ProductImpl(new ArrayList<>(),"Alfajor guaymallen", BigDecimal.valueOf(125.10));
        ProductImpl fideos = new ProductImpl(new ArrayList<>(), "Fideos di maria", BigDecimal.valueOf(100));
        Observer chino = new AppUser(new ArrayList<Subject>(), "Chino Maidana");
        Observer angelito = new AppUser(new ArrayList<>(), "Angelito");
        chino.subscribe(guaymallen);
        chino.subscribe(fideos);
        angelito.subscribe(fideos);

        guaymallen.updatePrice(BigDecimal.valueOf(220));
        fideos.updatePrice(BigDecimal.valueOf(120));
        chino.unSubscribe(fideos);
        guaymallen.updatePrice(BigDecimal.valueOf(250));
        fideos.updatePrice(BigDecimal.valueOf(150));
    }
}