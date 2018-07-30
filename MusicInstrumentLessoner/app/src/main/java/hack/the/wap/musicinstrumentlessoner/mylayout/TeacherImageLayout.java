package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TeacherDto;

public class TeacherImageLayout extends ImageLayout {
    private TeacherDto mainTeacher;
    public TeacherImageLayout(Context context, TeacherDto dto) {
        super(context);
        mainTeacher = dto;
        setImage();
    }

    public TeacherImageLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TeacherImageLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TeacherImageLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setImage(){
        ivMyImage.setImageResource(DebugImageMatch.getImageFromName(mainTeacher.getName()));
    }
}
