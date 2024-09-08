
public class Cajero {
    private int tiempoLibre;

    public Cajero() {
        this.tiempoLibre = 0;
    }

    public int getTiempoLibre() {   //tiempo de llegada
        return tiempoLibre;
    }

    public void setTiempoLibre(int tiempoLibre) {   //tiempo de salida 
        this.tiempoLibre = tiempoLibre;
    }
}
 

