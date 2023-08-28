public class Pilha<T> {
    public int top;
    private int size;
    private T[] pilhaArray;

    public Pilha(int size) {
        this.top = -1;
        this.size = size;
        this.pilhaArray = (T[]) new Object[size];
    }

    public T Pop() {
        if (IsEmpty()) {
            throw new IllegalStateException("Pilha vazia!");
        }
        T elementoRemovido = this.pilhaArray[top];
        this.pilhaArray[top] = null;
        this.top -= 1;
        return elementoRemovido;
    }

    public void Push(T obj) {
        if(IsFull()){
            System.out.println("Tamanho: " + this.top);
            throw new IllegalStateException("Pilha Cheia!");
        }
        this.top += 1;
        this.pilhaArray[top] = obj;
    }

    public boolean IsFull() {
        return this.top + 1 == size;
    }

    public boolean IsEmpty() {
        return this.top == -1;
    }

    public void Clear() {
        this.pilhaArray = (T[]) new Object[this.size];
        this.top = -1;
    }

    public void PrintElements() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.pilhaArray[i] + " | ");
        }
        System.out.println();
    }
}