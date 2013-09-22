package analisador.grafos;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Eli T. de Souza
 * @author Gustavo Sabel
 */
public class Questao3 {
    
    private Questao3(){
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
    
    public static boolean isBipartido(int[][] matriz)
    {
        if(matriz.length <= 1)
            return false;
        
        int[] marcaVertices = new int[matriz.length];
        Stack<Integer> pilha = new Stack<Integer>();
        Set<Integer> verificados = new HashSet<Integer>();
        pilha.add(0);
        
        while(!pilha.isEmpty())
        {
            if(!marcaBipartido(matriz, pilha, marcaVertices, verificados))
                return false;
            for(int i = 0; i< marcaVertices.length; i++)
                if(marcaVertices[i] == 0)
                    pilha.add(i);
        }
        
        return true;
    }
    
    public static boolean marcaBipartido(int[][] matriz, Stack<Integer> pilha, int[] marcaVertices, Set<Integer> verificados)
    {
        while(!pilha.empty())
        {
            int coluna = pilha.pop();
            if(marcaVertices[coluna] == 0)
                marcaVertices[coluna] = 1;
            int marcador = 1;
            if(marcaVertices[coluna] == 1)
                marcador = 2;

            for (int linha = 0; linha < matriz.length; linha++) {
                if(matriz[linha][coluna] > 0)
                {
                    if(marcaVertices[linha] != 0 && marcaVertices[linha] != marcador)
                    {
                        return false;
                    }
                    else if(marcaVertices[linha] == 0)
                    {
                        marcaVertices[linha] = marcador;
                    }
                    
                    if(!verificados.contains(linha))
                        pilha.push(linha);
                }
            }
            verificados.add(coluna);
        }
        return true;
    }
    
       /* 
    public static boolean isBipartido(int[][] matriz)
    {
        int[] vertices = new int[matriz.length];
        Stack<Integer> pilha = new Stack<Integer>();
        for (int coluna = 0; coluna < matriz.length; coluna++) {
            if(vertices[coluna] == 0)
                vertices[coluna] = 1;
            int marcador = 1;
            if(vertices[coluna] == 1)
                marcador = 2;
            
            for (int linha = 0; linha < matriz.length; linha++) {
                if(matriz[linha][coluna] > 0)
                {
                    if(vertices[linha] != 0 && vertices[linha] != marcador)
                        return false;
                    else if(vertices[linha] == 0)
                        vertices[linha] = marcador;
                }
            }
        }
        return true;
    }
    */
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
        listaGraus = Questao3.bubbleSort(listaGraus);
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
