package io.ch13;

import java.io.IOException;

/**
 *  표준 입출력이란?
 *  자바에서 표준 입출력은 프로그램과 사용자간에 기본적인 데이터 교환 방법을 제공합니다.
 */
public class MySystemIn2 {

    public static void main(String[] args) {
        System.out.println("알파벳 하나를 쓰고  enter 키를 누르세요");
        int i;
        try {
            while ((i = System.in.read()) != '\n' ) {
                // 엔터(/n) 가 입력될떄까지 반복해서 일기
                System.out.println("i : " + i);
                // InputStream 은 바이트 단위로 데이터를 읽어 오기 때문에 문자로 표현 하려면 형 변환 해야 한다.
                System.out.println("문자로 표현 : " + (char)i);
            }
            // 주의 : 한글(3바이트)은 처리 불가 -> 깨진 문자나 의미 없는 정수값이 출력됨


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
