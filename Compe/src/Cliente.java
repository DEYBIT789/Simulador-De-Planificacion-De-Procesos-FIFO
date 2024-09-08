
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Cliente {
    private int tiempoLlegada;
    private int tiempoServicio;

    public Cliente(int tiempoLlegada, int tiempoServicio) {
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoServicio = tiempoServicio;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }
}

