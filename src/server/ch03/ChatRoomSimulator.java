package server.ch03;

import java.util.Vector;

public class ChatRoomSimulator {

    private static Vector<String> userlist = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        // ArrayList와 사용법 동일

        // 공유 자원
        Vector<String> list = new Vector<>();
        list.add("철수");
        list.add("영희");
        list.remove("영희");
        list.get(0);
        list.size();
        // System.out.println(list.contains("철수"));

        /*for (String name : list) {
            System.out.println(name);
        }*/

        System.out.println("=== 채팅방 접속자 시뮬레이션 ===");

        // 3명이 동시에 접속
        // 람다 표현식 이다.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                userlist.add("철수");
                System.out.println("[접속] 철수 | 현재 " + userlist.size() + "명");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                userlist.add("영희");
                System.out.println("[접속] 영희 | 현재 " + userlist.size() + "명");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                userlist.add("민준");
                System.out.println("[접속] 민준 | 현재 " + userlist.size() + "명");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("최종 접속자 : " + userlist);

        // 영희 퇴장
        userlist.remove("영희");
        System.out.println("영희 퇴장 후 : " + userlist);
    } // end of main
}
