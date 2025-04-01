package trio.distribuidos.proyectodistribuidos.Services;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorCentral {

    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ZContext context = new ZContext()) {
            Socket serverSocket = context.createSocket(ZMQ.REP);
            serverSocket.bind("tcp://*:5555");

            System.out.println("Servidor Central iniciado y esperando solicitudes...");

            while (!Thread.currentThread().isInterrupted()) {
                String request = serverSocket.recvStr(0);
                threadPool.submit(() -> procesarSolicitud(request, serverSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void procesarSolicitud(String solicitud, Socket serverSocket) {
        try {
            System.out.println("Solicitud recibida: " + solicitud);

            // Lógica para procesar la solicitud
            String respuesta = asignarEspacios(solicitud);

            // Enviar respuesta a la facultad
            serverSocket.send(respuesta);
        } catch (Exception e) {
            System.err.println("Error procesando la solicitud: " + e.getMessage());
        }
    }

    private static String asignarEspacios(String solicitud) {
        // Implementar lógica para asignar espacios, manejar aulas móviles y generar alertas
        // SE PUEDEN LLAMAR METODOS DE OTROS SERVICIOS COMO EL DE FACULTAD SI TOCA
        return "Asignación completada"; // Respuesta simulada
    }


    //PODRIAMOS CONSIDERAR OTRO SERVICIO QUE FUNCIONE COMO LOGICA DEL SERVICIO, INSTANCIANDO LOS MODELOS/REPOSITORIOS Y REALIZAR TODA LA LOGCA
    // DE ESA MANERA SOLO SE LLAMARIA AQUI LAS COSAS
}