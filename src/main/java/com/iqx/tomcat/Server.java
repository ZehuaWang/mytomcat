package com.iqx.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Define a variable to store the absolute path of web content.
    public static String WEB_ROOT = System.getProperty("user.dir")+"\\"+"resources";

    private static String url = "";

    public static void main(String[] args) throws Exception {
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
                sendStaticResource(ops);
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
    private static void parse(InputStream is) throws Exception {

        StringBuffer content = new StringBuffer(2048);
        byte[] buffer = new byte[2048];
        int i = -1;
        i=is.read(buffer);
        for(int j=0; j<i; j++) {
            content.append((char)buffer[j]);
        }

        System.out.println(content);

        parseUrl(content.toString());
    }

    /**
     * Send the static resource
     */
    private static void sendStaticResource(OutputStream ops) throws IOException {

        byte[] bytes = new byte[2048];
        FileInputStream fis = null;

        try {

            File file = new File(WEB_ROOT,url);

            System.out.print(WEB_ROOT);
            System.out.print(url);

            if(file.exists()) {

                ops.write("HTTP/1.1 200 OK\n".getBytes());
                ops.write("Server:apache-Coyote/1.1\n".getBytes());
                ops.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                ops.write("\n".getBytes());

                fis = new FileInputStream(file);

                int ch = fis.read(bytes);

                while (ch!=-1) {
                    ops.write(bytes,0,ch);
                }

            } else {

                ops.write("HTTP/1.1 404 not found\n".getBytes());
                ops.write("Server:apache-Coyote/1.1\n".getBytes());
                ops.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                ops.write("\n".getBytes());

                String errorMessage = "file not found";
                ops.write(errorMessage.getBytes());
            }

        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            if(null!=fis) {
                fis.close();
                fis = null;
            }
        }

    }

    /**
     * Get the resource name
     */
    private static void parseUrl(String content) {
        int index1,index2;
        index1 = content.indexOf(" ");
        if(index1 != -1) {
            index2 = content.indexOf(" ",index1+1);
            if(index2 > index1) {

                url = content.substring(index1+2, index2);
            }
        }

        System.out.println(url);
    }
}