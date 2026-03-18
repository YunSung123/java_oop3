package io.ch17;


import java.io.*;

public class CharBufferedKeyboardConsole2 {

    public static void main(String[] args) throws IOException {
        // 메세지를 받아서 그대로 출력하기

        // System.in
        // System.in 이므로 input : 입력 사용
        InputStreamReader isr = new InputStreamReader(System.in);
        // 여기에 버퍼 달아보기
        BufferedReader reader = new BufferedReader(isr);

        // System.out
        // Systme.out 이므로 output :  출력 사용
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        // But 사용하기 편리한 PrintWriter 로 변경
        PrintWriter pw = new PrintWriter(System.out);
        // 여기에 버퍼 달아보기
        BufferedWriter writer = new BufferedWriter(pw);

        System.out.println("==========콘솔창에 입력=============");
        // 입력은?? readeline() 사용
        //reader.readLine();

        // 출력은?? writer() 사용
        writer.write(reader.readLine()); // 입력하자말자 해당 값을 바로 출력하기

        writer.newLine(); // 운영체제에 맞는 줄 바꿈 자동 삽입
        writer.flush(); // 버퍼에 남은 데이터 즉시 출력

     } // end of main
}
