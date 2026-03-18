package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TypingRecord3 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("===타자 연습 기록기===");
        System.out.println("1. 문장 저장");
        System.out.println("2. 기록 보기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveRecord(sc);
        } else if (choice.equals("2")) {
            printRecord();
        }

        sc.close(); // 메모리 누수 방지

    } // end of main

    private static void printRecord() throws Exception {
        System.out.println("\n===저장된 기록 ===");
        try (FileInputStream fin = new FileInputStream("typing_record.txt")) {
            int data = 0;
            int i = 1;
            // StringBuilder: 문자를 하나씩 이어붙이는 가변 문자열 버퍼
            // String += " 가" 를 반복하면 매번 새로운 객체가 생겨 느리므로 StringBuilder를 사용한다.
            StringBuilder sb = new StringBuilder();
            sb.append(i + "번 기록 : ");
            while ((data = fin.read()) != -1 ){
                if ((char) data != '\n'){
                    sb.append((char)data);
                } else{
                    // sb.append((char)data);
                    sb.append("\n" + ++i + "번 기록 : ");
                }

            }


            System.out.println(sb);
            System.out.println("\n총 " + i + "개의 기록이 있습니다.");
            /*
            System.out.print(i + "번 기록 : ");

            while ((data = fin.read()) != -1) {
                // \n 을 만나면 넘어가기
                if ((char) data == '\n') {
                    System.out.print("\n" + ++i + "번 기록 : ");
                } else {
                    System.out.print((char) data);
                }
            }

             */
        }
    }

    private static void saveRecord(Scanner sc) {
        System.out.print("연습한 문장을 입력하세요 : ");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("typing_record.txt", true)) {
            fos.write(input.getBytes());
            // 줄바꿈 추가
            fos.write("\n".getBytes());
            System.out.println("저장 완료!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}