package Algoritmos;

import Paginacao.Pagina;
import java.util.*;

public class LRU {
    private int pageFaultCounter;
    private int pageHitCounter;
    private int capacidade;
    private List<Pagina> memoriaPrincipal;
    private int ponteiroRelogio;

    public LRU(List<Integer> stringDeReferencia, int capacidade) {
        this.pageFaultCounter = 0;
        this.pageHitCounter = 0;
        this.capacidade = capacidade;
        this.memoriaPrincipal = new ArrayList<>(capacidade);
        this.ponteiroRelogio = 0;
        simular(stringDeReferencia);
        printStats();
    }

    private void simular(List<Integer> listaDePaginas) {
        for (int numeroPagina : listaDePaginas) {
            Pagina pagina = encontrarPagina(numeroPagina);

            if (pagina != null) {
                pageHitCounter++;
                pagina.contador = 1;
            } else {
                pageFaultCounter++;
                if (memoriaPrincipal.size() < capacidade) {
                    memoriaPrincipal.add(new Pagina(numeroPagina));
                    memoriaPrincipal.get(memoriaPrincipal.size() - 1).contador = 1;
                } else {
                    substituirPagina(numeroPagina);
                }
            }
        }
    }

    private Pagina encontrarPagina(int numeroPagina) {
        for (Pagina pagina : memoriaPrincipal) {
            if (pagina.numero == numeroPagina) {
                return pagina;
            }
        }
        return null;
    }

    private void substituirPagina(int novoNumeroPagina) {
        while (true) {
            Pagina atual = memoriaPrincipal.get(ponteiroRelogio);

            if (atual.contador == 0) {
                atual.numero = novoNumeroPagina;
                atual.contador = 1;
                ponteiroRelogio = (ponteiroRelogio + 1) % capacidade;
                return;
            } else {
                atual.contador = 0;
                ponteiroRelogio = (ponteiroRelogio + 1) % capacidade;
            }
        }
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

    public void printStats() {
        System.out.println("ALGORITMO LRU COM BIT DE REFERÊNCIA");
        System.out.printf("Falhas de página: %d\n", pageFaultCounter);
        System.out.printf("Acessos de página: %d\n", pageHitCounter);
        System.out.printf("Taxa de acesso: %.2f%%\n", getPageHitRate());
        System.out.printf("Taxa de falhas de página: %.2f%%\n", getPageFaultRate());
        System.out.println("=".repeat(50));
    }
}
