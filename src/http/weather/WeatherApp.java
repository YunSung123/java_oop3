package http.weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import http.parsing.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// https://history.openweathermap.org/data/2.5/history/city?lat={lat}&lon={lon}&type=hour&start={start}&end={end}&appid={686b6fb0f04aed7fdb3765fea672a44d}
public class Weather {

    public static void main(String[] args) {
        String apiKey = "48f17fd9e73e60977fa6d8246d59eb27";
        double lat = 35.1595;
        double lon = 129.0756;
        long dt = 1711321200L;

        String urlString =
                "https://api.openweathermap.org/data/2.5/weather?lat=35.1595&lon=129.0756&appid=" + apiKey
                        + "?lat=" + lat
                        + "&lon=" + lon
                        + "&dt=" + dt
                        + "&appid=" + apiKey;

        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // ✅ 요청 방식 (필수)
            connection.setRequestMethod("GET");

            // ✅ 응답 타입 (선택이지만 추천)
            connection.setRequestProperty("Accept", "application/json");

            // ✅ 요청 보내기 + 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 : " + responseCode);

            // ✅ 응답 데이터 읽기
            BufferedReader reader;

            if (responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            reader.close();

            System.out.println("응답 데이터:");
            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    } // end of main
}
