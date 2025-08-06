package musaelqaq.chess_html;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int portNum = 0;
    private ServerSocket serverSocket;
    private boolean isRunning = false;

    // Initializes the server using the port number given
    public Server(int port) {
        portNum = port;
    }

    // Starts the game server
    public void start() {
        try {
            serverSocket = new ServerSocket(portNum);
            isRunning = true;
            System.out.println("Server started on port " + portNum);

            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(coloredTerminal.YELLOW + "Client has joined the server." + coloredTerminal.RESET);

                // Create a thread to handle the client
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }

        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        } finally {
            stop();
        }
    }

    // Stops the game server
    public void stop() {
        isRunning = false;
        try {
            if (serverSocket != null)
                serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace(); // System.err.println() ?
        }
    }
}
