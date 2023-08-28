import java.util.Arrays;

public class Matriz <T>{
    private int cor_preta = 0;
    private Pilha pilha_coordenadas;
    private Fila fila_coordenadas;
    private int[][] arrays_matriz;

    public Matriz(){
        this.arrays_matriz = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        this.pilha_coordenadas = new Pilha(this.arrays_matriz.length*this.arrays_matriz.length);
        this.fila_coordenadas = new Fila(this.arrays_matriz.length*this.arrays_matriz.length);
    }

    public void PrintMatriz(){
        for(int[] linha : this.arrays_matriz){
            System.out.println(Arrays.toString(linha));
        }
    }

    public void IniciarPintura(int linha_escolhida, int coluna_escolhida, int novaCor, boolean pilha){
        int antigaCor = this.arrays_matriz[linha_escolhida][coluna_escolhida];

        if(pilha){
            PintarPilha(linha_escolhida, coluna_escolhida, novaCor, antigaCor);
        } else{
            PintarFila(linha_escolhida, coluna_escolhida, novaCor, antigaCor);
        }

    }

    public void PintarFila(int linha_escolhida, int coluna_escolhida, int novaCor, int antigaCor){

        if(this.arrays_matriz[linha_escolhida][coluna_escolhida] == antigaCor) { // Caso a cor seja igual à da posição anterior, o valor da cor atual é alterado, e então, as laterais entram na pilha para serem testadas posteriormente
            this.arrays_matriz[linha_escolhida][coluna_escolhida] = novaCor;

            if(linha_escolhida - 1 > -1){ fila_coordenadas.Add( new int[]{linha_escolhida-1, coluna_escolhida} ); } // Topo
            if(linha_escolhida + 1 < this.arrays_matriz.length){ fila_coordenadas.Add( new int[]{linha_escolhida+1, coluna_escolhida} ); } // Base
            if(coluna_escolhida - 1 > -1){ fila_coordenadas.Add( new int[]{linha_escolhida, coluna_escolhida-1} ); } // Esquerda
            if(coluna_escolhida + 1 < this.arrays_matriz.length){ fila_coordenadas.Add( new int[]{linha_escolhida, coluna_escolhida+1} ); } // Direita
        }

        if(!this.fila_coordenadas.IsEmpty()) {                         // Caso o a pilha de coordenadas não esteja vazia, a recursividade continua.
            int[] coordenadas = (int[]) this.fila_coordenadas.Remove(); // As posições da linha e coluna são trazidos da pilha, e então, utilizados como parâmetro na recursividade
            PintarFila(coordenadas[0], coordenadas[1], novaCor, antigaCor);
        }

    }

    public void PintarPilha(int linha_escolhida, int coluna_escolhida, int novaCor, int antigaCor){
        /* ALGORITMO PintarPilha()
           1- Verificar se a cor da coordenada passada no parâmetro da função é igual a antigaCor
           2- Caso positivo: Muda a cor da coordenada passada no parâmetro e adiciona os pontos adjacentes (que não sejam OutOfBounds) em uma pilha
           3- Caso negativo: Não faz nada

           Depois da primeira execução ficamos chamando a função novamente e passando no parâmetro a coordenada que puxarmos da pilha através do Pop()
           Isso acontecerá recursivamente até a pilha não ter mais coordenadas para executarem a função de PintarPilha()
        */

        if(this.arrays_matriz[linha_escolhida][coluna_escolhida] == antigaCor) {
            this.arrays_matriz[linha_escolhida][coluna_escolhida] = novaCor;

            // Ifs que irão empilhar as posições adjacentes
            if(linha_escolhida - 1 > -1){ pilha_coordenadas.Push( new int[]{linha_escolhida-1, coluna_escolhida} ); } // Cima
            if(linha_escolhida + 1 < this.arrays_matriz.length){ pilha_coordenadas.Push( new int[]{linha_escolhida+1, coluna_escolhida} ); } // Baixo
            if(coluna_escolhida - 1 > -1){ pilha_coordenadas.Push( new int[]{linha_escolhida, coluna_escolhida-1} ); } // Esquerda
            if(coluna_escolhida + 1 < this.arrays_matriz.length){ pilha_coordenadas.Push( new int[]{linha_escolhida, coluna_escolhida+1} ); } // Direita
        }

        if(!this.pilha_coordenadas.IsEmpty()) { // If para controlar a recursividade
            // Enquanto a pilha de coordenadas não estiver vazia, a recursividade continua
            int[] coordenadas = (int[]) this.pilha_coordenadas.Pop();
            // coordenadas[0] contém o valor da linha
            // coordenadas[1] contém o valor da coluna
            PintarPilha(coordenadas[0], coordenadas[1], novaCor, antigaCor);
        }

    }

}
