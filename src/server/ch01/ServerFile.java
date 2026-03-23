package server.ch01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile extends Thread {

    public static void main(String[] args) {
        // 소켓 통신을 하기 위한 서버측 테스트 코드 1
        // (내 IP 주소 당연히 알고 있음 )
        // 포트 번호를 열고 클라이언트에 연결 요청을 기다리는 서버소켓
        // IP : 192.168.4.101

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            boolean flag = false;
            // accept() - 클라이언트가 연결할 때 까지 이 줄에서 멈춤(블로킹)
            Socket clientSocket = serverSocket.accept();
            // 1. 코드가 아래로 안 내려 감 (블로킹)
            System.out.println("클라이언트가 연결됐습니다.");

            // 쓰레드 생성
            // Thread thread = new Thread();
            // connetingChat(clientSocket);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println("오류 발생 : 포트 5000 이미 사용 중이거나 연결에 실패 했습니다. ");
        }
    } // end of main
    static void connetingChat(Socket clientSocket) throws IOException {
        // 2. 소켓 객체가 생성이 되면 (accept()) 이 소켓이 클라이언트 소켓과 연결되어 있는 소켓이다
        // I/O 단원에서 배운 체인 그래로
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        // 클라이언트가 보낸 한 줄을 읽음
        while (true) {
            String message = reader.readLine();
            // 내 서버측 콘솔창에 출력
            if (message != null) {
                System.out.println(message);
                message = null;
            }

            if (clientSocket.isClosed()) {
                break;
            }
        }
    }

    private static void work() {
    }

} // end of class
