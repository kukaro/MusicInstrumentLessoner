package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TeacherDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserDto;

public class UserImageLayout extends ImageLayout {
    private UserDto mainUser;
    public UserImageLayout(Context context, UserDto dto) {
        super(context);
        mainUser = dto;
        setImage();
    }

    public UserImageLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UserImageLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UserImageLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setImage(){
        ivMyImage.setImageResource(DebugImageMatch.getImageFromName(mainUser.getName()));
    }
}
