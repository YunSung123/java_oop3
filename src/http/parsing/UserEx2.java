package http.parsing;

import com.google.gson.Gson;

public class UserEx2 {

    public static void main(String[] args) {

        User2 user2 = new User2();
        User2.Address address = new User2.Address();
        User2.Address.Geo geo = new User2.Address.Geo();
        User2.Company company = new User2.Company();

        user2.setAddress(address);
        user2.getAddress().setStreet("asdsad");

        Gson gson = new Gson();
        String string = gson.toJson(user2);
        System.out.println(string);
        //System.out.println(userJson);
    } // end of main
} // end of class
