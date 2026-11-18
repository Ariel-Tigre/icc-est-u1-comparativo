import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

public class App {

    public static void main(String[] args) throws Exception {
    Generador g = new Generador();
    Benchmark b = new Benchmark();
    List<Integer>list = g.generate(100000);
    System.out.println(list);
    Results benGenList = b.medir(()-> g.generate(100000),"Gerneracion de listado","100");
    System.out.println(benGenList);

        /*  Long nanotime =System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Nano Time: " + nanotime);
        System.out.println("Current Time: " + currentTimeMillis);

        Runnable x = ()->{System.out.println("Ejecutando tarea1");
        System.out.println("ejecuccion de la tarea 2");
        System.out.println("Ejecucion de la funcion Runnable");
    };
    List<Integer> list = new ArrayList<>();
    MetodosOrd mO = new MetodosOrd();
    Runnable burbujaOrden = () -> mO.burbuja(list);
    ejecutarMasTarde();
    System.out.println("Ejecucion de la funcion Runnable");
        x.run();

    }
    public void ejecutarMasTarde(){
        List<Integer> list = new ArrayList<>();

    }*/
    }
}
