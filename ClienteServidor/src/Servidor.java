
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocket;
    int port;

    public Servidor(int porto) {
        port = porto;
    }

    public void start() throws IOException { // Inicializa el servidor.
        serverSocket = new ServerSocket(port);
        System.out.println("Servidor ejecutandose en la maquina "
                + serverSocket.getInetAddress().getHostName() + " en el puerto " + port);

        Socket cliente = null;
        while (true) { // Bucle infinito para atender peticiones de clientes.
            System.out.println("Listo para recivir conexiones.");
            cliente = serverSocket.accept();
            System.out.println("Acaba de entrar un cliente " + cliente.getInetAddress().getCanonicalHostName());
            Thread t = new Thread(new ClienteHandler(cliente));
            t.start();
        } // Fin del bucle.
    } // Fin del método start.

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor(2081);
        server.start();
    }
}
