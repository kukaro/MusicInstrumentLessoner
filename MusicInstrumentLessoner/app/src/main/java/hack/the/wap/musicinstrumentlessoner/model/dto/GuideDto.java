package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class GuideDto {
    private String main;
    private String type;//초,마디
    private HashMap<String,String> data;

    public GuideDto(String main, String type) {
        this.main = main;
        this.type = type;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public void addData(String unit,String value){
        data.put(unit, value);
    }

    @Override
    public String toString() {
        return "GuideDto{" +
                "main='" + main + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
