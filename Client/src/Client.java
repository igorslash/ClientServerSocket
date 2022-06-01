import PhoneConnect.Phone;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Phone phone = new Phone("127.0.0.1", 8000);
        System.out.println(" connect to server ");
        String request = "Moscow";
        System.out.println("request " + request);
        phone.write(request);
        String response = phone.readLine();
        System.out.println("Response " + response);
    }
}
