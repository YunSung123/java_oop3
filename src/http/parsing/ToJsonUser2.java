package http.parsing;

import com.google.gson.Gson;

public class ToJsonUser2 {

    public static void main(String[] args) {

        User user =new User();
        user.setId(1);
        user.setName("홍길동");
        user.setEmail("a@naver.com");
        user.setAddress(user.getAddress());

        user.getAddress().setCity("부산");
        user.getAddress().setStreet("중앙대로");
        user.getAddress().getGeo().setLat("123.1");
        user.getAddress().getGeo().setLng("44.125");

        Gson gson = new Gson();
        String userJson =  gson.toJson(user);

        System.out.println(userJson);
    } // end of main
} // end of class
