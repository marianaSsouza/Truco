package src;

public class Carta {

    public final Integer numero;
    public final Naipe naipe;

    public boolean disponivel;

    public Integer valor;

    public Carta(Integer numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
        this.disponivel = true;
        this.valor = numero;
    }

    @Override
    public String toString() {
        return numero + naipe.toString();
    }
}
