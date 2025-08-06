package musaelqaq.chess_html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) {
        System.out.println("\nInitializing Chess Client...");

        // Connection info
        String ServerIP = "";
        int portNum = 5000;

        // System.out.println("\nServer port (default = 5000): ");
        // portNum = System.in;
        
        try {

            Socket socket = new Socket(ServerIP, portNum);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            
            String fromServer, fromUser;
            System.out.println("Connected to server. Type a message:");

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                System.out.print("> ");
                fromUser = stdIn.readLine();

                if (fromUser != null) {
                    out.println(fromUser);
                    if (fromUser.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }

    }
}