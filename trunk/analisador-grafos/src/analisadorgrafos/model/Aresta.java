package analisadorgrafos.model;

/**
 *
 * @author Eli T. de Souza
 */
public class Aresta extends Modelo{
    private String nome;
    private double valor;
    private Vertice vertPartida;
    private Vertice vertChegada;

    public Aresta(Vertice vertPartida, Vertice vertChegada){
        this.vertPartida = vertPartida;
        this.vertChegada = vertChegada;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Vertice getVertPartida() {
        return vertPartida;
    }

    public void setVertPartida(Vertice vertPartida) {
        this.vertPartida = vertPartida;
    }

    public Vertice getVertChegada() {
        return vertChegada;
    }

    public void setVertChegada(Vertice vertChegada) {
        this.vertChegada = vertChegada;
    }
}
