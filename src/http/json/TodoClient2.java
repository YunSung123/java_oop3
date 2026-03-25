package http.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TodoClient2 {

    public static void main(String[] args) {
        // 통신할 주고 : https://jsonplaceholder.typicode.com/todos/1
        // 여러건 조회 --> JSON Array [{}{}{}{}{}{}{}{}{}{}] 응답 됨.

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
                System.out.println("JSON ARRAY 응답 : " + responseBody);
                // 자바 프로그램 사용하려면 JSON 형식 텍스트를 파싱 처리해야 한다.

                // JSON Array 파싱
                // TypeToken : List<Todo> 처럼 제네릭 타입을 파싱할 때 사용
                Gson gson = new Gson();

                TypeToken<List<Todo>> typeToken = new TypeToken<>(){};
                List<Todo> todoList = gson.fromJson(jsonString, typeToken.getType());

                System.out.println("전체 갯수 " + todoList.size());

                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println(todoList.get(i));
                }

            }



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
