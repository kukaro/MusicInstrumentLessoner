package hack.the.wap.musicinstrumentlessoner.mylayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import hack.the.wap.musicinstrumentlessoner.R;

/*
참고 사이트 : https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088
 */

public class NotificationLayout extends LinearLayout {

    {
        inflate(getContext(), R.layout.notification_layout,this);
    }

    public NotificationLayout(Context context) {
        super(context);
    }

    public NotificationLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NotificationLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NotificationLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
