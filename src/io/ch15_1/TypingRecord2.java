package io.ch15_1;

import java.io.FileInputStream;
import java.io.IOException;

public class TypingRecord2 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("typing_recod.txt");
            int data = fin.read();
            System.out.println(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main


}
