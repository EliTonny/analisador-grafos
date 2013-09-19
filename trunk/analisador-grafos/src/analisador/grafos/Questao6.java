package analisador.grafos;

public class Questao6 {

    private class Vertice {

        private int custo;
        private int pai;
        private boolean processado;

        public int getCusto() {
            return custo;
        }

        public void setCusto(int custo) {
            this.custo = custo;
        }

        public int getPai() {
            return pai;
        }

        public void setPai(int pai) {
            this.pai = pai;
        }

        public boolean isProcessado() {
            return processado;
        }

        public void setProcessado(boolean verificado) {
            this.processado = verificado;
        }
    }
    
    private int retornaMenor(Vertice[] vertices) {
        int menor = 0;
        for (int i = 1; i < vertices.length; i++) {
            if (!vertices[i].isProcessado()) {
                if (vertices[menor].custo > vertices[i].custo) {
                    menor = i;
                }
            }
        }
        return menor;
    }

    private boolean todosProcessados(Vertice[] vertices) {
        for (int i = 1; i < vertices.length; i++) {
            if (!vertices[i].isProcessado()) {
                return false;
            }
        }
        return true;
    }

    public String menorCaminho(int[][] grafo, int inicio, int fim) {
        Vertice[] vertices = new Vertice[grafo.length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice();
            vertices[i].custo = Integer.MAX_VALUE;
            vertices[i].pai = -1;
        }
        vertices[inicio].custo = 0;

        while (!todosProcessados(vertices)) {
            int u = retornaMenor(vertices);
            vertices[u].processado = true;

            for (int i = 0; i < grafo.length; i++) {
                if (grafo[u][i] < Integer.MAX_VALUE) {
                    Relax(u, i, grafo[u][i], vertices);
                }
            }
        }
        
        String saida = "Caminho mínimo: " + imprime(fim, vertices);
        if(saida.length() > 0)
            saida = saida.substring(0, saida.length() - 4 );
        saida += "\nCusto: " + vertices[fim].custo;
        return saida;
    }
    
    
    private String imprime(int u, Vertice[] vertices)
    {
        if(u < 0)
            return "";
        return imprime(vertices[u].pai, vertices) + (char) (u + 65) + " -> ";
    }

    private void Relax(int u, int v, int w, Vertice[] vertices) {
        if (vertices[v].custo > vertices[u].custo + w) {
            vertices[v].custo = vertices[u].custo + w;
            vertices[v].pai = u;
        }
    }
}
