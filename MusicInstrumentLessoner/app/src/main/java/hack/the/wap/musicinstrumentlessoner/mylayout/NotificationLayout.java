package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;

/*
참고 사이트 : https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088
           http://gun0912.tistory.com/38
 */

public class NotificationLayout extends LinearLayout {
    private TextView tvNotificationLayName;
    private TextView tvNotificationLayDate;
    private TextView tvNotificationLayMain;
    private TextView tvNotificationLayMusicTitle;


    {
        initView();
    }

    public NotificationLayout(Context context) {
        super(context);
    }

    public NotificationLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public NotificationLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NotificationLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        inflate(getContext(), R.layout.notification_layout, this);
        tvNotificationLayName = findViewById(R.id.tvNotificationLayName);
        tvNotificationLayDate = findViewById(R.id.tvNotificationLayDate);
        tvNotificationLayMain = findViewById(R.id.tvNotificationLayMain);
        tvNotificationLayMusicTitle = findViewById(R.id.tvNotificationLayMusicTitle);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.NotificationLayout);
        Log.e("TAG", "getAttrs: "+typedArray);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attributeSet, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.NotificationLayout, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray){
        String notification_lay_name = typedArray.getString(R.styleable.NotificationLayout_notification_lay_name);
        String notification_lay_date = typedArray.getString(R.styleable.NotificationLayout_notification_lay_date);
        String notification_lay_main = typedArray.getString(R.styleable.NotificationLayout_notification_lay_main);
        String notification_lay_music_title = typedArray.getString(R.styleable.NotificationLayout_notification_lay_music_title);
        tvNotificationLayName.setText(notification_lay_name);
        tvNotificationLayDate.setText(notification_lay_date);
        tvNotificationLayMain.setText(notification_lay_main);
        tvNotificationLayMusicTitle.setText(notification_lay_music_title);
        typedArray.recycle();
    }
}
