package http.parsing;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private Address address;
    private Company company;

    @Data
    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        private Geo geo;

        @Data
        public class Geo {
            private String lat;
            private String lng;
        }
    }

    @Data
    public class Company {
        private String name;
        private String catchPhrase;
        private String bs;

    }
}
