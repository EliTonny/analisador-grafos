package analisador.grafos;

import java.util.Scanner;

/**
 *
 * @author Eli T. de Souza
 * @author Gustavo Sabel
 */
public class Questao6 {

    public static final int Infinito = Integer.MAX_VALUE;

    public void menorCaminho() {
        Scanner scan = new Scanner(System.in);
        String valorMatriz;
        String[] vetorAux;
        char inicio;
        char fim;
        int tamanho;
        int[][] matriz;

        while (true) {
            try {
                tamanho = Integer.parseInt(scan.nextLine());
                matriz = new int[tamanho][tamanho];
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Valor incorretos. Informe o tamanho do grafo");
            } catch (NegativeArraySizeException ex) {
                System.out.println("Valor incorretos. Informe um valor positivo.");
            }
        }

        while (true) {
            try {
                String iniFim = scan.nextLine();
                inicio = iniFim.charAt(0);
                fim = iniFim.charAt(2);

                if (toNumero(inicio) < 0 || toNumero(inicio) > tamanho - 1
                        || toNumero(fim) < 0 || toNumero(fim) > tamanho - 1) {
                    throw new IndexOutOfBoundsException();
                }

                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println(
                        "Valores incorretos. Informe o vértice de inicio e fim entre A e " + (char) (64 + tamanho));
            }
        }

        for (int i = 0; i < tamanho; i++) {
            while (true) {
                try {
                    valorMatriz = scan.nextLine();
                    vetorAux = valorMatriz.split(" ");

                    for (int j = 0; j < vetorAux.length; j++) {
                        if (vetorAux[j].equalsIgnoreCase("I")) {
                            matriz[i][j] = Infinito;
                        } else {
                            matriz[i][j] = Integer.parseInt(vetorAux[j]);
                        }
                    }
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(
                            "Valores incorretos. Deve ser informado " + tamanho + " numeros por Linha. "
                            + "Poder ser informado I para representar o infinito");
                } catch (NumberFormatException ex) {
                    System.out.println(
                            "Valores incorretos. Deve ser informado " + tamanho + " numeros por Linha. "
                            + "Poder ser informado I para representar o infinito");
                }
            }
        }

        System.out.println(new Questao6().menorCaminho(matriz, inicio, fim));
    }

    public String menorCaminho(int[][] grafo, char inicio, char fim) {
        int inicioInt = toNumero(inicio);
        int fimInt = toNumero(fim);

        Vertice[] vertices = new Vertice[grafo.length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice();
            vertices[i].custo = Infinito;
            vertices[i].pai = -1;
        }
        vertices[inicioInt].custo = 0;

        while (!todosProcessados(vertices)) {
            int u = retornaMenor(vertices);
            vertices[u].processado = true;

            for (int i = 0; i < grafo.length; i++) {
                if (grafo[u][i] < Infinito) {
                    Relax(u, i, grafo[u][i], vertices);
                }
            }
        }

        String saida = "Caminho mínimo: " + imprime(fimInt, vertices);
        if (saida.length() > 0) {
            saida = saida.substring(0, saida.length() - 4);
        }
        saida += "\nCusto: " + vertices[fimInt].custo;
        return saida;
    }

    private int retornaMenor(Vertice[] vertices) {
        int menor = -1;
        int custoMenor = Infinito;
        for (int i = 0; i < vertices.length; i++) {
            if (!vertices[i].isProcessado()) {
                if (vertices[i].custo < custoMenor) {
                    menor = i;
                    custoMenor = vertices[i].custo;
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

    private String imprime(int u, Vertice[] vertices) {
        if (u < 0) {
            return "";
        }
        return imprime(vertices[u].pai, vertices) + toLetra(u) + " -> ";
    }

    private void Relax(int u, int v, int w, Vertice[] vertices) {
        if (vertices[v].custo > vertices[u].custo + w) {
            vertices[v].custo = vertices[u].custo + w;
            vertices[v].pai = u;
        }
    }

    private int toNumero(char letra) {
        return letra - 65;
    }

    private char toLetra(int numero) {
        return (char) (numero + 65);
    }

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
}
