import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Servidor esperando...");

        Socket socket = servidor.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Cliente: " + msg);
            out.println("Recebi: " + msg); // resposta simples
            if (msg.equalsIgnoreCase("sair")) break;
        }

        socket.close();
        servidor.close();
    }
}
