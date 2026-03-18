package io.ch17;

import java.io.*;
import java.util.Scanner;

public class CharBufferedKeyboardConsole {

    public static void main(String[] args) throws IOException {
        /**
         *  스트림 체인 구조
         * [키보드]
         *         System.in(InputStream)
         * InputStreamReader(브릿지)
         * BufferedRead(버퍼 + readLine() 추가)
         *
         * [프로그램] --> 콘솔
         * BufferedWriter (버퍼 + newLine() 추가)
         * PrintWriter
         * System.out(PrintWriter) - 콘솔창에 출력
         */
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        // OutputStreamWriter osw = new OutputStreamWriter(System.out); // 왜 이거안쓰고
        PrintWriter pw = new PrintWriter(System.out); // 이걸 쓸까?
        BufferedWriter bw = new BufferedWriter(pw);

        // 콘솔창에 종료 명령은 컨트롤 D
        System.out.println("텍스트를 입력하세요.");

        String line;
        while((line = br.readLine()) != null){
            bw.write("받은값 출력 : " + line);
            bw.newLine();
            bw.flush();
        }
    } // end of main
}
