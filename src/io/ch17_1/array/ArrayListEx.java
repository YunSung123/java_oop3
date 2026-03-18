package io.ch17_1.array;

import java.util.ArrayList;

public class ArrayListEx {

    public static void main(String[] args) {
        // ArrayList 는 배열에 불편함을 해결해 주는 클래스이다.
        ArrayList<String> list = new ArrayList<>();
        list.add("사과"); //[0] 번째 저장
        list.add("바나나"); //[1] 번째 저장
        list.add("포도"); //[2] 번째 저장
        list.add("포도"); //[3] 번째 저장

        System.out.println(list.get(0));
        System.out.println(list.get(3));
        // System.out.println(list.get(100)); 범위 벗어나서 오류 발생

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

//        list.remove("사과");
//        list.remove("바나나");
//        list.remove("포도");
//        list.remove("포도11111"); // 없는 데이터라면 무시됨 -> 예외는 안 던짐
        // list.removeAll();
        list.clear(); /// 전체 삭제

        System.out.println(list.isEmpty());


        System.out.println("=====================");
        // 편의 기능
        System.out.println("현재 arrayList 에 길이" + list.size());
        System.out.println(list.contains("사과"));
    } // end of main
}
