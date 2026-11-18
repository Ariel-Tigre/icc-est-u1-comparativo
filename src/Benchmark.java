
public class Benchmark {
    public static  Results medir(Runnable accion, String nombre,String sample){
        //tiempo acutual
        //accion
        //tiempo final
        //retornar el tiempo de duracion
        System.out.println("funcion:" + nombre);
        long tiempoActual = System.nanoTime();
        accion.run();
        Long tiempoFinal = System.nanoTime();

        Results results = new Results(nombre,( tiempoFinal-tiempoActual),"sample");
        return  results;

    }
}
