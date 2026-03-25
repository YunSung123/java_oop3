package http.json;

import com.google.gson.Gson;

public class ToJsonEx {

    public static void main(String[] args) {
        Post post = new Post();
        post.setId(10);
        post.setUrl("abcde@naver.com");

        Gson gson = new Gson();
        String jsonPost = gson.toJson(post);
        System.out.println(jsonPost);
    }
}
