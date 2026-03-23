package _my.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    public static void main(String[] args) {
        // 서버 소캣
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버 시작 ....");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 블러킹
            serverSocket.accept();
            // 메세지 읽기
            System.out.println(br.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("시스템이 종료되었습니다.");
    } // end of main
} // end of class
