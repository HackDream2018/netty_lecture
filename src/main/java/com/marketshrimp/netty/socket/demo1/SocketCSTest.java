package com.marketshrimp.netty.socket.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/15
 */
public class SocketCSTest {

    static class Client {
        public static void main(String[] args) throws Exception {
            Socket socket = new Socket("127.0.0.1", 8080);
            // 输入流
            Scanner inputScanner = new Scanner(socket.getInputStream());
            // 输出流
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                pw.println(scanner.nextLine());
                pw.flush();
                System.out.println("服务器响应内容: " + inputScanner.nextLine());
            }
            scanner.close();
            socket.close();
        }
    }


    static class Server {
        public static void main(String[] args)throws Exception {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器已经启动！");
            // 服务端监听
            while (true) {
                // accept()接收客户端发送的信息
                Socket socket = serverSocket.accept();
                // 创建新线程处理IO
                new Thread(() -> {
                    try {
                        // 输入流
                        Scanner inputScanner = new Scanner(socket.getInputStream());
                        // 输出流
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());

                        while (inputScanner.hasNextLine()) {
                            // 处理客户端信息
                            System.out.println("收到客户端内容: " + inputScanner.nextLine());
                            Scanner scanner = new Scanner(System.in);
                            if (scanner.hasNextLine()) {
                                // 响应到客户端
                                pw.println(scanner.nextLine());
                                pw.flush();
                            }
                        }
                        socket.close();
                        inputScanner.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        }
    }

}


