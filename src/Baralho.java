package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static src.Naipe.*;

public class Baralho {

    public List<Carta> cartas = new ArrayList<>();

    public Baralho() {
        this.cartas.addAll(List.of(new Carta(1, PAUS),
                new Carta(2, PAUS),
                new Carta(3, PAUS),
                new Carta(4, PAUS),
                new Carta(5, PAUS),
                new Carta(6, PAUS),
                new Carta(7, PAUS),
                new Carta(8, PAUS),
                new Carta(9, PAUS),
                new Carta(10, PAUS),
                new Carta(1, COPAS),
                new Carta(2, COPAS),
                new Carta(3, COPAS),
                new Carta(4, COPAS),
                new Carta(5, COPAS),
                new Carta(6, COPAS),
                new Carta(7, COPAS),
                new Carta(8, COPAS),
                new Carta(9, COPAS),
                new Carta(10, COPAS),
                new Carta(1, ESPADAS),
                new Carta(2, ESPADAS),
                new Carta(3, ESPADAS),
                new Carta(4, ESPADAS),
                new Carta(5, ESPADAS),
                new Carta(6, ESPADAS),
                new Carta(7, ESPADAS),
                new Carta(8, ESPADAS),
                new Carta(9, ESPADAS),
                new Carta(10, ESPADAS),
                new Carta(1, OUROS),
                new Carta(2, OUROS),
                new Carta(3, OUROS),
                new Carta(4, OUROS),
                new Carta(5, OUROS),
                new Carta(6, OUROS),
                new Carta(7, OUROS),
                new Carta(8, OUROS),
                new Carta(9, OUROS),
                new Carta(10, OUROS)));
    }


    public void embaralhar() {
        Collections.shuffle(cartas);
    }

}
