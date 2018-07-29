package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.io.Serializable;
import java.util.Random;

import hack.the.wap.musicinstrumentlessoner.debug.DebugMode;

public class TemplatePracticeDto implements Serializable {
    private static Random random;
    private int practiceId;
    private int percent;
    private String fileName;

    {
        random = new Random();
    }

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

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        if (DebugMode.DEBUG_MOD) {
            this.percent = 50 + random.nextInt(51);
            return;
        }
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "TemplatePracticeDto{" +
                "practiceId=" + practiceId +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
