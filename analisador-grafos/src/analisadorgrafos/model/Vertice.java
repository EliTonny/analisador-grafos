package analisadorgrafos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eli T. de Souza
 */
public class Vertice extends Modelo{
    private String nome;
    private List<Aresta> arestas;
    
    public Vertice(){
        this.arestas = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }
    
    public void removeAresta(Aresta aresta){
        this.arestas.remove(aresta);
    }
}
