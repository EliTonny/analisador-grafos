package analisadorgrafos.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eli T. de Souza
 */
public class Grafo extends Modelo{
    private Set<Vertice> vertices;
    private Set<Aresta> arestas;
    private String nome;
    
    public Grafo(){
        this.vertices = new HashSet();
        this.arestas = new HashSet();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addVertice(Vertice vertice){
        vertices.add(vertice);
    }
    
    public void removeVertice(Vertice vertice){
        vertices.remove(vertice);
    }
    
    public void addAresta(Aresta aresta){
        arestas.add(aresta);
    }
    
    public void removeAresta(Aresta aresta){
        arestas.remove(aresta);
    }
}
