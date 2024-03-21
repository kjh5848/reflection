package ex01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 세그먼트는 패킷스위칭을 하기 위해서 만든다.
 */
public class MyServer {

    public MyServer() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(10000);//리스너
            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = br.readLine();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            if (request.equals("get")) {
                bw.write("apple\n");
                bw.flush();
            } else if (request.equals("post")) {
                bw.write("good\n");
                bw.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        new MyServer();
    }
}
