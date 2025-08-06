package musaelqaq.chess_html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // System.out.println("New Thread Created!");

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to Chess Server!");

            String input;

            while ((input = in.readLine()) != null) {

                System.out.println("Client: " + input);

                out.println(input);

                // Exits the loop
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println(coloredTerminal.YELLOW  + "Client has left the server." + coloredTerminal.RESET);
                    break;
                }
            }

        // Handle issues with creating a new thread/handling user input
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());

        } finally {

            try {
                socket.close();
            } catch (IOException f) {
                System.err.println("An error occured while trying to close the socket: " + f.getMessage());
            }
        }
    }
}
