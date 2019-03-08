package com.iqx.MockClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Eric
 * Use a java http client to request a web site and get the responce
 * Notice : Close all the resource to avoid memory leak
 */
public class MockClient {

    public static void main(String[] args) throws Exception {

        Socket socket    = null;
        InputStream is   = null;
        OutputStream ops = null;

        try {
            //Create a Socket Object
            socket = new Socket("www.itcast.cn",80);

            //Get the input stream
            is = socket.getInputStream();

            //Get the output stream
            ops = socket.getOutputStream();

            //Send the request to the server side
            ops.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
            ops.write("HOST:www.itcast.cn\n".getBytes());
            ops.write("\n".getBytes());

            //Read the respond to console
            int i = is.read();
            while (i!=-1) {
                System.out.print((char)i);
                i = is.read();
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
}
