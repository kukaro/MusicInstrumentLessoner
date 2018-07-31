package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.StoreDto;

/*
참고 사이트 : https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088
           http://gun0912.tistory.com/38
 */

public class StoreLayout extends LinearLayout {
    private ImageView ivStoreLayGroupImage;
    private TextView tvStoreLayMusicTitle;
    private TextView tvStoreLayMain;
    private TextView tvStoreLaySub;

    {
        initView();
    }

    public StoreLayout(Context context) {
        super(context);
    }

    public StoreLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public StoreLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StoreLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        inflate(getContext(), R.layout.template_layout, this);
        ivStoreLayGroupImage = findViewById(R.id.ivStoreGroupImage);
        tvStoreLayMusicTitle = findViewById(R.id.tvStoreLayMusicTitle);
        tvStoreLayMain = findViewById(R.id.tvStoreLayMain);
        tvStoreLaySub= findViewById(R.id.tvStoreLaySub);
        ivStoreLayTeacherImage = findViewById(R.id.ivStoreLayTeacherImage);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.StoreLayout);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attributeSet, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.StoreLayout, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        int templateLayUserImage = typedArray.getResourceId(R.styleable.StoreLayout_template_lay_user_image, R.drawable.beethoven_round);
        String templateLayMusicTitle = typedArray.getString(R.styleable.StoreLayout_template_lay_music_title);
        String templateLayMain = typedArray.getString(R.styleable.StoreLayout_template_lay_main);
        String templateLaySub = typedArray.getString(R.styleable.StoreLayout_template_lay_sub);
        int templateLayTeacherImage = typedArray.getResourceId(R.styleable.StoreLayout_template_lay_teacher_image,R.drawable.choa_round);
        ivStoreLayUserImage.setImageResource(templateLayUserImage);
        tvStoreLayMusicTitle.setText(templateLayMusicTitle);
        tvStoreLayMain.setText(templateLayMain);
        tvStoreLaySub.setText(templateLaySub);
        ivStoreLayTeacherImage.setImageResource(templateLayTeacherImage);
        typedArray.recycle();
    }

    public void setCustomAttr(StoreDto dto){
        ivStoreLayUserImage.setImageResource(DebugImageMatch.getImageFromName(dto.getMusician()));
        tvStoreLayMusicTitle.setText(dto.getMusicTitle());
        tvStoreLayMain.setText(dto.getMain());
        tvStoreLaySub.setText(dto.getSub());
        ivStoreLayTeacherImage.setImageResource(DebugImageMatch.getImageFromName(dto.getOwner().getName()));
    }
}
