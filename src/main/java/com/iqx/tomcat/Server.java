package com.iqx.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Define a variable to store the absolute path of web content.
    public static String WEB_ROOT = System.getProperty("user.dir")+"\\"+"resources";

    private String url = "";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket  = null;
        InputStream is = null;
        OutputStream ops = null;

        try {
            serverSocket = new ServerSocket(8080);

            while (true) {
                socket = serverSocket.accept();
                is  = socket.getInputStream();
                ops = socket.getOutputStream();
                parse(is);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != is) {
                is.close();
                is = null;
            }

            if(null != ops) {
                ops.close();
                ops = null;
            }

            if(null != socket) {
                socket.close();
                socket = null;
            }
        }
    }

    /**
     * Get the resource name from input stream
     */
    private static void parse(InputStream is) {


    }

    /**
     * Send the static resource
     */
    private static void sendStaticResource(OutputStream ops) {

    }
}