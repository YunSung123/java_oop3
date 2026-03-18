package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretNote {

    public static void main(String[] args) {
        // 1. 키보드에서 값을 받아야 한다.
        // 2. 파일에다가 키보드에서 입력 받은 값을 저장 시켜야 한다.
        // 2.1 단 --> 내용을 살짝 변경해서 저장해야 한다. (아스키 코드 65 66 67 68 값에 + 3)

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveMemo(sc);
        } else if (choice.equals("2")) {
            loadMemo();
        }

    } // end of main

    private static void loadMemo() {
        // 3. 파일에서 데이터를 한 바이트 씩 읽어야 한다.
        // 3.1 한 바이트를 읽을 때 마다 아스키 코드값 기준 =3 씩해서 암호를 해석한다.
        System.out.println("\n=== 복호화된 메모 ===");
        try (FileInputStream fis = new FileInputStream("secret.txt")) {
            // 스스로 도전 (한 바이트 씩 개수만큼 읽어서 콘솔에 출력하시오) - 암호도 풀어 보세요.
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - 3));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveMemo(Scanner sc) {
        System.out.println("=== 비밀 메모장 ===");
        System.out.print("저장할 메모를 입력하세요 : ");
        String input = sc.nextLine();

        System.out.println(input);

        try (FileOutputStream fos = new FileOutputStream("secret.txt")) {
            byte[] original = input.getBytes(); // [65][66][67] ...
            // 배역 크기만 선언한 상태
            byte[] encrypted = new byte[original.length];

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte) (original[i] + 3);
            }

            // 데이터를 암호화 한 후 파일에 쓰기
            fos.write(encrypted);
            // fos.flush(); -> fos.close() 호출 시 자동 호출

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
