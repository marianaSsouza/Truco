package src;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Jogador {

    public List<Carta> cartas;
    public String nome;

    public Jogador(String nome) {
        this.cartas = new ArrayList<>();
        this.nome = nome;
    }

    public Carta jogada(Carta cartaNaMesa) {
        return new JogadaDecisao(cartas).decidirJogada(cartaNaMesa);
    }

    public void exibeCartas() { // metodo para exibir as cartas
        cartas.forEach(c -> {
            System.out.print(c + " "); // mostra as cartas
        });
        System.out.println(); // isso faz pular a linha
    }

    // classe privada com a logica de decisões
    private class JogadaDecisao {

        public List<Carta> cartas;

        public JogadaDecisao(List<Carta> cartas){
            this.cartas = cartas;
        }

        // esse metodo é para decidir cada jogada
        public Carta decidirJogada(Carta cartaNaMesa) {
            //Carta cartaEscolhida = primeiraMao(cartaNaMesa);
            //if (cartaEscolhida == null) {
              //  cartaEscolhida = segundaMao(cartaNaMesa);
            //}
            //if (cartaEscolhida == null) {
            //    cartaEscolhida = terceiraMao(cartaNaMesa);
           // }
            return this.cartas.get(0);
        }

        // metodo para verificar a primeira mão de cartas da partida
        private Carta primeiraMao(Carta cartaNaMesa) {
            Optional<Carta> manilha = cartas.stream().filter(c -> c.valor > 13).findFirst(); // metodo para a manilha
            if (manilha.isPresent()) {
                return manilha.get();
            }
            // para ver se vc tem um coringa
            Optional<Carta> gato = cartas.stream().filter(c -> c.valor > 10000).findFirst();
            if (gato.isPresent()) {
                return gato.get();
            }
            // stream para ver qual é a maior, menor e a carta do meio
            Optional<Carta> maiorCarta = cartas.stream().max(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> menorCarta = cartas.stream().min(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> cartaDoMeio = cartas.stream()
                    .filter(c -> c.valor != maiorCarta.get().valor && c.valor != menorCarta.get().valor)
                    .findFirst();

            // if para jogar a carta da primeira mão
            // se a maior carta é maior que o valor da carta da mesa...
            if (maiorCarta.isPresent() && maiorCarta.get().valor > cartaNaMesa.valor) {
                return maiorCarta.get(); // joga a maior carta

            // se a carta do meio é maior que o valor da menor carta...
            } else if (cartaDoMeio.isPresent() && cartaDoMeio.get().valor > menorCarta.get().valor) {
                return cartaDoMeio.get(); // joga a carta do meio

             // caso a carta do meio não for maior que a carta menor...
            } else if (cartaDoMeio.isPresent() && cartaDoMeio.get().valor < menorCarta.get().valor) {
                return menorCarta.get(); // retorna a menor carta
            }
            return null; // isso aqui vai mostrar que a carta foi escolhida
        }

        // metodo para verificar as cartas da segunda mão
        private Carta segundaMao(Carta cartaNaMesa) {
            // ver se vc tem uma manilha
            Optional<Carta> manilha = cartas.stream().filter(c -> c.valor > 13).findFirst();
            if (manilha.isPresent()) {
                return manilha.get();
            }

            Optional<Carta> gato = cartas.stream().filter(c -> c.valor > 10000).findFirst();
            if (gato.isPresent()) {
                return gato.get();
            }
            // stream para ver qual é a maior, menor e a carta do meio
            Optional<Carta> maiorCarta = cartas.stream().max(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> menorCarta = cartas.stream().min(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> cartaDoMeio = cartas.stream()
                    .filter(c -> c.valor != maiorCarta.get().valor && c.valor != menorCarta.get().valor)
                    .findFirst();

            // se a maior carta é maior que o valor da carta da mesa...
            if (cartaDoMeio.isPresent() && cartaDoMeio.get().valor == cartaNaMesa.valor + 1) {
                return cartaDoMeio.get(); // joga a maior carta

            // se a carta do meio é maior que o valor da menor carta...
            } else if (cartaDoMeio.isPresent() && maiorCarta.get().valor > menorCarta.get().valor) {
                return maiorCarta.get(); // joga a carta do meio

            // caso a carta do meio não for maior que a carta menor...
            } else if (cartaDoMeio.isPresent() && cartaDoMeio.get().valor < menorCarta.get().valor) {
                return menorCarta.get(); // retorna a menor carta
            }
            return null; // isso aqui vai mostrar que a carta foi escolhida
        }

        // metodo para verificar as cartas da terceira mão
        private Carta terceiraMao(Carta cartaNaMesa) { //// ERRO
            // ver se vc tem uma manilha
            Optional<Carta> manilha = cartas.stream().filter(c -> c.valor > 13).findFirst();
            if (manilha.isPresent()) {
                return manilha.get();
            }
            /// ver se vc tem um coringa
            Optional<Carta> gato = cartas.stream().filter(c -> c.valor > 10000).findFirst();
            if (gato.isPresent()) {
                return gato.get();
            }
            // stream para ver qual é a maior, menor e a carta do meio
            Optional<Carta> maiorCarta = cartas.stream().max(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> menorCarta = cartas.stream().min(Comparator.comparingInt(c -> c.valor));
            Optional<Carta> cartaDoMeio = cartas.stream()
                    .filter(c -> c.valor != maiorCarta.get().valor && c.valor != menorCarta.get().valor)
                    .findFirst();

            // se a maior carta do meio tem valor igual ao da carta da mesa +1 ...
            if (cartaDoMeio.isPresent() && cartaDoMeio.get().valor == cartaNaMesa.valor + 1) {
                return cartaDoMeio.get(); // mostra a carta do meio

            // se a carta maior é maior que o valor da menor carta...
            } else if (cartaDoMeio.isPresent() && maiorCarta.get().valor > menorCarta.get().valor) {
                return maiorCarta.get(); // mostra a maior carta

            // caso não seja nada disso....
            } else {
                return menorCarta.get(); // mostra a menor carta
            }
         
        }
    }
}
