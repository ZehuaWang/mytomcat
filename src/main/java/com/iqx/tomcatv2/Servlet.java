package com.iqx.tomcatv2;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * The interface for server side servlet
 */
public interface Servlet {
    public void init();
    public void Service(InputStream is, OutputStream ops) throws Exception;
    public void destory();
}