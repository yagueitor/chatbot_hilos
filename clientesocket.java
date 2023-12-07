package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientesocket {

    public static void main(String[] args) {
        String host = "localhost"; // Cambia esto si el servidor está en otra máquina
        int puerto = 15001;

        try {
            // Conectarse al servidor
            Socket socket = new Socket(host, puerto);
            // Configurar streams de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Leer mensajes de bienvenida y menú del servidor
            String inputLine;
            String saludo = entrada.readLine();
            System.out.println(saludo);
            
            while ((inputLine = entrada.readLine()) != null) {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                    	 String pregunta1 = entrada.readLine();
                         String pregunta2 = entrada.readLine();
                         String pregunta3 = entrada.readLine();
                         String pregunta4 = entrada.readLine();
                         String pregunta5 = entrada.readLine();
                         System.out.println(pregunta1);
                         System.out.println(pregunta2);
                         System.out.println(pregunta3);
                         System.out.println(pregunta4);
                         System.out.println(pregunta5);

                        // El usuario ingresa la opción
                        String response = scanner.nextLine();
                        salida.println(response);
                        inputLine = entrada.readLine();
                        System.out.println(inputLine);

                        if (response.equals("fin")) {
                            break;
                        }
                    }
                    break;
                }
            // Cerrar recursos
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
