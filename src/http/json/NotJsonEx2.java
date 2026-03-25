package http.json;

import lombok.Data;

public class NotJsonEx2 {
    public static void main(String[] args) {
        String json = "{\"userId\": 1, \"id\": 1, \"title\": \"quidem molestiae enim\"}";

        // {} 제거
        String step1 = json.replace("{","").replace("}","");
        System.out.println("step1 : " + step1);

        // , 로 파츠 3개 만들기
        String parts[] = step1.split(",");
        System.out.println("총 갯수 : " + parts.length);
        System.out.println(parts[0]);

        // : 로 또 나누기
        String userIdString = parts[0].split(":")[1];
        String idString = parts[1].split(":")[1];
        String titleString = parts[2].split(":")[1];

        // 변환
        int userId = Integer.parseInt(userIdString.trim());
        int id = Integer.parseInt(idString.trim());

        // 생성해보기
        Album album = new Album(userId, id, titleString);

        System.out.println(album.toString());
    } // end of main

} // end of class

class Album {
    private int userId;
    private int id;
    private String title;

    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
