package client.ch05;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends AbstractClient {

    public ChatClient(String name){
        super(name);
    }

    @Override
    protected void connectToServer() throws IOException {
        // 부모 클래스 멤버 변수인 socket 에 객체의 주소값을 할당 하지 않으면
        // nullPointerException 발생함
        setSocket(new Socket("localhost", 5000));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요 : ");
        String name = sc.nextLine();

        new ChatClient(name).run();

    }
}
