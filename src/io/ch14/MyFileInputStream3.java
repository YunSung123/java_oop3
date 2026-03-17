package io.ch14;

import java.io.FileInputStream;
import java.io.IOException;

public class MyFileInputStream3 {
    public static void main(String[] args) {
        FileInputStream in = null;
        int readData;


        try {
            in = new FileInputStream("a.text");
            readData = in.read();
            System.out.println(readData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
