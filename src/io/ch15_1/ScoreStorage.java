package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScoreStorage {

    public static void main(String[] args) {
        StringBuffer stb = new StringBuffer();
        stb.append("abc");
        System.out.println(stb);
        System.out.println(stb.toString());


        //Scanner sc = new Scanner(System.in);
        //saveScore(sc);

        //printScore();


    }

    private static void saveScore(Scanner sc) {
        System.out.println("학생 수를 입력하세요 : ");
        StringBuffer sb = new StringBuffer();
        // integer.parsetInt() --> 문자열값 --> int 형으로 변환
        try {
            int count = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println(i + "번쨰 학생 점수 ");
                // sb에 계속 append() + 10 + 20 + 30 +
                String score = sc.nextLine();
                sb.append(score);
                sb.append(" ");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        try {
            FileOutputStream fos = new FileOutputStream("scores.txt");
            fos.write(sb.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printScore() {
        System.out.println("점수 분석 총점 / 평균");
        try {
            FileInputStream fin = new FileInputStream("scores.txt");

            // 파일 진체를 문자열로 읽기
            StringBuffer sb = new StringBuffer();
            int data;
            int total = 0;
            while ((data = fin.read()) != -1){
                sb.append((char) data);
            }
            // 공백 기준으로 문자열을 자르는 split
            String[] parts = sb.toString().trim().split(" ");
            for (String part : parts){
                total += Integer.parseInt(part);
                System.out.println("점수 : " + part);
            }

            System.out.println(total);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
