package analisador.grafos;

/**
 *
 * @author Eli T. de Souza
 */
public class AnalisadorGrafos {
    public static void main(String[] args) {
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
        
        System.out.println(" ---------- QUESTÃO 4 -----------" );
        
        int[][] matriz2 = new int[4][4];
        
        matriz2[0][3] = 1;
        matriz2[1][2] = 1;
        matriz2[1][3] = 1;
        matriz2[2][1] = 1;
        
        System.out.println(Questao4.QuaisAlunosLideramOGrupo(matriz2));
        System.out.println(Questao4.QuaisAlunosPossuemAmizadeReciproca(matriz2));
        System.out.println(Questao4.QuaisAlunosTemProblemaDeRelacionamento(matriz2));
    }
}
