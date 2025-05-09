package Algoritmos;

import Estruturas.FilaCircular;

import java.util.List;

public class FIFO {

    private int pageFaultCounter;
    private int pageHitCounter;
    public FilaCircular memoriaPrincipal;

    public FIFO(List<Integer> stringDeReferencia, int capacidade) {
        this.memoriaPrincipal = new FilaCircular(capacidade);
        this.pageFaultCounter = 0;
        this.pageHitCounter = 0;
        simular(stringDeReferencia);
        printStats();
    }

    public int getPageFaultCounter() {
        return this.pageFaultCounter;
    }

    public int getPageHitCounter() {
        return this.pageHitCounter;
    }

    public float getPageHitRate() {
        int total = this.pageHitCounter + this.pageFaultCounter;
        if (total == 0) return 0;
        return (float) this.pageHitCounter / total * 100;
    }

    public float getPageFaultRate() {
        int total = this.pageHitCounter + this.pageFaultCounter;
        if (total == 0) return 0;
        return (float) this.pageFaultCounter / total * 100;
    }

    private void simular(List<Integer> listaDePaginas) {
        for (int pagina : listaDePaginas) {
            if (!memoriaPrincipal.isInQueue(pagina)) {
                pageFaultCounter++;
                if (this.memoriaPrincipal.Cheio()) {
                    this.memoriaPrincipal.dequeue();
                }
                this.memoriaPrincipal.enqueue(pagina);
            } else {
                pageHitCounter++;
            }
        }
    }

    public void printStats() {
        System.out.println("ALGORITMO FIFO: ");
        System.out.printf("Falhas de página: %d\n", pageFaultCounter);
        System.out.printf("Acessos de página: %d\n", pageHitCounter);
        System.out.printf("Taxa de acesso: %.2f%%\n", getPageHitRate());
        System.out.printf("Taxa de falhas de página: %.2f%%\n", getPageFaultRate());
        System.out.println("=".repeat(50));
    }
}
