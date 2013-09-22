package analisador.grafos;

/**
 *
 * @author Eli T. de Souza
 * @author Gustavo Sabel
 */
public class Questao5 {
    
    private Questao5(){
    }
    
    public static String chegadasSaidas(int matriz[][], int k){
        int entradas = 0;
        int saidas = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[k][i] > 0)
                saidas++;
        }
        for (int i = 0; i < matriz[k].length; i++) {
            if(matriz[i][k] > 0)
                entradas++;
        }
        
        return "Na cidade " + k + " entram " + entradas + " ruas e saem " + saidas + " ruas.";
    }
    
    public static String cidadeComMaisRuas(int matriz[][]){
        int maiorQtdRuas = 0;
        int cidade = 0;
        int qtdRuas = 0;
                
        for (int i = 0; i < matriz.length; i++) {
            qtdRuas = 0;
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[j][i] > 0)
                    qtdRuas++;
            }
            if(qtdRuas > maiorQtdRuas){
                maiorQtdRuas = qtdRuas;
                cidade = i;
            }
        }
        
        return "A cidade " + cidade + " tem a maior quantidade de ruas que chegam, que é " + maiorQtdRuas + ".";
    }
    
    public static boolean todasMaosDuplas(int matriz[][], int k){
        for (int i = 0; i < matriz.length; i++) {
            if((matriz[k][i] > 0 && matriz[i][k] == 0) ||
                matriz[i][k] > 0 && matriz[k][i] == 0)
                return false;
        }
        return true;
    }
    
    public static String cidadesComSaidaPara(int matriz[][], int k){
        String retorno = "Cidades com saida para a cidade " + k + ": ";
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i][k] > 0){
                retorno += "Cidade " + i + ", ";
            }
        }
        retorno = retorno.substring(0, retorno.length() - 2);
        return retorno;
    }
    
    public static boolean haCidadesIsoladas(int matriz[][]){
        int ruas = 0;
        for (int i = 0; i < matriz.length; i++) {
            ruas = 0;
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[j][i] > 0)
                    ruas++;
            }

            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] > 0)
                    ruas++;
            }
            if(ruas == 0)
                return true;
        }
        return false;
    }
    
    public static boolean haCidadeComEntradaSemSaida(int matriz[][]){
        int saidas = 0;
        int entradas = 0;
        for (int i = 0; i < matriz.length; i++) {
            entradas = 0;
            saidas = 0;
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[j][i] > 0)
                    entradas++;
            }
            if(entradas > 0){
                for (int j = 0; j < matriz.length; j++) {
                    if(matriz[i][j] > 0)
                        saidas++;
                }
                if(saidas == 0)
                    return true;
            }
        }
        return false;
    }
    
    public static boolean haCidadeComSaidaSemEntrada(int matriz[][]){
        int saidas = 0;
        int entradas = 0;
        for (int i = 0; i < matriz.length; i++) {
            entradas = 0;
            saidas = 0;
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j] > 0)
                    saidas++;
            }
            if(saidas > 0){
                for (int j = 0; j < matriz.length; j++) {
                    if(matriz[j][i] > 0)
                        entradas++;
                }
                if(entradas == 0)
                    return true;
            }
        }
        return false;
    }
    
    public static boolean caminhoPossivel(int matriz[][], int caminho[]){
        for (int i = 0; i < caminho.length - 1; i++) {
            if(matriz[caminho[i]][caminho[i + 1]] == 0)
                return false;
        }
        return true;
    }
        
}
