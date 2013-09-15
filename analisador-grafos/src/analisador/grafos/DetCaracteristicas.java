package analisador.grafos;

/**
 *
 * @author Eli T. de Souza
 */
public class DetCaracteristicas {
    
    private DetCaracteristicas(){
    }
    
    public static boolean isNulo(int matriz [][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
    
    public static boolean isRegular(int matriz [][]){
        int grau = 0;
        int grauAnt = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            grau = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                grau += matriz[i][j];
            }
            if(i == 0)
                grauAnt = grau;
            else if(grauAnt != grau)
                return false;
        }
        return true;
    }
    
    public static boolean isCompleto(int matriz [][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i == j && matriz[i][j] != 0)
                    return false;
                if(i != j && matriz[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    
    public static String sequenciaGraus(int matriz[][]){
        int grau = 0;
        int [] listaGraus = new int[matriz.length];
        String retorno = "";
        
        for (int i = 0; i < matriz.length; i++) {
            grau = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                grau += matriz[i][j];
            }
            retorno += "Vértice: " + Integer.toString(i) + " Grau: " + Integer.toString(grau) + "\n";
            listaGraus[i] = grau;
        }
        listaGraus = DetCaracteristicas.bubbleSort(listaGraus);
        retorno += "Sequência de Graus: ";
        for (int i = 0; i < listaGraus.length; i++) {
            retorno += Integer.toString(listaGraus[i]) + " ";
        }
        return retorno;
    }
    
    private static int[] bubbleSort(int[] vetor){
        int aux = 0;
        for(int i = 0; i < vetor.length;i++){
            for(int j = 0; j < (vetor.length - 1 - i); j++){
                if(vetor[j] > vetor[j + 1]){
                   aux = vetor[j];
                   vetor[j] = vetor[j + 1];
                   vetor[j + 1] = aux;
                }
            }
        }
        return vetor;
    }
    
    public static String conjArestas(int matriz [][]){
        String retorno = "E = {";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0 + i; j < matriz[i].length; j++) {
                if(matriz[i][j] > 0)
                    retorno += "(" + Integer.toString(i) + ", " + Integer.toString(j) + "), ";
            }
        }
        retorno = retorno.substring(0, retorno.length() - 2) + "}";
        return retorno;
    }
}
