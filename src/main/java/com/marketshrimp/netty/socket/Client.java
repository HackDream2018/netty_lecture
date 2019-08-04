package com.marketshrimp.netty.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            // 输入流
            Scanner inputScanner = new Scanner(socket.getInputStream());
            // 输出流
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                pw.println(scanner.nextLine());
                pw.flush();
                System.out.println("服务器响应内容: "+inputScanner.nextLine());
            }
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}