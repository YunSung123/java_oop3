package http.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Air {

    List<Air.Item> list = new ArrayList<>();

    @Data
    public class Item {
        // items1
        private String claearVal;
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
