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
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;

/*
참고 사이트 : https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088
           http://gun0912.tistory.com/38
 */

public class TemplatePracticeLayout extends LinearLayout {

    {
        initView();
    }

    public TemplatePracticeLayout(Context context) {
        super(context);
    }

    public TemplatePracticeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public TemplatePracticeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TemplatePracticeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        inflate(getContext(), R.layout.template_practice_layout, this);
    }

    private void getAttrs(AttributeSet attributeSet) {
//        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TemplateLayout);
//        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attributeSet, int defStyle) {
//        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TemplateLayout, defStyle, 0);
//        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {

    }

    public void setCustomAttr(TemplateDto dto){

    }
}
