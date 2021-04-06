package edu.javacourse.net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
       for (int i = 0;i<10;i++) {
           new SimpleClient(i).start();
       }
    }
}

class SimpleClient extends Thread{

    private final static String[] COMMAND = {
            "HELLO","MORNING","DAY","EVENING"
    };

    private int cmdNumber;

    public SimpleClient(int cmdNumber){
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run(){

        System.out.println("Client started! "+Thread.currentThread().getName());

        try (
                Socket socket = new Socket("127.0.0.1", 25225);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {

            String command = COMMAND[cmdNumber % COMMAND.length];

            bw.write(command+" "+"Michael");
            bw.newLine();
            bw.flush();
            System.out.println(br.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
