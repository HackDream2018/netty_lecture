package com.marketshrimp.netty.http.tcp;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/20
 */
public class HttpClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        // 输入流
        Scanner inputScanner = new Scanner(socket.getInputStream());
        // 输出流
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        for(int i = 0; i < 10; i++) {
            pw.println(String.format("userName: %s, password: %s","aaa", "bbb"));
            pw.flush();
            System.out.println("服务器响应内容: " + inputScanner.nextLine());
        }

        socket.close();
    }

}
