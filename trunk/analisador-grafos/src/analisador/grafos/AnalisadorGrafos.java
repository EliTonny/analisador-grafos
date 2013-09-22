package analisador.grafos;

import java.util.ArrayList;

/**
 *
 * @author Eli T. de Souza
 * @author Gustavo Sabel
 */
public class AnalisadorGrafos {

    public static void main(String[] args) {
        TestaQuestao3();
        TestaQuestao4();
        TestaQuestao5();
        //TestaQuestao6();
        TesteQuestao6_1();
        //TestaQuestao7();
        TestaQuestao7_1();
    }

    private static void TestaQuestao3() {
        System.out.println(" ------------------- QUESTÃO 3 -----------------------------");
        int[][] matriz = new int[5][5];

        //matriz[0][1] = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i != j) {
                    matriz[i][j] = 1;
                }
            }
        }
        matriz[4][3] = 0;
        matriz[3][4] = 0;
        ImprimeMatriz(matriz);

        System.out.println("a)");
        System.out.println("É nulo? \r\nResposta: " + Questao3.isNulo(matriz));
        System.out.println("É regular? \r\nResposta: " + Questao3.isRegular(matriz));
        System.out.println("É completo? \r\nResposta: " + Questao3.isCompleto(matriz));
        System.out.println("b)");
        System.out.println("Conjunto de Arestras \r\nResposta: " + Questao3.conjArestas(matriz));
        System.out.println("c)");
        System.out.println("Sequencia de graus \r\nResposta: \r\n" + Questao3.sequenciaGraus(matriz));
        System.out.println();

        matriz = new int[5][5];
        matriz[0][1] = 1;
        matriz[0][2] = 1;
        matriz[1][0] = 1;
        matriz[1][3] = 1;
        matriz[2][0] = 1;
        matriz[2][4] = 1;
        matriz[3][1] = 1;
        matriz[3][4] = 1;
        matriz[4][2] = 1;
        matriz[4][3] = 1;
        ImprimeMatriz(matriz);
        System.out.println("1 É bipartido? \r\nResposta: " + Questao3.isBipartido(matriz));
        System.out.println();

        matriz = new int[5][5];
        matriz[0][1] = 1;
        matriz[0][2] = 1;
        matriz[1][0] = 1;
        matriz[1][3] = 1;
        matriz[2][0] = 1;
        matriz[3][1] = 1;
        matriz[3][4] = 1;
        matriz[4][3] = 1;
        ImprimeMatriz(matriz);
        System.out.println("2 É bipartido? \r\nResposta: " + Questao3.isBipartido(matriz));
        System.out.println();

        matriz = new int[5][5];
        matriz[0][1] = 1;
        matriz[1][0] = 1;
        matriz[2][3] = 1;
        matriz[3][2] = 1;
        matriz[3][4] = 1;
        matriz[4][2] = 1;
        ImprimeMatriz(matriz);
        System.out.println("3 É bipartido? \r\nResposta: " + Questao3.isBipartido(matriz));
        System.out.println();
    }

    private static void TestaQuestao4() {
        System.out.println(" ------------------- QUESTÃO 4 -----------------------------");

        int[][] matriz3 = new int[13][13];

        matriz3[0][2] = 1;
        matriz3[0][6] = 1;
        matriz3[1][7] = 1;
        matriz3[2][5] = 1;
        matriz3[2][7] = 1;
        matriz3[3][6] = 1;
        matriz3[3][7] = 1;
        matriz3[4][7] = 1;
        matriz3[6][1] = 1;
        matriz3[7][4] = 1;
        matriz3[7][12] = 1;
        matriz3[8][3] = 1;
        matriz3[8][9] = 1;
        matriz3[8][11] = 1;
        matriz3[9][12] = 1;
        matriz3[10][0] = 2;
        matriz3[10][7] = 1;
        matriz3[10][11] = 1;
        matriz3[11][4] = 1;
        matriz3[11][10] = 1;
        matriz3[11][12] = 1;
        matriz3[12][11] = 1;

        ImprimeMatriz(matriz3);

        System.out.println();
        System.out.println("a. Quais são os alunos que lideram o grupo?");
        System.out.println("Resposta: " + String.valueOf(Questao4.QuaisAlunosLideramOGrupo(matriz3)));
        System.out.println("b. Quais são os alunos que possuem amizades recíprocas?");
        System.out.println("Resposta: " + Questao4.QuaisAlunosPossuemAmizadeReciproca(matriz3));
        System.out.println("c. Quais são os alunos que têm problemas de relacionamento?");
        System.out.println("Resposta: " + Questao4.QuaisAlunosTemProblemaDeRelacionamento(matriz3));
    }

    private static void TestaQuestao5() {
        System.out.println("------------------ Questão 5 -----------------------------");
        int[][] cidades = new int[5][5];
        int[] caminho = {2, 1, 4, 3};

        cidades[1][0] = 1;
        cidades[1][2] = 1;
        cidades[1][4] = 1;
        cidades[2][1] = 1;
        cidades[3][1] = 1;
        cidades[4][1] = 1;
        cidades[4][3] = 1;
        ImprimeMatriz(cidades);
        System.out.println(Questao5.chegadasSaidas(cidades, 1));
        System.out.println(Questao5.cidadeComMaisRuas(cidades));
        System.out.println(Questao5.todasMaosDuplas(cidades, 0));
        System.out.println(Questao5.cidadesComSaidaPara(cidades, 1));
        System.out.println(Questao5.haCidadesIsoladas(cidades));
        System.out.println(Questao5.haCidadeComEntradaSemSaida(cidades));
        System.out.println(Questao5.haCidadeComSaidaSemEntrada(cidades));
        System.out.println(Questao5.caminhoPossivel(cidades, caminho));
    }

    private static void TestaQuestao6() {
        System.out.println("------------------ Questão 6 Manual -----------------------------");
        new Questao6().menorCaminho();
    }

    private static void TesteQuestao6_1() {
        System.out.println("------------------ Questão 6 Automatico -----------------------------");

        int[][] matriz = new int[7][7];
        matriz[0][0] = 0;
        matriz[0][1] = Questao6.Infinito;
        matriz[0][2] = Questao6.Infinito;
        matriz[0][3] = Questao6.Infinito;
        matriz[0][4] = Questao6.Infinito;
        matriz[0][5] = Questao6.Infinito;
        matriz[0][6] = Questao6.Infinito;
        //0 I I I I I I

        matriz[1][0] = Questao6.Infinito;
        matriz[1][1] = 0;
        matriz[1][2] = 1;
        matriz[1][3] = Questao6.Infinito;
        matriz[1][4] = Questao6.Infinito;
        matriz[1][5] = Questao6.Infinito;
        matriz[1][6] = Questao6.Infinito;
        //I 0 1 I I I I 

        matriz[2][0] = 4;
        matriz[2][1] = Questao6.Infinito;
        matriz[2][2] = 0;
        matriz[2][3] = Questao6.Infinito;
        matriz[2][4] = Questao6.Infinito;
        matriz[2][5] = Questao6.Infinito;
        matriz[2][6] = Questao6.Infinito;
        //4 I 0 I I I I 

        matriz[3][0] = Questao6.Infinito;
        matriz[3][1] = 3;
        matriz[3][2] = Questao6.Infinito;
        matriz[3][3] = 0;
        matriz[3][4] = 1;
        matriz[3][5] = Questao6.Infinito;
        matriz[3][6] = Questao6.Infinito;
        //I 3 I 0 1 I I 

        matriz[4][0] = Questao6.Infinito;
        matriz[4][1] = Questao6.Infinito;
        matriz[4][2] = 2;
        matriz[4][3] = Questao6.Infinito;
        matriz[4][4] = 0;
        matriz[4][5] = Questao6.Infinito;
        matriz[4][6] = Questao6.Infinito;
        //I I 2 I 0 I I

        matriz[5][0] = Questao6.Infinito;
        matriz[5][1] = Questao6.Infinito;
        matriz[5][2] = Questao6.Infinito;
        matriz[5][3] = 3;
        matriz[5][4] = Questao6.Infinito;
        matriz[5][5] = 0;
        matriz[5][6] = 2;
        //I I I 3 I 0 2 

        matriz[6][0] = Questao6.Infinito;
        matriz[6][1] = Questao6.Infinito;
        matriz[6][2] = Questao6.Infinito;
        matriz[6][3] = Questao6.Infinito;
        matriz[6][4] = 5;
        matriz[6][5] = Questao6.Infinito;
        matriz[6][6] = 0;
        //I I I I 5 I 0
        ImprimeMatriz(matriz);
        //espera-se F, D, E, C, A 
        System.out.println(new Questao6().menorCaminho(matriz, 'F', 'A'));
    }

    private static void TestaQuestao7() {
        System.out.println("------------------ Questão 7 Manual -----------------------------");
        Questao7.Verifica();
    }

    private static void TestaQuestao7_1() {
        System.out.println("------------------ Questão 7 Automatico -----------------------------");

        ArrayList<int[][]> grafos = new ArrayList<int[][]>();

        int[][] grafo = new int[3][3];
        grafo[0][1] = 1;
        grafo[2][1] = 1;
        grafo[0][2] = 1;
        grafo[1][2] = 1;

        grafos.add(grafo);

        grafo = new int[3][3];
        grafo[1][2] = 1;
        grafo[2][1] = 1;
        grafo[0][1] = 1;
        grafo[2][0] = 1;

        grafos.add(grafo);

        System.out.println("Grafo 1");
        ImprimeMatriz(grafos.get(0));
        System.out.println("Grafo 2");
        ImprimeMatriz(grafos.get(0));

        Questao7.ExecutaVerificacao(grafos);
        /*  entrada:
         3 4
         1 2
         3 2
         1 3
         2 3
         3 4
         2 3
         3 2
         1 2
         3 1
         0 0
         */

        /*  saida:
         Teste 1
         N
         Teste 2
         S
         */
    }

    private static void ImprimeMatriz(int[][] matriz) {
        System.out.print("  ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((char) (i + 65) + " ");
        }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < Questao6.Infinito) {
                    System.out.print(matriz[i][j] + " ");
                } else {
                    System.out.print("I ");
                }
            }
            System.out.println();
        }
    }
}
