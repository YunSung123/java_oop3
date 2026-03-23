package client.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 클라이언트는 접근할 서버 컴퓨터에 IP 주소와 포트번호를 알고 있어야 한다.
        try (Socket socket = new Socket("localhost", 5000)) {
            // Socket socket = new Socket("localhost", 5000)
            // 위 코드가 실행되는 순간 내부적으로 이미 서버 컴퓨터와 연결을 시도 한
            // 소켓에 연결된 출력 통로를 가져옴
            //여기로 데이터를 쓰면 상대 컴퓨터로 전송됨
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            while (true){
                String message = sc.nextLine();
                writer.println(message);

                if (false){
                    break;
                }
                // Thread.Sleep();
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
