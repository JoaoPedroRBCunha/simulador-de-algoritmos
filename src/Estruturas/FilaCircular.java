package Estruturas;

public class FilaCircular {
    private int[] fila;
    private int frente, atras, tamanho, capacidade;

    public FilaCircular(int capacidade) {
        this.fila = new int[capacidade];
        this.frente = 0;
        this.atras = capacidade - 1;
        this.capacidade = capacidade;
    }

    public boolean Cheio(){
        return this.tamanho == this.capacidade;
    }

    public boolean Vazio(){
        return this.tamanho == 0;
    }

    public void enqueue(int item){
        if(Cheio()){
            throw new FilaCircularExcecao("A lista está cheia");
        }
        this.atras = (this.atras + 1) % this.capacidade;
        this.fila[atras] = item;
        this.tamanho++;
    }

    public int dequeue(){
        if(Vazio()){
            throw new FilaCircularExcecao("A lista está vazia");
        }
        int item = this.fila[this.frente];
        frente = (frente + 1) % this.capacidade;
        tamanho--;
        return item;
    }

    public int peek(){
        if(Vazio()){
            throw new FilaCircularExcecao("Não há valores pois a lista está vazia");
        }
        return fila[frente];
    }

    public boolean isInQueue(int item) {
        if (Vazio()) return false;

        int contador = 0;
        int index = frente;

        while (contador < tamanho) {
            if (fila[index] == item) {
                return true;
            }
            index = (index + 1) % capacidade;
            contador++;
        }

        return false;
    }

    public int ProcuraItemAbsolutoIndex(int index){
        return this.fila[index];
    }
}