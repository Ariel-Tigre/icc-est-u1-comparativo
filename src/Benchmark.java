public class Benchmark {

    public static Results medir(Runnable accion, String nombre, String sample) {
        if (accion == null) {
            throw new IllegalArgumentException("La operación a medir no puede ser null.");
        }

        long tiempoInicial = System.nanoTime();
        accion.run();
        long tiempoFinal = System.nanoTime();

        long duracionNs = tiempoFinal - tiempoInicial;
        return new Results(nombre, duracionNs, sample);
    }
}