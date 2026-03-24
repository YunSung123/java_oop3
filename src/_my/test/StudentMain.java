package _my.test;

import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRepository repo = new StudentRepository();


        // todo일단 등록
        repo.registerStudent("홍길동", "010 - 1111 - 1111", 1);
        repo.registerStudent("강감찬", "010 - 1111 - 1111", 2);
        repo.registerStudent("이순신", "010 - 1111 - 1111", 2);
        repo.registerStudent("이순신", "010 - 1234 - 5678", 3);

        // 학번으로 조회


        while (true) {
            System.out.println("1. 학생 등록");
            System.out.println("2. 학번으로 검색");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 전체 목록 출력 검색");
            String choice = sc.nextLine();
            if (choice.equals("1")){

            } else if (choice.equals("2")) {
                int studentId = Integer.parseInt(sc.nextLine());
                repo.findById(studentId);
            }
        }
    } // end of main

} // end of class
