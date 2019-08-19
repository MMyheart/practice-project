package com.myheart.network.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author yangxin
 * @date 2019/8/14
 */
public class OneRequestClient {

    private static final String URL = "http://localhost:8080";

    private static final String CONTROLLER_PATH = "/test";

    private static final String METHOD_PATH = "/testTestService";

    public static void main(String[] args) {
        try {
            URL imooc = new URL(URL);
            URL url=new URL(imooc,CONTROLLER_PATH+METHOD_PATH);
            InputStream is=url.openStream();
//                            InputStream iss=imooc.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
