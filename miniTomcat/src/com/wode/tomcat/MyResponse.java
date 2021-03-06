package com.wode.tomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 封装响应对象
 * Created by lh on 2018/11/6 0006.
 */
public class MyResponse {
    private OutputStream outputStream;
    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public void write(String content) throws IOException{
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</html></body>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
