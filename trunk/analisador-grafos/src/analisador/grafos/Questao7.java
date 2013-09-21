package analisador.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao7 {

    public static void Verifica() {

        int[] numerosAux;
        int numVertices;
        int numArestras;
        int[][] grafo;
        ArrayList<int[][]> grafos = new ArrayList<int[][]>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            while (true) {
                try {
                    numerosAux = Questao7.traduzEntrada(scan.nextLine());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Valores incorretos. Informe novamente.");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Valores incorretos. Informe apenas 2 valores.");
                }
            }
            if (numerosAux[0] == 0 && numerosAux[1] == 0) {
                break;
            }

            numVertices = numerosAux[0];
            numArestras = numerosAux[1];
            grafo = new int[numVertices][numVertices];

            for (int i = 0; i < numArestras; i++) {
                while (true) {
                    try {
                        numerosAux = traduzEntrada(scan.nextLine());
                        if (numerosAux[0] < 1 || numerosAux[0] > numVertices
                                || numerosAux[1] < 1 || numerosAux[1] > numVertices) {
                            throw new IndexOutOfBoundsException();
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Valores incorretos. Informe novamente.");
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Valores incorretos. Informe apenas 2 valores.");
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Valores incorretos. Apenas valores de 1 a " + numVertices + ".");
                    }
                }
                grafo[numerosAux[0] - 1][numerosAux[1] - 1] = 1;
            }
            grafos.add(grafo);
        }
        scan.close();
        ExecutaVerificacao(grafos);
    }

    public static void ExecutaVerificacao(List<int[][]> grafos) {
        for (int[][] grafo : grafos) {
            System.out.println("Grafo:");
            for (int i = 0; i < grafo.length; i++) {
                for (int j = 0; j < grafo.length; j++) {
                    System.out.print(grafo[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Fim");
    }

    public static int[] traduzEntrada(String entrada) {
        int[] numeros = new int[2];
        int contador = 0;
        String[] caracteres = entrada.split(" ");
        for (int i = 0; i < caracteres.length; i++) {
            if (!caracteres[i].equals("")) {
                numeros[contador++] = Integer.parseInt(caracteres[i]);
            }
        }
        if (contador < 2) {
            throw new NumberFormatException();
        }

        return numeros;
    }
}
