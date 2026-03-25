package http.json;

public class NotJsonEx {

    public static void main(String[] args) {
        String json = "{\"name\":\"철수\",\"age\" : 25 }";
        System.out.println(json);

        // 1단계 : 불필요한 기호제거
        String step1 = json.replace("{", "").replace("}", "");
        System.out.println(step1);

        // 단계 2 : 항목별 자르기
        String[] parts = step1.split(",");
        System.out.println(parts.length);
        System.out.println(parts[1]);

        // 단계 3 : 데이터 추출
        // 첫번째 조각에서 "name" : "철수" 기준에서 철구라는 값을 추출
        String nameValue = parts[0].split(":")[1];

        System.out.println(nameValue);
        // 두번째 조각에서 25를 추출
        String ageString = parts[1].split(":")[1];
        int ageValue = Integer.parseInt(ageString.trim());
        System.out.println(ageValue);

        // 단계 4 : 자바 프로그램에서 이해하는 데이터 타입 -> 객체로 변환
        // 객체
        User user = new User(nameValue, ageValue);
        System.out.println(user.toString());
    }

}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
