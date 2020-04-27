package com.myheart.network.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yangxin
 * @date 2019/8/14
 */
public class OneRequestClient {

    private static final String URL = "http://localhost:8080";

    private static final String CONTROLLER_PATH = "/test";

    private static final String METHOD_PATH = "/testTestService";

    public static void main(String[] args) {
//        try {
//            URL imooc = new URL(URL);
//            URL url=new URL(imooc,CONTROLLER_PATH+METHOD_PATH);
//            InputStream is=url.openStream();
//            byte[] result = new byte[7];
//            is.read(result);
//            System.out.println(new String(result));
////                            InputStream iss=imooc.openStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        for (int i = 0; i < 100; i++){
//            final int id = i;
//            Thread thread = new Thread(new Runnable() {
//                private String name = "thread-"+id;
//                @Override
//                public void run() {
//                    for (int i = 10; i<10; i++){
//                        try {
//                            URL imooc = new URL(URL);
//                            URL url=new URL(imooc,CONTROLLER_PATH+METHOD_PATH+"?id="+id+"-"+i);
//                            long start = System.currentTimeMillis();
//                            InputStream is=url.openStream();
//                            System.out.println(name+": "+(System.currentTimeMillis()-start)+"ms");
//                            byte[] result = new byte[7];
//                            is.read(result);
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            });
//            thread.start();
//        }



        try {
            URL imooc = new URL(URL);
            URL url=new URL(imooc,CONTROLLER_PATH+METHOD_PATH);
            for (int i = 0;i<10;i++){
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.getOutputStream().write("id=1".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
