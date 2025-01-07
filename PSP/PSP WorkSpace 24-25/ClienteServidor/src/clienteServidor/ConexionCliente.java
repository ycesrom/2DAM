package clienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConexionCliente  {
	public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost",12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String msg;
            while ((msg = console.readLine()) != null) {
                out.println(msg);
                System.out.println(in.readLine());
                if (msg.equalsIgnoreCase("bye")) break;
            }
        }
    }
}
