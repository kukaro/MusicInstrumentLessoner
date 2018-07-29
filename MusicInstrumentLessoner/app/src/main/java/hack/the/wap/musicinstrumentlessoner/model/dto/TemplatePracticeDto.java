package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.io.Serializable;

public class TemplatePracticeDto implements Serializable{
    private int practiceId;
    private String fileName;

    public TemplatePracticeDto(int practiceId, String fileName) {
        this.practiceId = practiceId;
        this.fileName = fileName;
    }

    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "TemplatePracticeDto{" +
                "practiceId=" + practiceId +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
