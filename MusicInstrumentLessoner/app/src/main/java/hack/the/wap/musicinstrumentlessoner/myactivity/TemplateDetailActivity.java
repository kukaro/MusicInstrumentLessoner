package hack.the.wap.musicinstrumentlessoner.myactivity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplatePracticeDto;
import hack.the.wap.musicinstrumentlessoner.mylayout.TemplateNegativePracticeLayout;
import hack.the.wap.musicinstrumentlessoner.mylayout.TemplatePositivePracticeLayout;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class TemplateDetailActivity extends AppCompatActivity {
    private static Session session;
    private TemplateDetailActivity instance;
    private ArrayList<TemplatePracticeDto> templatePractices;
    private TemplateDto mainTemplate;
    private ImageView ivTemplateDetailLayLeftArrow;
    private ImageView ivTemplateDetailLayTeacher;
    private ImageView ivTemplateDetailLayMusician;
    private TextView tvTemplateDetailLayName;
    private TextView tvTemplateDetailLayMusicianName;
    private TextView tvTemplateDetailLayTeacherNameSlot;
    private LinearLayout llActTemplateDetail;

    {
        session = Session.getInstance();
    }

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
        llActTemplateDetail = findViewById(R.id.llActTemplateDetail);
        instance = this;

        Intent intent = getIntent();
        mainTemplate = (TemplateDto) intent.getSerializableExtra("data");
        Log.e("SAFE", "onCreate >>> " + mainTemplate);

        ivTemplateDetailLayTeacher.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getOwner().getName()));
        ivTemplateDetailLayMusician.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getMusician()));
        tvTemplateDetailLayName.setText(mainTemplate.getMusicTitle());
        tvTemplateDetailLayMusicianName.setText(mainTemplate.getMusician());
        tvTemplateDetailLayTeacherNameSlot.setText(getResources().getString(R.string.tempalte_detail_act_teacher_pre) + mainTemplate.getOwner().getName());

        templatePractices = mainTemplate.getTemplatePractices();
        for (TemplatePracticeDto dto : templatePractices) {
            if (dto.getFileName() != null) {
                TemplatePositivePracticeLayout atom = new TemplatePositivePracticeLayout(this);
                atom.setCustomAttr(dto);
                atom.setOnClickListener(v -> {
                    Intent posIntent = new Intent(this, PracticeDetailActivity.class);
                    posIntent.putExtra("data", dto);
                    posIntent.putExtra("main", mainTemplate);
                    startActivity(posIntent);
                });
                llActTemplateDetail.addView(atom);
            } else {
                TemplateNegativePracticeLayout atom = new TemplateNegativePracticeLayout(this);
                atom.setCustomAttr(dto);
                atom.setOnClickListener(v->{
                    makeRecordDialog();
                });
                llActTemplateDetail.addView(atom);
            }
        }

        viewSetListener();
    }

    private void viewSetListener() {
        ivTemplateDetailLayLeftArrow.setOnClickListener(v -> {
            finish();
        });
    }

    private void makeRecordDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_record_layout,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
