public class Fila<T> {
    private int top;
    private int base;
    private int size;
    private T[] filaArray;

    public Fila(int size) {
        this.top = 0;
        this.base = -1;
        this.size = size;
        this.filaArray = (T[]) new Object[size];
    }

    /* Ao adicionar algo na fila, o tamanho da fila aumentará, portanto, a base(ultimo elemento) ficará 1 espaço mais longe do topo(primeiro elemento) */
    public void Add(T obj) {
        if (IsFull()) {
            throw new IllegalStateException("Fila cheia!");
        }
        this.base += 1;
        this.filaArray[base] = obj;
    }

    /* Ao remover algo da fila, o tamanho diminuirá, portanto os elementos devem ocupar uma posição para frente, assim, liberando o utiltimo espaço. */
    public T Remove(){
        if(IsEmpty()){
            throw new IllegalStateException("Fila vazia!");
        }
        T elementoRemovido = this.filaArray[this.top];
        this.filaArray[this.top] = null; // Primeiro elemento da fila saiu

        for(int i = 0; i < this.size-1; i++){ // Os elementos são passados 1 posição para frente
            this.filaArray[i] = this.filaArray[i + 1];
        }

        this.filaArray[this.size-1] = null; // A útlima posição fica disponível
        this.base -= 1; // "Tamanho" da fila diminui
        return elementoRemovido;
    }

    public boolean IsFull() {
        return this.base + 1 == size;
    }

    public boolean IsEmpty() {
        return this.base == -1;
    }

    public void PrintElements() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.filaArray[i] + " | ");
        }
        System.out.println();
    }
}
