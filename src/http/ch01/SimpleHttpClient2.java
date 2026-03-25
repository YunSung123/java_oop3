package http.ch01;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpClient2 {
    public static void main(String[] args) {
        // HTTP 주소 지정
        String http = "https://jsonplaceholder.typicode.com/posts/1";

        // HTTP 요청/응답을 처리하는 객체 선언 : HttpURLConnection
        HttpURLConnection connection;

        try {
            // url 지정
            URL url = new URL(http);
            // (다운 캐스팅) url 에 맞는 연결 객체 생성
            connection = (HttpURLConnection) url.openConnection();
            // 메서드
            connection.setRequestMethod("POST");

            // “응답은 JSON으로 주세요
            connection.setRequestProperty("Accept", "application/json");

            // 응답코드 - 여기로 달라고했으닌깐 여기로 주겠지?
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인 : " + responseCode);

            // 이제 내용을 읽어보자
            //connection.getInputStream();
            //System.out.println();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
