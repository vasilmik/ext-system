package edu.javacourse.net;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(25225);
        Map<String,Greetable> handler = loadHandlers();

        System.out.println("Server start!");

        while (true) {

            Socket client = serverSocket.accept(); // accepting a new client
            new SimpleServer(client,handler).start();

        }
    }

    private static Map<String, Greetable> loadHandlers() {

        Map<String, Greetable> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader().
                getResourceAsStream("server.properties")) {

            Properties properties = new Properties();
            properties.load(is);

            for (Object command : properties.keySet()) {

                String className = properties.getProperty(command.toString());
                Class<Greetable> cl = (Class<Greetable>) Class.forName(className);
                Greetable handler = cl.getConstructor().newInstance();
                result.put(command.toString(), handler);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}

class SimpleServer extends Thread{

    private Socket client;
    private  Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handler) {
        this.client = client;
        this.handlers = handler;
    }

    public void run() {
        handleRequest();
    }

    private void handleRequest(){

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {

            String request = br.readLine();
            String [] lines = request.split("\\s+");

            String command = lines[0];
            String userName = lines[1];
            System.out.println("Server got command: " + command);
            System.out.println("Server got userName: " + userName);

            String response = buildResponse(command,userName);
            
            bw.write(response + " " + Thread.currentThread().getName());
            bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildResponse(String command, String userName) {

        Greetable handler = handlers.get(command);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hello, "+userName;

    }

}