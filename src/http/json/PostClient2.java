package http.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * https://jsonplaceholder.typicode.com/photos/1
 */
public class PostClient2 {

    public static void main(String[] args) {
        // 사이트 주소
        String site = "https://jsonplaceholder.typicode.com/photos/1";
        // 연결 객체
        HttpURLConnection connection = null;

        // Url 은 뭐?
        try {
            URL url = new URL(site);

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            // connection.setRequestProperty("Accept","app/Json");

            // 이제 읽자 Reader
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                String sbString = sb.toString();
                // 지손 사용
                Gson gson = new Gson();



                // gson.fromJson(sbString, posts); 배열 넣을려면 Token 해줘야됨
                TypeToken<List<Post>> typeToken = new TypeToken(){};

                // List<Post> posts = new ArrayList<>()
                List<Post> posts = gson.fromJson(sbString, typeToken);

                System.out.println(posts.get(0));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

} // end of class
