import PhoneConnect.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8000);
            System.out.println("Server start");
            System.out.println("Client connect");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String req = null;
                    try {
                        req = phone.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Request" + req);
                    assert req != null;
                    String response = "Hello server" + req.length();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        phone.write(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
               // server.close();
            }
    }
}
