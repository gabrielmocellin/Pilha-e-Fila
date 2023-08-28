public class Main{
    /* Algoritmo
           1- Ao escolher um ponto na matriz, o ponto inicial é pintado com a nova cor.
           2- As coordenadas das laterais são colocadas na pilha.
           3- Após, retirar o primeiro elemento da pilha e transformá-lo em "ponto inicial"


           1- Ao escolher o ponto inicial (coordenadas) da matriz, é salvo a cor inicial (antiga).
           2- Com base na cor inicial, é passado para PintarPilha() por meio de um parâmetro, que será utilizado para verificação.
           3- Ao chamar a função PintarPilha() é verificado se a cor da nova posição é igual a cor inicial.
           4- Caso a c
           Depois da primeira execução ficamos chamando a função novamente e passando como parâmetro a coordenada que
           puxarmos da pilha através do Pop()
           Isso acontecerá recursivamente até a pilha não ter mais coordenadas para executarem a função de PintarPilha()
    */
    public static void main(String[] args) {
        Matriz matrizPilha = new Matriz();
        System.out.println("Teste utilizando pilhas!");
        matrizPilha.PrintMatriz();
        matrizPilha.IniciarPintura(9, 9, 5, true);
        matrizPilha.PrintMatriz();

        Matriz matrizFila = new Matriz();
        System.out.println("Teste utilizando filas!");
        matrizFila.PrintMatriz();
        matrizFila.IniciarPintura(0, 0, 3, false);
        matrizFila.PrintMatriz();
    }
}