package PhoneConnect;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone implements Closeable{

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    public Phone(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.bufferedReader = createReader();
        this.bufferedWriter = createWriter();
    }
    public Phone(ServerSocket server) throws IOException {
        this.socket = server.accept();
        this.bufferedReader = createReader();
        this.bufferedWriter = createWriter();
    }
    public void write(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
