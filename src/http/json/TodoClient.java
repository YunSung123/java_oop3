package http.json;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TodoClient {

    public static void main(String[] args) {
        // 통신할 주고 : https://jsonplaceholder.typicode.com/todos/1
        // 단건 조회 --> JSON {} 응답 됨.

        String urlString = "https://jsonplaceholder.typicode.com/todos";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // 바로 연결 요청
            connection.setRequestMethod("GET");
            // 내가 설정하지 않더라도 기본적인 설정이 구축되어있음

            // 바로 연결 호청
            int responseHttpCode = connection.getResponseCode();
            System.out.println("통신 성보 여부 확인 : " + responseHttpCode);

            // dmdekq 본문 추출
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer responseBody = new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }
                String jsonString = responseBody.toString();
                // 자바 프로그램 사용하려면 JSON 형식 텍스트를 파싱 처리해야 한다.

                // GSON 라이브러리 사용
                Gson gson = new Gson();
                // Java 객체 변환 <--- json 문자열

                // 변환 하고자하는 json 형식에 <-- 1번쨰 인수값
                // 변환 하고자하는 DTO 타입 (클래스)
                Todo todo = gson.fromJson(jsonString, Todo.class);
                System.out.println(todo.getId());
                System.out.println(todo.getUserId());
                System.out.println(todo.getTitle());
                System.out.println(todo.toString());
            }



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
