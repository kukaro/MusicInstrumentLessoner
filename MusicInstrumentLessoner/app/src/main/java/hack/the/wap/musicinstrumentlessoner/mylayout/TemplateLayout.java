package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;

/*
참고 사이트 : https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088
           http://gun0912.tistory.com/38
 */

public class TemplateLayout extends LinearLayout {
    private ImageView ivTemplateLayUserImage;
    private TextView tvTemplateLayMusicTitle;
    private TextView tvTemplateLayMain;
    private TextView tvTemplateLaySub;

    {
        initView();
    }

    public TemplateLayout(Context context) {
        super(context);
    }

    public TemplateLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public TemplateLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TemplateLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        inflate(getContext(), R.layout.template_layout, this);
        ivTemplateLayUserImage = findViewById(R.id.ivTemplateUserImage);
        tvTemplateLayMusicTitle = findViewById(R.id.tvTemplateLayMusicTitle);
        tvTemplateLayMain = findViewById(R.id.tvTemplateLayMain);
        tvTemplateLaySub= findViewById(R.id.tvTemplateLaySub);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TemplateLayout);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attributeSet, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TemplateLayout, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        int TemplateLayUserImage = typedArray.getResourceId(R.styleable.TemplateLayout_template_lay_user_image, R.drawable.choa_round);
        String TemplateLayMusicTitle = typedArray.getString(R.styleable.TemplateLayout_template_lay_music_title);
        String TemplateLayMain = typedArray.getString(R.styleable.TemplateLayout_template_lay_main);
        String TemplateLaySub = typedArray.getString(R.styleable.TemplateLayout_template_lay_sub);
        ivTemplateLayUserImage.setImageResource(TemplateLayUserImage);
        tvTemplateLayMusicTitle.setText(TemplateLayMusicTitle);
        tvTemplateLayMain.setText(TemplateLayMain);
        tvTemplateLaySub.setText(TemplateLaySub);
        typedArray.recycle();
    }
}
