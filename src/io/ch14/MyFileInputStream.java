package io.ch14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {
    public static void main(String[] args) {

        // 파일을 바이트 단위로 읽어 들이는 스트림
        FileInputStream in = null;
        int readData;

        try {
            // 다른 코드가 더 있다면 ...
            in = new FileInputStream("a.text");
            // 첫 번째 바이트 읽기
            readData = in.read();
            System.out.println("readData : " + readData);
            System.out.println("readData : " + (char)readData);

            // 두 번째 바이트 읽기
            readData = in.read();
            System.out.println("readData : " + readData);
            System.out.println("readData : " + (char)readData);

            // 세 번째 바이트 읽기
            readData = in.read();
            System.out.println("readData : " + readData);
            System.out.println("readData : " + (char)readData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
