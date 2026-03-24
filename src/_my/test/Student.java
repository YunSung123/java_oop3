package _my.test;

import lombok.Data;

@Data
class Student {
    int studentId;
    String name;
    String phone;
    int grade;

    public Student(String name, String phone, int grade) {
        this.name = name;
        this.phone = phone;
        this.grade = grade;
    }
}
