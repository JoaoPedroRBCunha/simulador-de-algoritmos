package Algoritmos;

import Paginacao.Pagina;

import java.util.*;

public class Aging {
    public int getPageHitCounter() {
        return pageHitCounter;
    }

    public int getPageFaultCounter() {
        return pageFaultCounter;
    }

    private int pageFaultCounter;
    private int pageHitCounter;
    private int capacidade;
    private List<Pagina> memoria;

    public Aging(List<Integer> stringDeReferencia, int capacidade) {
        this.pageFaultCounter = 0;
        this.pageHitCounter = 0;
        this.capacidade = capacidade;
        this.memoria = new ArrayList<>();
        simular(stringDeReferencia);
        printStats();
    }

    private void simular(List<Integer> listaDePaginas) {
        for (int pagina : listaDePaginas) {
            boolean acerto = false;
            for (Pagina p : memoria) {
                p.contador >>= 1;
                if (p.numero == pagina) {
                    p.contador |= 1 << 7;
                    acerto = true;
                    pageHitCounter++;
                }
            }

            if (!acerto) {
                pageFaultCounter++;
                if (memoria.size() < capacidade) {
                    Pagina novaPagina = new Pagina(pagina);
                    novaPagina.contador |= 1 << 7;
                    memoria.add(novaPagina);
                } else {
                    Pagina vitima = Collections.min(memoria, Comparator.comparingInt(p -> p.contador));
                    memoria.remove(vitima);
                    Pagina novaPagina = new Pagina(pagina);
                    novaPagina.contador |= 1 << 7;
                    memoria.add(novaPagina);
                }
            }
        }
    }

    public void printStats() {
        System.out.println("ALGORITMO AGING");
        System.out.printf("Falhas de página: %d\n", pageFaultCounter);
        System.out.printf("Acessos de página: %d\n", pageHitCounter);
        System.out.printf("Taxa de acesso: %.2f%%\n", getPageHitRate());
        System.out.printf("Taxa de falhas de página: %.2f%%\n", getPageFaultRate());
        System.out.println("=".repeat(50));
    }

    private float getPageHitRate() {
        int total = pageHitCounter + pageFaultCounter;
        return total == 0 ? 0 : (float) pageHitCounter / total * 100;
    }

    private float getPageFaultRate() {
        int total = pageHitCounter + pageFaultCounter;
        return total == 0 ? 0 : (float) pageFaultCounter / total * 100;
    }
}
