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

public class TemplateDetailActivity extends AppCompatActivity {
    private TemplateDto mainTemplate;
    private ImageView ivTemplateDetailLayLeftArrow;
    private ImageView ivTemplateDetailLayTeacher;
    private ImageView ivTemplateDetailLayMusician;
    private TextView tvTemplateDetailLayName;
    private TextView tvTemplateDetailLayMusicianName;
    private TextView tvTemplateDetailLayTeacherNameSlot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_detail);

        ivTemplateDetailLayLeftArrow = findViewById(R.id.ivTemplateDetailLayLeftArrow);
        ivTemplateDetailLayTeacher = findViewById(R.id.ivTemplateDetailLayTeacher);
        ivTemplateDetailLayMusician = findViewById(R.id.ivTemplateDetailLayMusician);
        tvTemplateDetailLayName = findViewById(R.id.tvTemplateDetailLayName);
        tvTemplateDetailLayMusicianName = findViewById(R.id.tvTemplateDetailLayMusicianName);
        tvTemplateDetailLayTeacherNameSlot = findViewById(R.id.tvTemplateDetailLayTeacherNameSlot);

        Intent intent = getIntent();
        mainTemplate = (TemplateDto) intent.getSerializableExtra("data");
        Log.e("SAFE", "onCreate >>> " + mainTemplate);

        ivTemplateDetailLayTeacher.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getOwner().getName()));
        ivTemplateDetailLayMusician.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getMusician()));
        tvTemplateDetailLayName.setText(mainTemplate.getMusicTitle());
        tvTemplateDetailLayMusicianName.setText(mainTemplate.getMusician());
        tvTemplateDetailLayTeacherNameSlot.setText(getResources().getString(R.string.tempalte_detail_act_teacher_pre)
                + mainTemplate.getOwner().getName());

        viewSetListener();
    }

    private void viewSetListener(){
        ivTemplateDetailLayLeftArrow.setOnClickListener(v->{
            finish();
        });
    }
}
