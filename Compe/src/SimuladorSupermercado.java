
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class SimuladorSupermercado {
    public static void main(String[] args) {
        Queue<Cliente> cola = new LinkedList<>();
        Random random = new Random();
        int numClientes = 10; // Número de clientes
        int numCajeros = 3;   // Número de cajeros

        // Generar clientes
        for (int i = 0; i < numClientes; i++) {
            int tiempoLlegada = random.nextInt(10); // entre 0 y 9
            int tiempoServicio = random.nextInt(5) + 1; // entre 1 y 5 minutos
            cola.add(new Cliente(tiempoLlegada, tiempoServicio));
        }

        Cajero[] cajeros = new Cajero[numCajeros];
        for (int i = 0; i < numCajeros; i++) {
            cajeros[i] = new Cajero();
        }

        int tiempoActual = 0;
        int tiempoTotalEspera = 0;
        int clientesAtendidos = 0;

        // Simulación
        while (!cola.isEmpty()) {
            Cliente cliente = cola.poll();
            Cajero cajeroLibre = encontrarPrimerCajeroLibre(cajeros);

            if (cajeroLibre != null) {
                tiempoActual = Math.max(tiempoActual, cliente.getTiempoLlegada());
                int tiempoEspera = tiempoActual - cliente.getTiempoLlegada();
                tiempoTotalEspera += tiempoEspera;
                clientesAtendidos++;
                System.out.println("Cliente atendido por cajero " + (indiceCajero(cajeros, cajeroLibre) + 1) +
                        ": Tiempo de espera = " + tiempoEspera + " minutos, Tiempo de servicio = " + cliente.getTiempoServicio() + " minutos");
                cajeroLibre.setTiempoLibre(tiempoActual + cliente.getTiempoServicio());
                tiempoActual += cliente.getTiempoServicio();
            }
        }

        // Resultados finales
        double tiempoPromedioEspera = (double) tiempoTotalEspera / clientesAtendidos;
        System.out.println("Tiempo total de espera: " + tiempoTotalEspera + " minutos");
        System.out.println("Tiempo promedio de espera: " + tiempoPromedioEspera + " minutos");
    }

    // Encontrar el primer cajero libre, respetando el FIFO
    private static Cajero encontrarPrimerCajeroLibre(Cajero[] cajeros) {
        Cajero cajeroLibre = null;
        for (Cajero cajero : cajeros) {
            if (cajeroLibre == null || cajero.getTiempoLibre() < cajeroLibre.getTiempoLibre()) {
                cajeroLibre = cajero;
            }
        }
        return cajeroLibre;
    }

    // Obtener el índice del cajero en el arreglo de cajeros
    private static int indiceCajero(Cajero[] cajeros, Cajero cajero) {
        for (int i = 0; i < cajeros.length; i++) {
            if (cajeros[i] == cajero) {
                return i;
            }
        }
        return -1;
    }
}
