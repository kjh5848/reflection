package ex01;

import java.io.*;
import java.net.Socket;

public class MyClient {

    public MyClient(){
        try {
            Socket socket = new Socket("localhost", 10000);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("get\n");
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = br.readLine();
            System.out.println("response = " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MyClient();
    }
}
