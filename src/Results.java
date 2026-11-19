import java.util.Locale;

public class Results {
    private String functionName;
    private long duracion; // en nanosegundos
    private String sample;

    public Results(String functionName, long duracion, String sample) {
        this.functionName = functionName;
        this.duracion = duracion;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public double getDuracionMs() {
        return duracion / 1_000_000.0;
    }

@Override
public String toString() {
    double segundos = duracion / 1_000_000_000.0;
    double milisegundos = duracion / 1_000_000.0;
    return String.format(java.util.Locale.US,
            "Results [%s, duration=%dns, %.6fs, %.4fms, sample=%s]",
            functionName, duracion, segundos, milisegundos, sample);
}
}