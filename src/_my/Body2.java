package _my;

import lombok.Data;

@Data
public class Body2 {
    private int totalCount;
    private Items[] items = new Items[2];

    private int pageNo;
    private int numOfRows;

    @Data
    public static class Items {
        private String clearVal;
        private String sn;
        private String districtName;
        private String dataData;
        private String issueVal;
        private String issueTime;
        private String clearDate;
        private String issueDate;
        private String moveName;
        private String clearTIme;
        private String issueGbn;
        private String itemCode;
    }
}
