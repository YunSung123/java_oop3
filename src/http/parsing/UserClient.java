package http.parsing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// url = https://jsonplaceholder.typicode.com/users/1
public class UserClient {

    public static void main(String[] args) {
        String site = "https://jsonplaceholder.typicode.com/users";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(site);
            connection = (HttpURLConnection) url.openConnection();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }

                String sbString = sb.toString();
                // System.out.println(sbString);

                Gson gson = new Gson();
                TypeToken<List<User>> typeToken = new TypeToken<>(){};
                List<User> userList = gson.fromJson(sbString, typeToken.getType());

                //

                gson = new GsonBuilder().setPrettyPrinting().create();

                String toJsonString = gson.toJson(userList);
                System.out.println(toJsonString);

                /*
                System.out.println("전체 크기 : " + userList.size());
                System.out.println("=== User ===");
                System.out.println(userList.get(0).getId());
                System.out.println(userList.get(0).getName());
                System.out.println(userList.get(0).getUsername());
                System.out.println(userList.get(0).getEmail());
                System.out.println(userList.get(0).getPhone());
                System.out.println(userList.get(0).getWebsite());

                System.out.println("=== Adress ===");
                System.out.println(userList.get(0).getAddress().getStreet());
                System.out.println(userList.get(0).getAddress().getSuite());
                System.out.println(userList.get(0).getAddress().getCity());
                System.out.println(userList.get(0).getAddress().getZipcode());

                System.out.println("=== geo ===");
                System.out.println(userList.get(0).getAddress().getGeo().getLat());
                System.out.println(userList.get(0).getAddress().getGeo().getLng());

                System.out.println("=== Company ===");
                System.out.println(userList.get(0).getCompany().getName());
                System.out.println(userList.get(0).getCompany().getCatchPhrase());
                System.out.println(userList.get(0).getCompany().getBs());
                */
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }


    } // end of main

} // end fo class
