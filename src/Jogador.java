package src;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    public List<Carta> cartas;

    public String nome;

    public Jogador(String nome) {
        this.cartas = new ArrayList<>();
        this.nome = nome;
    }

    public Carta jogada(){
        return cartas.get(0);
    }

    public void exibeCartas(){
        cartas.forEach(c -> {
            System.out.print(c + " ");
        });
        System.out.println();
    }
}
