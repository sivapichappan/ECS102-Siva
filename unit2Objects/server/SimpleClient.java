package unit2Objects.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;

    public SimpleClient(String ip, int port) throws Exception {
        socket = new Socket(ip, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new Scanner(socket.getInputStream());
    }

    public String receiveMessage() {
        return in.nextLine();
    }

    public void sendMessage(String msg) {
        out.println(msg);
        out.flush();
    }

    public void close() throws Exception {
        socket.close();
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        SimpleClient smc = new SimpleClient("127.0.0.1", 9090);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Message");
        while (true) {
            String message = input.nextLine();
            smc.sendMessage(message);
            String response = smc.receiveMessage();
            System.out.println("Server:" + response);
            if (response.equals("stop")) {
                break;
            }
        }
        smc.close();
    }

}