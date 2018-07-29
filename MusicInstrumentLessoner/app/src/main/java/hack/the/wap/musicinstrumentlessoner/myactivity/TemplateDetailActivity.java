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

import java.io.File;
import java.util.ArrayList;

import cafe.adriel.androidaudioconverter.AndroidAudioConverter;
import cafe.adriel.androidaudioconverter.callback.IConvertCallback;
import cafe.adriel.androidaudioconverter.model.AudioFormat;
import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;
import cafe.adriel.androidaudiorecorder.model.AudioChannel;
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate;
import cafe.adriel.androidaudiorecorder.model.AudioSource;
import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplatePracticeDto;
import hack.the.wap.musicinstrumentlessoner.myfragment.TemplateFragment;
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

    /*
        Global Instance
     */
    private int curPractice;
    private String curFile;
    private String rootDir;
    private String filePath;

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
                atom.setOnClickListener(v -> {
                    rootDir = mkdir(dto);
                    filePath = rootDir + "/recorded_audio.wav";
                    int requestCode = 0;
                    curPractice = dto.getPracticeId();
                    curFile = filePath;
                    AndroidAudioRecorder.with(this)
                            // Required
                            .setFilePath(filePath)
                            .setColor(R.color.colorPrimaryDark)
                            .setRequestCode(requestCode)

                            // Optional
                            .setSource(AudioSource.MIC)
                            .setChannel(AudioChannel.STEREO)
                            .setSampleRate(AudioSampleRate.HZ_48000)
                            .setAutoStart(true)
                            .setKeepDisplayOn(true)

                            // Start recording
                            .record();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                TemplatePracticeDto dto = new TemplatePracticeDto(curPractice, curFile);
                mainTemplate.getTemplatePractices().set(curPractice, dto);
                AndroidAudioConverter.with(this)
                        .setFile(new File(filePath))
                        .setFormat(AudioFormat.MP3)
                        .setCallback(new IConvertCallback() {
                            @Override
                            public void onSuccess(File file) {
                                dto.setFileName(file.getAbsolutePath());
                                Log.e("TAG", "onSuccess: "+file.getAbsolutePath() );
                            }

                            @Override
                            public void onFailure(Exception e) {
                                e.printStackTrace();
                            }
                        })
                        .convert();

                session.getTemplates().get(mainTemplate.getMusicTitle()).getTemplatePractices().set(curPractice - 1, dto);
                session.showAllSession();
            } else if (resultCode == RESULT_CANCELED) {
                // Oops! User has canceled the recording
            }
        }
    }

    private String mkdir(TemplatePracticeDto dto) {
        File dir = new File(getResources().getString(R.string.file_default_dir) + mainTemplate.getMusicTitle());
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        dir = new File(getResources().getString(R.string.file_default_dir) + mainTemplate.getMusicTitle() + "/" + dto.getPracticeId());
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        return getResources().getString(R.string.file_default_dir) + mainTemplate.getMusicTitle() + "/" + dto.getPracticeId();
    }

}
