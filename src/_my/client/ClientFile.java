package _my.client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    public static void main(String[] args) {
        // 소켓
        try (Socket socket = new Socket("localhost", 5000)) {
            // 문자 데이터를 편하게 출력하기 위한 객체
            // println(), print(), printf() 등을 사용할 수 있음
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("안녕");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main

} // end of class

