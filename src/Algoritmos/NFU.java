package Algoritmos;

import java.util.*;

public class NFU {
    public int getPageFaultCounter() {
        return pageFaultCounter;
    }

    public int getPageHitCounter() {
        return pageHitCounter;
    }

    private int pageFaultCounter;
    private int pageHitCounter;
    private int capacidade;
    private Map<Integer, Integer> tabelaFrequencia;
    private Set<Integer> memoria;

    public NFU(List<Integer> stringDeReferencia, int capacidade) {
        this.pageFaultCounter = 0;
        this.pageHitCounter = 0;
        this.capacidade = capacidade;
        this.tabelaFrequencia = new HashMap<>();
        this.memoria = new LinkedHashSet<>();
        simular(stringDeReferencia);
        printStats();
    }

    private void simular(List<Integer> listaDePaginas) {
        for (int pagina : listaDePaginas) {
            if (memoria.contains(pagina)) {
                pageHitCounter++;
                tabelaFrequencia.put(pagina, tabelaFrequencia.get(pagina) + 1);
            } else {
                pageFaultCounter++;
                if (memoria.size() == capacidade) {
                    int vitima = encontrarMenosFrequente();
                    memoria.remove(vitima);
                    tabelaFrequencia.remove(vitima);
                }
                memoria.add(pagina);
                tabelaFrequencia.put(pagina, 1);
            }
        }
    }

    private int encontrarMenosFrequente() {
        return memoria.stream()
                .min(Comparator.comparingInt(tabelaFrequencia::get))
                .orElseThrow();
    }

    public void printStats() {
        System.out.println("ALGORITMO NFU");
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
