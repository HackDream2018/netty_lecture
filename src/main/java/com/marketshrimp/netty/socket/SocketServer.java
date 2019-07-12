package com.marketshrimp.netty.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器已经启动！");
            // 服务端监听
            while(true){
                // accept()接收客户端发送的信息
                Socket socket = serverSocket.accept();
                // 创建新线程处理IO
                new Thread(() -> {
                    try {
                        // 输入流
                        Scanner inputScanner = new Scanner(socket.getInputStream());
                        // 输出流
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());

                        while(inputScanner.hasNextLine()){
                            // 处理客户端信息
                            System.out.println("收到客户端内容: "+inputScanner.nextLine());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}