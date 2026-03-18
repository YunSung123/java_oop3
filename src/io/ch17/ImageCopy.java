package io.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy {

    public static void main(String[] args) {
        // png 파일을 읽어서
        // 파일 만들어보기

        long before = System.currentTimeMillis();
        copyImage("1.png", "2.png");
        long after = System.currentTimeMillis();

        System.out.println("걸린 시간 : " + (after - before));
    }

    private static void copyImage(String image, String copy) {
        try (FileInputStream fis = new FileInputStream(image);
             FileOutputStream fos = new FileOutputStream(copy)) {

            //byte[] buffer = new byte[1024]; // 한 번에 1024 바이트씩 읽을 버퍼
            int bytesRead;

            while ((bytesRead = fis.read()) != -1) {
                fos.write(bytesRead); // 읽은 만큼만 씀
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
