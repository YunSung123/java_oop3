package io.ch17_1;

import java.io.*;
import java.util.Scanner;

public class ChatLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== 채팅 로그 저장소 ===");
        System.out.println("1. 대화 저장");
        System.out.println("2. 전체 로그 보기");
        System.out.println("3. 단어 검색");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveChat();
        } else if (choice.equals("2")) {
            printAll();
        } else if (choice.equals("3")) {
            System.out.print("검색할 단어 : ");
            String keyword = sc.nextLine().trim(); // 점프는 trim 쓰닌깐 해결
            searchChat(keyword);
        }
    } // end of main

    private static void searchChat(String keyword) {
        try (BufferedReader br = new BufferedReader(new FileReader("chat_log.txt"))) {
            System.out.println("\n=== " + keyword + " 검색 결과 ===");
            String line;
            int count = 0;
            while ((line = br.readLine()) != null){
                // 만약 keyword 단어 포함 되어 있다면 ....
                if (line.contains(keyword)){
                    System.out.println(line);
                    count++;
                }
            }

            if (count == 0){
                System.out.println(keyword + " 가 포함된 대화가 없습니다");
            } else{
                System.out.println("\n총 " + count + "개의 대화 내용이 발견되었습니다.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void printAll() {
        System.out.println("\n=== 전체 채팅 로그===");
        try (BufferedReader br = new BufferedReader(new FileReader("chat_log.txt"))) {
            String line;
            int num = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(num++ + " | " + line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void saveChat() {
        System.out.println("이름과 메시지를 입력하세요. (종료: 빈 줄 입력)");
        System.out.println("형식: 이름>메시지 예) 홍길동> 안녕하세요");

        // System.in(바이트 기반) -> InputStreamReader(문자 변환)- BufferedReader
        // FileWriter("파일명") -> BufferedWriter

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("chat_log.txt", true))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            System.out.println("채팅 로그가 저장되었습니다.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // end of saveChat()
}
