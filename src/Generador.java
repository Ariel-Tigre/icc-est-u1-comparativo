import java.util.concurrent.ThreadLocalRandom;

public class Generador {

    // Genera un arreglo de tamaño 'size' con enteros aleatorios entre 0 y 'size' (ambos inclusive)
    public static int[] generate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("El tamaño no puede ser negativo: " + size);
        }

        if (size == 0) {
            return new int[0];
        }

        if (size == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Tamaño demasiado grande para calcular el límite superior sin desbordamiento.");
        }

        int[] arreglo = new int[size];
        long limiteSuperiorExclusivo = (long) size + 1L;

        for (int i = 0; i < size; i++) {
            arreglo[i] = (int) ThreadLocalRandom.current().nextLong(0L, limiteSuperiorExclusivo);
        }

        return arreglo;
    }
}