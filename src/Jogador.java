package src;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    public List<Carta> cartas;

    public Jogador() {
        this.cartas = new ArrayList<>();
    }

    public Carta jogarPrimeiraRodada(){
        return cartas.get(0);
    }

    public Carta jogarSegundaRodada() {
        return cartas.get(1);
    }

    public void exibeCartas(){
        cartas.forEach(c -> {
            System.out.print(c + " ");
        });
        System.out.println();
    }
}
