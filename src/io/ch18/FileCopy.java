package io.ch18;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {

        // 파일 경로 지정
        String sourceFilePath = "employees.zip";
        String destinationFilePath = "employees_copy.zip";

        // 소유 시간 측정 시작
        // 현재 시각을 나노초(10억분의 1초) 단위로 변환 1970 ~
        long startTime = System.nanoTime();

        // 파일 복사 기능 - 빠른 버전 (버퍼 활용)

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath);
             BufferedInputStream bfis = new BufferedInputStream(fis);
             BufferedOutputStream bfos = new BufferedOutputStream(fos)) {

            // 버퍼에 크기를 직접 지정해주자.
            // 1 바이트가 1024개 있으면 1KB
            byte[] bytes = new byte[1024];

            int data;
            while ((data = bfis.read(bytes)) != -1) {
                bfos.write(bytes, 0, data); // 읽은 만큼 씀 !!
            }
            System.out.println("파일 복사 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        long endTime = System.nanoTime();
        // 소유 시간 계산
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0;
        System.out.println("나노 초 값 : " + duration);
        System.out.println("초 값 : " + seconds);
    }
}
