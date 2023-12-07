package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorsocket implements Runnable {

	private Socket clientSocket;
	public servidorsocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
		
	}
	
    public static void main(String[] args) {
        int puerto = 15001;

        try {
            // Crear el socket del servidor
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("ChatBot esperando conexiones en el puerto " + puerto);
            int i = 0;
            while (true) {
	            // Esperar a que llegue una conexión de un cliente
	            Socket clientSocket2 = serverSocket.accept();
	            System.out.println("Se ha conectado un cliente desde " + clientSocket2.getInetAddress().getHostAddress());
	            i++;
	            new Thread(new servidorsocket(clientSocket2),"Cliente " + i).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Configurar streams de entrada y salida para la conexión con el cliente
            PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            salida.println("Bienvenido al servidor, elige una opción (1-5)");
            salida.println("Elige una opción (1-5):");
            salida.println("1. Abrir caso de evolutivo.");
            salida.println("2. Abrir caso de correctivo.");
            salida.println("3. Abrir caso de pérdida de servicio.");
            salida.println("4. Cerrar caso.");
            salida.println("5. Hablar con un gestor.");
            String inputLine;

            while ((inputLine = entrada.readLine()) != null) {
                switch (inputLine) {
                    case "1":
                        salida.println("Has seleccionado la Opción 1. Abrir caso de evolutivo.");
                        break;
                    case "2":
                        salida.println("Has seleccionado la Opción 2. Abrir caso de correctivo.");
                        break;
                    case "3":
                        salida.println("Has seleccionado la Opción 3. Abrir caso de pérdida de servicio.");
                        break;
                    case "4":
                        salida.println("Has seleccionado la Opción 4. Cerrar caso.");
                        break;
                    case "5":
                        salida.println("Has seleccionado la Opción 5. Hablar con un gestor.");
                        break;
                    
                }

                if (inputLine.equals("fin")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}