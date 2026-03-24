package map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {
        // 학생이름, 점수
        Map<String, Integer> scores = new HashMap<>();

        // 추가 (put)
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민준", 92);

        // 조회 (get)
        System.out.println(scores.get("철수"));
        System.out.println(scores.get("없는값"));

        // 포함 여부
        System.out.println(scores.containsKey("영희"));
        System.out.println(scores.containsValue(85));
        System.out.println(scores.containsValue(10));

        scores.remove("민준");

        System.out.println(scores.size());

        // put()은 덮어씌우기도 합니다.
        scores.put("철수", 0);
        for (String name : scores.keySet()) {
            System.out.println(name + " : " + scores.get(name) + " 점수");
        }
    }
}
