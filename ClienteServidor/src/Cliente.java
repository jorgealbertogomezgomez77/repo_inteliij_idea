
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private String hostname;
    private int porto;
    Socket clientSocket;

    public Cliente(String host, int porto) {
        this.hostname = host;
        this.porto = porto;
    }

    public void conectar() throws IOException {
        clientSocket = new Socket(hostname, porto);
        System.out.println("Intentando conectar al servidor " + clientSocket.getInetAddress().getHostName());
        System.out.println("Conexión realizada con " + clientSocket.getInetAddress().getHostName());
    }

    public static void main(String[] args) throws IOException {
        Cliente client = new Cliente("localhost", 2081);
        client.conectar();
        while (true) {
            client.enviarMensaje();
            client.recibirMensaje();
        }
    }

    public void enviarMensaje() throws IOException {
        System.out.println("Escribe un mensaje para el servidor");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        escritor.write(cadena);
        escritor.newLine();
        escritor.flush();
        System.out.println("Mensaje enviado al servidor.");
    }

    public void recibirMensaje() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String cadena = lector.readLine();
        System.out.println(cadena);
        System.out.println("Mensaje ha llegado");
    }
}
