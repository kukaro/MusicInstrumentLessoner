package hack.the.wap.musicinstrumentlessoner.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class GuideActivity extends AppCompatActivity {
    private static GuideActivity instance;
    private static Session session;
    private TemplateDto mainTemplate;
    private ImageView ivGuideActLeftArrow;
    private ImageView ivGuideActTeacher;
    private ImageView ivGuideActMusician;
    private TextView tvGuideActTeacherName;
    private TextView tvGuideActMusicName;

    {
        session = Session.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ivGuideActLeftArrow = findViewById(R.id.ivGuideActLeftArrow);
        ivGuideActTeacher = findViewById(R.id.ivGuideActTeacher);
        ivGuideActMusician = findViewById(R.id.ivGuideActMusician);
        tvGuideActTeacherName = findViewById(R.id.tvGuideActTeacherName);
        tvGuideActMusicName = findViewById(R.id.tvGuideActMusicName);

        instance = this;

        Intent intent = getIntent();
        mainTemplate = (TemplateDto) intent.getSerializableExtra("main");
        Log.e("SAFE", "onCreate >>> " + mainTemplate);

        viewSetListener();
        viewSetValue();
    }

    private void viewSetListener() {
        ivGuideActLeftArrow.setOnClickListener(v -> {
            finish();
        });
    }

    private void viewSetValue() {
        ivGuideActTeacher.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getOwner().getName()));
        ivGuideActMusician.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getMusician()));
        tvGuideActTeacherName.setText(mainTemplate.getOwner().getName());
        tvGuideActMusicName.setText(mainTemplate.getMusicTitle());
    }

    public GuideActivity getInstance() {
        return instance;
    }
}
