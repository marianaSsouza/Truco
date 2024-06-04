package src;

public class Main {

    public static void main(String[] args) {

        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        Jogo jogo = new Jogo(j1,j2);

        while (!jogo.alguemGanhou()){

            jogo.baralho.embaralhar();
            jogo.distribuirCartas();
            jogo.jogadores.forEach(Jogador::exibeCartas);


            jogo.primeiraRodada();
            System.out.println(jogo.rodadas.get(0).cartaJogadorUm);
            System.out.println(jogo.rodadas.get(0).cartaJogadorDois);
            System.out.println(jogo.rodadas.get(0).ganhador);


            jogo.segundaRodada();
            System.out.println("Jogo");





        }

    }

}
