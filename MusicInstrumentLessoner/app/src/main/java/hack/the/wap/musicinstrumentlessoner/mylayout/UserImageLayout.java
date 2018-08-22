package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserDto;
import hack.the.wap.musicinstrumentlessoner.myactivity.DebugActivity;
import hack.the.wap.musicinstrumentlessoner.myactivity.MainActivity;
import hack.the.wap.musicinstrumentlessoner.myactivity.UserGroupDetailActivity;

public class UserImageLayout extends ImageLayout {
    private UserDto mainUser;
    private TextView tvMyImageName;
    private TextView tvMyImageEmail;
    public UserImageLayout(Context context, UserDto dto) {
        super(context);
        mainUser = dto;
        tvMyImageName = findViewById(R.id.tvMyImageName);
        tvMyImageEmail = findViewById(R.id.tvMyImageEmail);
        setImage();
        setListener();
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
        tvMyImageName.setText(mainUser.getName());
        tvMyImageEmail.setText(mainUser.getEmail());
    }

    public void setListener(){
        setOnClickListener((v)->{
            Intent intent = new Intent(getContext(), DebugActivity.class);
            getContext().startActivity(intent);
        });
    }
}
