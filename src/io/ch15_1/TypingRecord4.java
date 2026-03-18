package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TypingRecord4 {
    private static boolean isAgain = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveMemo(sc);
        } else if (choice.equals("2")) {
            readMemo(sc);
        }

    }

    private static void readMemo(Scanner sc) {
        System.out.print("복호화 키 : ");
        String input = sc.nextLine();

        try (FileInputStream fis = new FileInputStream("secret.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - Integer.parseInt(input)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveMemo(Scanner sc) {

        System.out.print("저장할 메모 : ");
        String input = sc.nextLine();

        while (true) {
            isAgain = false;
            System.out.print("암호화 키 : ");
            String key = sc.nextLine();

            try (FileOutputStream fos = new FileOutputStream("secret.txt")) {

                byte[] original = input.getBytes(); // [65][66][67] ...
                // 배열 크기만 선언한 상태
                byte[] encrypted = new byte[original.length]; // [65 + 3][66 + 3][67+ 3] ...

                for (int i = 0; i < original.length; i++) {
                    int value = original[i] + Integer.parseInt(key);
                    // 해당 값이 바이트 범위를 벗어날 경우
                    if (value < -127 || value > 128) {
                        System.out.println("범위를 벗어납니다. : " + value);
                        isAgain = true;
                        break; // 빠른 탈출
                    } else {
                        encrypted[i] = (byte) (original[i] + Integer.parseInt(key));
                    }

                }

                // 범위 를 벗어나서 다시 해야됨
                if (isAgain == true) {
                    System.out.println("돌아갑니다.");
                    continue;
                }

                // 데이터를 암호화 한 후 파일에 쓰기
                fos.write(encrypted);
                // fos.flush(); -> fos.close() 호출 시 자동 호출 flush()

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            break;
        }
    }
}


