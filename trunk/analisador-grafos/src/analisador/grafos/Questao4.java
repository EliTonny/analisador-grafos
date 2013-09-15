package analisador.grafos;

public class Questao4 {

    public static int QuaisAlunosLideramOGrupo(int[][] matriz) {
        int lider = -1;
        int somaLider = -1;
        for (int coluna = 0; coluna < matriz.length; coluna++) {
            int soma = 0;
            for (int linha = 0; linha < matriz.length; linha++) {
                soma += matriz[linha][coluna];
            }
            if(soma > somaLider)
            {
                lider = coluna;
                somaLider = soma;
            }
        }
        return lider;
    }

    public static String QuaisAlunosPossuemAmizadeReciproca(int[][] matriz) {
        
        String saida = "";
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = linha + 1; coluna < matriz.length; coluna++) {
                
                if(matriz[linha][coluna] >= 1 && matriz[coluna][linha] >= 1)
                {
                    saida += "("+ coluna + " " + linha + ") ";
                }
                
            }
        }
        return saida;
        
    }

    public static String QuaisAlunosTemProblemaDeRelacionamento(int[][] matriz) {
        
        String saida = "";
        for (int coluna = 0; coluna < matriz.length; coluna++) {
            boolean temAmigos = false;
            for (int linha = 0; linha < matriz.length; linha++) {
                if(matriz[linha][coluna] >= 1)
                {
                    temAmigos = true;
                    break;
                }
                
            }
            if(!temAmigos)
                saida += coluna + ", ";
        }
        if(saida.length() > 0)
            saida = saida.substring(0, saida.length() -2);
        return saida;
        
    }
}
