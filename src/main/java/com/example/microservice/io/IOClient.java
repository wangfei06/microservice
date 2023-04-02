package com.example.microservice.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * 普通IO模型
 * IO客户端
 * 测试方法：首先启动IOServer，然后启动IOClient,在server端每隔2s打印hello world
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
