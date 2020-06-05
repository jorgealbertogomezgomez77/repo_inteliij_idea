
import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ClienteHandler implements Runnable{
    private Socket client;

    public ClienteHandler(Socket cliente) {
        this.client = cliente;
    }

    public void enviarMensaje() throws IOException {
        System.out.println("Envía un mensaje al cliente.");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        escritor.write(cadena);
        escritor.newLine();
        escritor.flush();
        System.out.println("Mensaje enviado al cliente.");
    }

    public void recibirMensaje() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String cadena = lector.readLine();
        System.out.println(cadena);
        if (cadena.compareTo("hora") == 0) {
            this.darHora();
        }
        System.out.println("Mensaje ha llegado");
    }

    public void darHora() throws IOException {
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        escritor.write(d.toString());
        escritor.newLine();
        escritor.flush();
    }

    @Override
    public void run() {
        try {
            recibirMensaje();
            enviarMensaje();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
