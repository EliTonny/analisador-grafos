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
        
        int[][] matriz2 = new int[13][13];
        
        matriz2[0][2] = 1;
        matriz2[0][6] = 1;
        matriz2[1][7] = 1;
        matriz2[2][5] = 1;
        matriz2[2][7] = 1;
        matriz2[3][6] = 1;
        matriz2[3][7] = 1;
        matriz2[4][7] = 1;
        matriz2[6][1] = 1;
        matriz2[7][4] = 1;
        matriz2[7][12] = 1;
        matriz2[8][3] = 1;
        matriz2[8][9] = 1;
        matriz2[8][11] = 1;
        matriz2[9][12] = 1;
        matriz2[10][0] = 2;
        matriz2[10][7] = 1;
        matriz2[10][11] = 1;
        matriz2[11][4] = 1;
        matriz2[11][10] = 1;
        matriz2[11][12] = 1;
        matriz2[12][11] = 1;
        
        System.out.println(Questao4.QuaisAlunosLideramOGrupo(matriz2));
        System.out.println(Questao4.QuaisAlunosPossuemAmizadeReciproca(matriz2));
        System.out.println(Questao4.QuaisAlunosTemProblemaDeRelacionamento(matriz2));
        
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
}
