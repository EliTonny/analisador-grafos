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
        
    }
}
