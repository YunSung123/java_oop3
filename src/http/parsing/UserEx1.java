package http.parsing;

import com.google.gson.Gson;

public class UserEx1 {

    public static void main(String[] args) {

        User user =new User();
        user.setId(100);
        user.setName("홍길동");
        user.setEmail("a@naver.com");

        // User 안에 있는 Address 객체를 생성하는 방법
        User.Address address = user.new Address();
        user.getAddress().setCity("부산");
        user.getAddress().setStreet("중앙대로");

        User.Address.Geo geo = user.getAddress().getGeo();
        user.getAddress().getGeo().setLat("123.1");
        user.getAddress().getGeo().setLng("44.125");

        Gson gson = new Gson();
        String userJson =  gson.toJson(user);

        System.out.println(userJson);
    } // end of main
} // end of class
