package analisador.grafos;

import java.util.Scanner;

/**
 *
 * @author Eli T. de Souza
 */
public class AnalisadorGrafos {
    public static void main(String[] args) {
        //TestaQuestao3();
        //TestaQuestao4();
        //TestaQuestao5();
        //TestaQuestao6();
        TesteQuestao6_1();
    }
    
    private static void TestaQuestao3()
    {
        int [][] matriz = new int [5][5];
        
        //matriz[0][1] = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i != j)
                    matriz[i][j] = 1;
            }
        }
        matriz[4][3] = 0;
        matriz[3][4] = 0;
        
        System.out.println(DetCaracteristicas.isNulo(matriz));
        System.out.println(DetCaracteristicas.isRegular(matriz));
        System.out.println(DetCaracteristicas.isCompleto(matriz));
        System.out.println(DetCaracteristicas.sequenciaGraus(matriz));
        System.out.println(DetCaracteristicas.conjArestas(matriz));
        
        int[][] matriz2 = new int[5][5];
        
        matriz2[0][1] = 1;
        matriz2[0][2] = 1;
        matriz2[1][0] = 1;
        matriz2[1][3] = 1;
        matriz2[2][0] = 1;
        matriz2[2][4] = 1;
        matriz2[3][1] = 1;
        matriz2[3][4] = 1;       
        matriz2[4][2] = 1;
        matriz2[4][3] = 1;
        System.out.print("1É bipartido?");
        System.out.println(DetCaracteristicas.isBipartido(matriz));
        
        int[][] matriz21 = new int[5][5];
        matriz21[0][1] = 1;
        matriz21[0][2] = 1;
        matriz21[1][0] = 1;
        matriz21[1][3] = 1;
        matriz21[2][0] = 1;
        //matriz21[2][4] = 1;
        matriz21[3][1] = 1;
        matriz21[3][4] = 1;       
        //matriz21[4][2] = 1;
        matriz21[4][3] = 1;
        System.out.print("2É bipartido?");
        System.out.println(DetCaracteristicas.isBipartido(matriz21));
        
        int[][] matriz22 = new int[5][5];
        matriz22[0][1] = 1;
        matriz22[1][0] = 1;
        matriz22[2][3] = 1;
        matriz22[3][2] = 1;
        matriz22[3][4] = 1;
        matriz22[4][2] = 1;
        System.out.print("3É bipartido?");
        System.out.println(DetCaracteristicas.isBipartido(matriz22));
    }
    
    private static void TestaQuestao4()
    {
        System.out.println(" ---------- QUESTÃO 4 -----------" );
        
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
        
        System.out.println(Questao4.QuaisAlunosLideramOGrupo(matriz3));
        System.out.println(Questao4.QuaisAlunosPossuemAmizadeReciproca(matriz3));
        System.out.println(Questao4.QuaisAlunosTemProblemaDeRelacionamento(matriz3));
    }
    
    private static void TestaQuestao5()
    {
        System.out.println("--------- Questão 5 -----------");
        int [][] cidades = new int [5][5];
        int [] caminho = {2,1,4,3};
        
        cidades[1][0] = 1;
        cidades[1][2] = 1;
        cidades[1][4] = 1;
        cidades[2][1] = 1;
        cidades[3][1] = 1;
        cidades[4][1] = 1;
        cidades[4][3] = 1;
        
        System.out.println(Questao5.chegadasSaidas(cidades, 1));
        System.out.println(Questao5.cidadeComMaisRuas(cidades));
        System.out.println(Questao5.todasMaosDuplas(cidades, 0));
        System.out.println(Questao5.cidadesComSaidaPara(cidades, 1));
        System.out.println(Questao5.haCidadesIsoladas(cidades));
        System.out.println(Questao5.haCidadeComEntradaSemSaida(cidades));
        System.out.println(Questao5.haCidadeComSaidaSemEntrada(cidades));
        System.out.println(Questao5.caminhoPossivel(cidades, caminho));
    }
    
    private static void TestaQuestao6()
    {
        int infinito = Integer.MAX_VALUE; // infinito

        int[][] matriz = new int[7][7];
        matriz[0][0] = 0;
        matriz[0][1] = infinito;
        matriz[0][2] = infinito;
        matriz[0][3] = infinito;
        matriz[0][4] = infinito;
        matriz[0][5] = infinito;
        matriz[0][6] = infinito;
        //0 I I I I I I
        
        matriz[1][0] = infinito;
        matriz[1][1] = 0;
        matriz[1][2] = 1;
        matriz[1][3] = infinito;
        matriz[1][4] = infinito;
        matriz[1][5] = infinito;
        matriz[1][6] = infinito;
        //I 0 1 I I I I 
                
        matriz[2][0] = 4;
        matriz[2][1] = infinito;
        matriz[2][2] = 0;
        matriz[2][3] = infinito;
        matriz[2][4] = infinito;
        matriz[2][5] = infinito;
        matriz[2][6] = infinito;
        //4 I 0 I I I I 
                
        matriz[3][0] = infinito;
        matriz[3][1] = 3;
        matriz[3][2] = infinito;
        matriz[3][3] = 0;
        matriz[3][4] = 1;
        matriz[3][5] = infinito;
        matriz[3][6] = infinito;
        //I 3 I 0 1 I I 
                
        matriz[4][0] = infinito;
        matriz[4][1] = infinito;
        matriz[4][2] = 2;
        matriz[4][3] = infinito;
        matriz[4][4] = 0;
        matriz[4][5] = infinito;
        matriz[4][6] = infinito;
        //I I 2 I 0 I I
                
        matriz[5][0] = infinito;
        matriz[5][1] = infinito;
        matriz[5][2] = infinito;
        matriz[5][3] = 3;
        matriz[5][4] = infinito;
        matriz[5][5] = 0;
        matriz[5][6] = 2;
        //I I I 3 I 0 2 
        
        matriz[6][0] = infinito;
        matriz[6][1] = infinito;
        matriz[6][2] = infinito;
        matriz[6][3] = infinito;
        matriz[6][4] = 5;
        matriz[6][5] = infinito;
        matriz[6][6] = 0;
        //I I I I 5 I 0
        
        //espera-se F, D, E, C, A 
        System.out.println(new Questao6().menorCaminho(matriz, 5, 0));
    }
    
    private static void TesteQuestao6_1(){
        Scanner scan = new Scanner(System.in);
        String valorMatriz;
        String [] vetor;
        
        int tam = Integer.parseInt(scan.nextLine());
        int [][]matriz = new int[tam][tam];
        String [] vetor2;
        
        String iniFim = scan.nextLine();
        
        vetor = iniFim.split(" ");
        
        for (int i = 0; i < tam; i++) {
            valorMatriz = scan.nextLine();
            vetor2 = valorMatriz.split(" ");
            
            for (int j = 0; j < vetor2.length; j++) {
                if(vetor2[j].equals("I")){
                    matriz[i][j] = Integer.MAX_VALUE;
                } else{
                    matriz[i][j] = Integer.parseInt(vetor2[j]);
                }
            }
        }
        
        System.out.println(new Questao6().menorCaminho(matriz, vetor[0].charAt(0) - 65, vetor[1].charAt(0) - 65));
    }
}
