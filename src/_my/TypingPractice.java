package _my;

import java.util.Random;
import java.util.Scanner;

public class TypingPractice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] sentences = {
                "자바는 객체지향 프로그래밍 언어입니다.",
                "오늘도 꾸준히 타자 연습을 해봅시다.",
                "정확한 입력은 빠른 속도보다 더 중요합니다.",
                "반복은 실력을 만든다.",
                "천천히 시작해서 점점 속도를 올리세요.",
                "나는 자바를 배우고 있다.",
                "파일 입출력은 프로그램에서 매우 중요하다.",
                "스캐너를 사용하면 사용자 입력을 받을 수 있다.",
                "클래스와 객체의 차이를 이해하는 것이 중요하다.",
                "꾸준한 연습이 실력 향상의 지름길이다."
        };

        System.out.println("=== 자바 타자 연습 프로그램 ===");

        while (true) {
            System.out.println();
            System.out.println("1. 타자 연습 시작");
            System.out.println("2. 종료");
            System.out.print("선택 : ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                String target = sentences[random.nextInt(sentences.length)];

                System.out.println();
                System.out.println("[문제]");
                System.out.println(target);
                System.out.println();
                System.out.print("위 문장을 그대로 입력하세요 : ");

                long startTime = System.currentTimeMillis();
                String input = sc.nextLine();
                long endTime = System.currentTimeMillis();

                double seconds = (endTime - startTime) / 1000.0;

                int correctCount = countCorrectCharacters(target, input);
                int maxLength = Math.max(target.length(), input.length());

                double accuracy;
                if (maxLength == 0) {
                    accuracy = 100.0;
                } else {
                    accuracy = (correctCount * 100.0) / maxLength;
                }

                // 분당 타수 계산
                // 입력한 글자 수 / 걸린 초 * 60
                double typingSpeed = 0;
                if (seconds > 0) {
                    typingSpeed = (input.length() / seconds) * 60;
                }

                System.out.println();
                System.out.println("=== 결과 ===");
                System.out.println("입력한 문장 : " + input);
                System.out.printf("걸린 시간 : %.2f초%n", seconds);
                System.out.println("맞은 글자 수 : " + correctCount + " / " + maxLength);
                System.out.printf("정확도 : %.2f%%%n", accuracy);
                System.out.printf("분당 타수 : %.2f타%n", typingSpeed);

                if (target.equals(input)) {
                    System.out.println("판정 : 성공! 완벽하게 입력했습니다.");
                } else {
                    System.out.println("판정 : 오타가 있습니다.");
                }

            } else if (choice.equals("2")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }

        sc.close();
    }

    // 같은 위치의 글자가 얼마나 일치하는지 계산
    public static int countCorrectCharacters(String target, String input) {
        int minLength = Math.min(target.length(), input.length());
        int count = 0;

        for (int i = 0; i < minLength; i++) {
            if (target.charAt(i) == input.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}