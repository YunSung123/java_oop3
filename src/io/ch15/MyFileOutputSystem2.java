package io.ch15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputSystem2 {

    private static String e;

    public static void main(String[] args) {
        String data = "Hell Java, FileOutputSystem abc abc 안녕 반가워";
        // 파일이 벗으면 새로 생성 , 있으면 덮어 쓰기
        // FileOutputStream fos = new FileOutputStream("output.txt");
        // FileOutputStream fos = new FileOutputStream("output.txt", true);
        // 기존 파일에 내용이 있으면 true, 이어쓰기, false 덮어쓰기Z
        // 빈칸을 채우세요
        try (
                FileInputStream fis = new FileInputStream("a.text");
                FileOutputStream fos = new FileOutputStream("output.txt");
        ) {
            // 읽고 쓰는 작업
            fos.write(data.getBytes());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 참고 : out.text 를 에디터
    } // end of main
}
