package _my.test;

import java.util.*;

public class StudentRepository {
    List<Student> studentList = new ArrayList<>();
    Map<Integer, Student> studentMap = new HashMap<>();
    Set<String> phoneSet = new HashSet<>();
    private int studentId = 0;

    // 학생 등록
    public void registerStudent(String name, String phone, int grade) {
        Student student = new Student(name, phone, grade);
        studentList.add(student);
        studentMap.put(studentId, student);
        phoneSet.add(phone);
        studentId++;
    }

    // 학번으로 학생 1명 조회
    public void findById(int studentId) {
        System.out.println(studentMap.get(studentId));
    }

    // 이름으로 학생검색
    public void findByName() {
        for (Student student : studentList){

        }
    }

    // 전체 학생 목록 출력
    public void showStudentAll() {

    }

    // 전화번호 중복 방지
    public void noSamePhoneNumber() {

    }
}
