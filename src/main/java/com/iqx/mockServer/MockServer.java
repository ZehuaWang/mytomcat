package com.iqx.mockServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple server side application to respond the client request
 * @author Eric
 */
public class MockServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream ops = null;
        try{
            serverSocket = new ServerSocket(8080);

            while (true) {
                socket = serverSocket.accept();

                ops = socket.getOutputStream();

                ops.write("HTTP/1.1 200 OK\n".getBytes());

                ops.write("Content-Type:text/html;charset=urf-8\n".getBytes());

                ops.write("Server:Apache-Coyote/1.1\n".getBytes());

                ops.write("\n\n".getBytes());

                StringBuffer sb = new StringBuffer();

                sb.append("<html>");

                sb.append("<head><title>Title</title></head>");

                sb.append("</html>");

                ops.write(sb.toString().getBytes());

                ops.flush();
            }

        } catch (Exception e) {



        } finally {

            if(null != ops)
                ops.close();

            if(null != socket)
                socket.close();

        }

    }

}
