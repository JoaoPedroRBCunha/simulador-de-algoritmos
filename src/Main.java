import Algoritmos.Aging;
import Algoritmos.FIFO;
import Algoritmos.LRU;
import Algoritmos.NFU;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simulador de algoritmos de substituição de páginas");

        System.out.println("Informe o tamanho da memória (capacidade de frames):");
        int capacity = scanner.nextInt();

        System.out.println("Informe o tamanho da string de referência:");
        int refSize = scanner.nextInt();

        List<Integer> ref = new ArrayList<>();

        System.out.println("Informe se deseja fazer inserção aleatória na string de referência? (S/N):");
        char insertOption = scanner.next().charAt(0);

        if (insertOption == 'S' || insertOption == 's') {
            for (int i = 0; i < refSize; i++) {
                ref.add((int) (Math.random() * 100));
            }
        } else {
            for (int i = 0; i < refSize; i++) {
                System.out.print("Informe o valor da página para a posição " + (i + 1) + "˚ (número inteiro): ");
                int page = scanner.nextInt();
                ref.add(page);
            }
        }

        System.out.println("String de referência gerada: " + ref);
        System.out.println();
        FIFO fifoAlgorithm = new FIFO(ref, capacity);
        LRU lruAlgorithm = new LRU(ref, capacity);
        NFU nfuAlgorithm = new NFU(ref, capacity);
        Aging agingAlgorithm = new Aging(ref, capacity);
    }
}