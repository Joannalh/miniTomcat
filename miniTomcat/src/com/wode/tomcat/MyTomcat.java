package com.wode.tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装tomcat容器
 * Created by Administrator on 2018/11/6 0006.
 */
public class MyTomcat {
    private int port = 8080;
    private Map<String,String> servletMap = new HashMap<>();

    public MyTomcat(){

    }

    public MyTomcat(int port){
        this.port = port;
    }

    public void start(){
        initServletMap();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("start my tomcat....");
            while (true){
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                MyRequest request = new MyRequest(inputStream);

                OutputStream outputStream = socket.getOutputStream();
                MyResponse response = new MyResponse(outputStream);

                //分发
                dispatch(request,response);

                socket.close();

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void initServletMap(){
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList){
            servletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    private void dispatch(MyRequest request,MyResponse response){
        String clazz = servletMap.get(request.getUrl());
        //反射
        try{
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(request,response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
