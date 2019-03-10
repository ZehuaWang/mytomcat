package com.iqx.tomcatv2;

import java.io.InputStream;
import java.io.OutputStream;

public class AAServlet implements Servlet {
    public void init() {
        System.out.println("aaServlet...init");
    }

    public void Service(InputStream is, OutputStream ops) throws Exception {
        System.out.println("aaServlet...service");
        ops.write("I am from AAServlet".getBytes());
        ops.flush();
    }

    public void destory() {

    }
}
