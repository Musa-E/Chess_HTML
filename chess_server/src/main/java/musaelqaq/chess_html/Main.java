package musaelqaq.chess_html;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nInitializing Chess Server...");
        Server server = new Server(5000); // default port: 5000
        server.start();
    }
}