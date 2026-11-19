import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int[] tamanios = {10_000, 50_000, 100_000};
        Metodos metodos = new Metodos();
        Comparator<Integer> comparadorAsc = Integer::compare;
        List<Results> listaResultados = new ArrayList<>();

        for (int n : tamanios) {
            // 1. Generar una sola muestra base por tamaño (fuera del cronómetro)
            int[] base = Generador.generate(n);
            Integer[] baseInteger = convertirAInteger(base);
            String sampleStr = String.valueOf(n);

            // V1: Método básico (Burbuja)
            int[] copiaV1 = base.clone();
            Results r1 = Benchmark.medir(() -> metodos.sortBubble(copiaV1), "V1 - Burbuja", sampleStr);
            validarOrdenado(copiaV1, n, "V1 - Burbuja");
            listaResultados.add(r1);

            // V2: Método investigado (Quick Sort)
            int[] copiaV2 = base.clone();
            Results r2 = Benchmark.medir(() -> metodos.sortQuick(copiaV2), "V2 - QuickSort", sampleStr);
            validarOrdenado(copiaV2, n, "V2 - QuickSort");
            listaResultados.add(r2);

            // V3: Arrays.sort con int[]
            int[] copiaV3 = base.clone();
            Results r3 = Benchmark.medir(() -> metodos.sortArrays(copiaV3), "V3 - Arrays.sort(int[])", sampleStr);
            validarOrdenado(copiaV3, n, "V3 - Arrays.sort(int[])");
            listaResultados.add(r3);

            // V4: Arrays.sort con Integer[] y Comparator
            Integer[] copiaV4 = baseInteger.clone();
            Results r4 = Benchmark.medir(() -> metodos.sortComparator(copiaV4, comparadorAsc), "V4 - Arrays.sort(Comparator)", sampleStr);
            validarOrdenadoInteger(copiaV4, n, "V4 - Arrays.sort(Comparator)");
            listaResultados.add(r4);
        }

        // Imprimir la lista completa únicamente al finalizar las 12 mediciones
        System.out.println("\n=== RESULTADOS COMPLETOS (12 MEDICIONES) ===");
        for (Results r : listaResultados) {
            System.out.println(r);
        }
    }

    private static Integer[] convertirAInteger(int[] origen) {
        Integer[] destino = new Integer[origen.length];
        for (int i = 0; i < origen.length; i++) {
            destino[i] = origen[i];
        }
        return destino;
    }

    private static void validarOrdenado(int[] arr, int esperado, String metodo) {
        if (arr.length != esperado) {
            throw new IllegalStateException("Tamaño incorrecto en " + metodo);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalStateException("Arreglo no ordenado en " + metodo);
            }
        }
    }

    private static void validarOrdenadoInteger(Integer[] arr, int esperado, String metodo) {
        if (arr.length != esperado) {
            throw new IllegalStateException("Tamaño incorrecto en " + metodo);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalStateException("Arreglo no ordenado en " + metodo);
            }
        }
    }
}