package analisador.grafos;

/**
 *
 * Algoritmo de busca em largura retirado de: http://www.dcc.ufmg.br/algoritmos-java/cap7/transp/completo4/cap7.pdf
 * 
 * @author Eli T. de Souza
 * @author Gustavo Sabel
 */
public class BuscaEmProfundidade {
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;	
    private int d[], t[], antecessor[];
    private Grafo grafo;

    public BuscaEmProfundidade(Grafo grafo) {
            this.grafo = grafo;
            int n = this.grafo.numVertices();
            d = new int[n];
            t = new int[n];
            antecessor = new int[n];
    }

    private int visitaDfs(int u, int tempo, int cor[]) {
            cor[u] = cinza;
            this.d[u] = ++tempo;
            if (!this.grafo.listaAdjVazia(u)) {
                    Grafo.Aresta a = this.grafo.primeiroListaAdj(u);

                    while (a != null) {
                            int v = a.v2();
                            if (cor[v] == branco) {
                                    this.antecessor[v] = u;
                                    tempo = this.visitaDfs(v, tempo, cor);
                            }
                            a = this.grafo.proxAdj(u);
                    }
            }
            cor[u] = preto;
            this.t[u] = ++tempo;
            return tempo;
    }

    public void buscaEmProfundidade(){
            int tempo = 0;
            int cor[] = new int[this.grafo.numVertices()];

            for (int u = 0; u < grafo.numVertices(); u++) {
                    cor[u] = branco;
                    this.antecessor[u] = -1;
            }

            for (int u = 0; u < grafo.numVertices(); u++)
                    if (cor[u] == branco)
                            tempo = this.visitaDfs(u, tempo, cor);
    }

    public int d(int v){
            return this.d[v];
    }

    public int t(int v){ 
            return this.t[v];
    }

    public int antecessor(int v){
            return this.antecessor[v];
    }
    
    public void conexo(int grafo){
        String retorno;
        System.out.println("Teste " + grafo);
        if(this.t[0] == (this.grafo.numVertices() * 2))
            retorno = "S";
        else
            retorno = "N";
        System.out.println(retorno);
    }
}
