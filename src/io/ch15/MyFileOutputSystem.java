package io.ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputSystem {

    public static void main(String[] args) {
        String data = "Hell Java, FileOutputSystem abc abc 안녕 반가워";
        // 파일이 벗으면 새로 생성 , 있으면 덮어 쓰기
        // FileOutputStream fos = new FileOutputStream("output.txt");


        // FileOutputStream fos = new FileOutputStream("output.txt", true);
        // 기존 파일에 내용이 있으면 true, 이어쓰기, false 덮어쓰기

        try (
                FileOutputStream fos = new FileOutputStream("output.txt", false)
        ) {
            // 문자열은 FileOutputStream 으로 직접 슬 수 없습니다.
            // 문자열을 -> byte 배열로 변환 해서 넣어 주어야 합니다.
            // 문자열을 바이트 배열로 변환해서 임시 변수에 담아 둠
            fos.write(data.getBytes());

            // fos.flush();
            System.out.println("파일 출력 완료 ㅣ output.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 참고 : out.text 를 에디터
    } // end of main
}
