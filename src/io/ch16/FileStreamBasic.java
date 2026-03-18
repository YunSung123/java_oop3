package io.ch16;

import java.io.FileReader;
import java.io.FileWriter;

public class FileStreamBasic {

    public static void main(String[] args) {
        writeToFIle("basic_output.txt");
        System.out.println("----------------------------");
        readFromFile("basic_output.txt");
    } // end of main

    public  static void writeToFIle(String fileName){
        /**
         * FileWriter 는 문자 기반 출력 스트림입니다.
         * FileOutputStream 과 fos.write(byte[]) 달리 write(String) 이 가능합니다.
         * getBytes() 변환이 필요가 없습니다.
         */

        try (FileWriter writer = new FileWriter(fileName, true)) {
            String text = "자바 문자 기반 스트림 예제\n";
            writer.write(text);
            writer.write("추가 문자열을 기록합니다\n");
            // writer.flush(); 주석 생략 가능함
            System.out.println("파일에 텍스트를 잘 기록하였습니다.");

        } catch (Exception e) {
            System.out.println("파일 쓰기 중 오류 발생 : " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName){
        /**
         * FileReader 는 문자기반 입력 스트림입니다.
         * read() 는 한 문자씩 읽어 유니코드 값(정수)으로 반환합니다
         * FileInputStream과 사용법은 같지만 한그리 꺠지지 않습니다.
         */

        try (FileReader reader = new FileReader(fileName)) {

            int charCode;
            while((charCode = reader.read()) != -1){
                System.out.print((char)charCode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
