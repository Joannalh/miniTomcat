package com.wode.tomcat;

import java.io.IOException;

/**
 * 实际的servlet对象
 * Created by Administrator on 2018/11/6 0006.
 */
public class HelloWorldServlet extends MyServlet {

    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("GET  helloWorld");
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("POST  helloWorld");
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}
