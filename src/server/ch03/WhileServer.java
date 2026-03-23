package server.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class WhileServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("클라이언트에 연결 요청을 기다립니다...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("======== 서버 실행 ========");

            /// 소켓과 연결된 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            ///  키보드와 연결할 스트림
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while ((line = reader.readLine()) != null) {
                // eqalsIgnoreCase 대소문자 구분없이 값 확인
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }

                System.out.println("클라이언트 > " + line);
                System.out.print("서버 입력 > ");
                // ** 서버에서 응답을 받아야만 메세지를 보낼 수 있음 **
                String severMsg = keyboardReader.readLine(); // 블로킹 상태
                // 클라이언트와 연결 된 소켓 출력 스트림을 활용해서 내용을 전달한다.
                writer.println(severMsg);
                // 서버 측에서도 더이상 글 입력 받기 싫다면 exit 입력으로 while 문 종료 처리
                if ("exit".equalsIgnoreCase(severMsg)){
                    break;
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
