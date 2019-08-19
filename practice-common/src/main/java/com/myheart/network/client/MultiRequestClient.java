package com.myheart.network.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @author yangxin
 * @date 2019/8/14
 */
public class MultiRequestClient {

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        final SocketAddress socketAddress = new InetSocketAddress(address,8080);
        for (int i = 0; i < 150; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1; i++){
                        Socket socket = new Socket();
                        try {
                            socket.connect(socketAddress);
//                        DataInputStream input = new DataInputStream(socket.getInputStream());
//                        String ret = input.readUTF();
//                        System.out.println(Thread.currentThread().getName()+"-"+"    "+ret);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("准备发送结束");
        SocketAddress socketAddress1 = new InetSocketAddress(address,9998);
        Socket socket = new Socket();
        try {
            socket.connect(socketAddress1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("stop");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
