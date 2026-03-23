package server.ch04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultiClientServer {

    private static final int PORT = 5000;
    // 연결된 모든 클라이언트의 출력 스트림을 보관할 자료구조
    // Vector 는 멀티 스레드 환경에서 안전한 동작을 한다.
    private static Vector<PrintWriter> clienWriterList = new Vector<>();

    public static void main(String[] args) {
        System.out.println("서버 시작 ...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // 블로킹
                // 클라이언트 접속 --> 전담 스레드 생성 --> 메인 스레드는 다시 대기
                new ClientHandler(clientSocket).start();
                System.out.println("클라이언트 접속 . 현재 접속자" + clienWriterList.size() + "명");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main

    // 각 클라이언트와의통신을 담당하는 정적 내부 클래스
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        // 스레드가 start() 호출 되면 서브 작업자가 일함..
        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
                // 추후 접속자 명수 확인 또는 방송(브로드 캐스트를) 하기 이해 벡터 자료구조 저장할 예정
                clienWriterList.add(out);

                String message;
                while ((message = in.readLine()) != null){
                    System.out.println("수신 : " + message);
                    // 받은 메세지를 연결된 모든 클라이언트에게 전송 (브로드 캐스트)
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("누군가 채팅 서버를 종료했습니다.");
            } finally {
                clienWriterList.remove(out);
                try {
                    if(socket != null){
                        socket.close();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 방송하기
        private void broadcast(String message){
            for (PrintWriter writer : clienWriterList) {
                writer.println(message);
            }
        }
    } // end of ClientHandler
} // end of class
