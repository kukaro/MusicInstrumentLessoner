package hack.the.wap.musicinstrumentlessoner.myactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class GuideActivity extends AppCompatActivity {
    private static GuideActivity instance;
    private static Session session;
    private TemplateDto mainTemplate;
    private ImageView ivGuideActLeftArrow;

    {
        session = Session.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ivGuideActLeftArrow = findViewById(R.id.ivGuideActLeftArrow);

        instance = this;

        Intent intent = getIntent();
        mainTemplate = (TemplateDto) intent.getSerializableExtra("data");
        Log.e("SAFE", "onCreate >>> " + mainTemplate);

        viewSetListener();
    }

    private void viewSetListener() {
        ivGuideActLeftArrow.setOnClickListener(v -> {
            finish();
        });
    }

    public GuideActivity getInstance(){
        return instance;
    }
}
