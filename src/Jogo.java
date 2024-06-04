package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {

    public List<Jogador> jogadores;

    public List<Rodada> rodadas;

    private Jogador jogadorDaVez;

    public Baralho baralho;

    public Carta cartaVirada;

    public byte pontuacaoA;
    public byte pontuacaoB;

    public Jogo(Jogador jogadorUm, Jogador jogadorDois) {
        this.jogadores = List.of(jogadorUm, jogadorDois);
        this.baralho = new Baralho();
        this.rodadas = new ArrayList<>();
        jogadorDaVez = jogadorUm;
        pontuacaoA = 0;
        pontuacaoB = 0;
    }

    public boolean alguemGanhou(){
        return pontuacaoA >= 12 || pontuacaoB >= 12;
    }

    public void distribuirCartas(){
        cartaVirada = baralho.cartas.get(6);
        transformaCartasEmManilhas();
        distribuiParaPrimeiroJogadorAJogar();
        distribuiParaSegundoJogadorAJogar();
    }

    private void distribuiParaSegundoJogadorAJogar() {
        jogadores.get(1).cartas.add(baralho.cartas.get(3));
        jogadores.get(1).cartas.add(baralho.cartas.get(4));
        jogadores.get(1).cartas.add(baralho.cartas.get(5));
    }

    private void distribuiParaPrimeiroJogadorAJogar() {
        jogadores.get(0).cartas.add(baralho.cartas.get(0));
        jogadores.get(0).cartas.add(baralho.cartas.get(1));
        jogadores.get(0).cartas.add(baralho.cartas.get(2));
    }

    private void transformaCartasEmManilhas() {
        for (Carta carta : baralho.cartas) {
            if(carta.numero == this.cartaVirada.numero + 1 || (this.cartaVirada.numero == 10 && carta.numero == 1)){
                switch (carta.naipe) {
                    case PAUS -> carta.valor*=10000;
                    case COPAS -> carta.valor*=1000;
                    case ESPADAS -> carta.valor*=100;
                    case OUROS -> carta.valor*=10;
                }
            }
        }
    }

    public void primeiraRodada() {
        rodadas.add(new Rodada());
        final Rodada rodadaUm = rodadas.get(0);
        rodadaUm.cartaJogadorUm = jogadores.get(0).jogarPrimeiraRodada();
        rodadaUm.cartaJogadorDois = jogadores.get(1).jogarPrimeiraRodada();
        defineVencedorETrocaOrdemParaProximaRodada(rodadaUm);
    }

    public void segundaRodada() {
        rodadas.add(new Rodada());
        final Rodada rodadaDois = rodadas.get(1);
        rodadaDois.cartaJogadorUm = jogadores.get(0).jogarSegundaRodada();
        rodadaDois.cartaJogadorDois = jogadores.get(1).jogarSegundaRodada();
        defineVencedorETrocaOrdemParaProximaRodada(rodadaDois);
    }

    private void defineVencedorETrocaOrdemParaProximaRodada(Rodada rodada) {
        if(rodada.cartaJogadorUm.valor > rodada.cartaJogadorDois.valor) rodada.ganhador = 1;
        else if(rodada.cartaJogadorUm.valor < rodada.cartaJogadorDois.valor) {
            rodada.ganhador = 2;
            Collections.swap(jogadores, 0 ,1);
        }
        else rodada.ganhador = 0;
    }
}
