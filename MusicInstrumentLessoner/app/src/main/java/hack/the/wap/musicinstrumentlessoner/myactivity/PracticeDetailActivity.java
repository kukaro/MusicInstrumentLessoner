package hack.the.wap.musicinstrumentlessoner.myactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugImageMatch;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplatePracticeDto;
import hack.the.wap.musicinstrumentlessoner.myfragment.CustomWaveformFragment;
import hack.the.wap.musicinstrumentlessoner.myfragment.WrongFragment;
import hack.the.wap.musicinstrumentlessoner.session.PresentFile;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class PracticeDetailActivity extends AppCompatActivity implements WrongFragment.OnFragmentInteractionListener{
    private static Session session;
    private WrongFragment wrongFragment;
    private Fragment customWaveformFragment;
    private ImageView ivPracticeDetailLayLeftArrow;
    private TextView tvPracticeDetailLayName;
    private TextView tvPracticeDetailLayCount;
    private TextView tvPracticeDetailLayPercent;
    private TextView tvPracticeDetailLayFileName;
    private ImageView ivPracticeDetailLayTeacher;
    private ImageView ivPracticeDetailLayMusician;
    private Button btnPracticeDetailLaySwitch;

    private TemplatePracticeDto mainTemplatePractice;
    private TemplateDto mainTemplate;

    {
        session = Session.getInstance();
        wrongFragment = new WrongFragment();
        customWaveformFragment = new CustomWaveformFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practice_detail);
        Intent intent = getIntent();
        mainTemplatePractice = (TemplatePracticeDto) intent.getSerializableExtra("data");
        mainTemplate = (TemplateDto) intent.getSerializableExtra("main");
        Log.e("SAFE", "onCreate >>> " + mainTemplate);
        Log.e("SAFE", "onCreate >>> " + mainTemplatePractice);
        ivPracticeDetailLayLeftArrow = findViewById(R.id.ivPracticeDetailLayLeftArrow);
        tvPracticeDetailLayName = findViewById(R.id.tvPracticeDetailLayName);
        tvPracticeDetailLayCount = findViewById(R.id.tvPracticeDetailLayCount);
        tvPracticeDetailLayPercent = findViewById(R.id.tvPracticeDetailLayPercent);
        tvPracticeDetailLayFileName = findViewById(R.id.tvPracticeDetailLayFileName);
        ivPracticeDetailLayTeacher = findViewById(R.id.ivPracticeDetailLayTeacher);
        ivPracticeDetailLayMusician = findViewById(R.id.ivPracticeDetailLayMusician);
        btnPracticeDetailLaySwitch = findViewById(R.id.btnPracticeDetailLaySwitch);

        viewSetValue();
        viewSetListener();

        if (savedInstanceState == null) {
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.flPracticeFragment, customWaveformFragment);
            fragmentTransaction.commit();
//            getSupportFragmentManager().beginTransaction().add(R.id.flPracticeFragment, customWaveformFragment).commit();
        }

    }

    private void viewSetListener() {
        ivPracticeDetailLayLeftArrow.setOnClickListener(v -> {
            finish();
        });
        btnPracticeDetailLaySwitch.setOnClickListener(v -> {
            String sw = btnPracticeDetailLaySwitch.getText().toString();
            if(sw.equals(getResources().getString(R.string.btn_switch_guide))){
                Log.e("DEBUG", "viewSetListener: GOOD" );
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flPracticeFragment, wrongFragment);
                fragmentTransaction.commit();
                btnPracticeDetailLaySwitch.setText(R.string.btn_switch_music);
            }else if(sw.equals(getResources().getString(R.string.btn_switch_music))){
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.flPracticeFragment, customWaveformFragment);
                fragmentTransaction.commit();
                btnPracticeDetailLaySwitch.setText(R.string.btn_switch_guide);
            }
        });
    }

    private void viewSetValue() {
        ivPracticeDetailLayTeacher.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getOwner().getName()));
        ivPracticeDetailLayMusician.setImageResource(DebugImageMatch.getImageFromName(mainTemplate.getMusician()));
        tvPracticeDetailLayName.setText("" + mainTemplate.getMusicTitle());
        tvPracticeDetailLayCount.setText("" + getResources().getText(R.string.template_practice_lay_count) + mainTemplatePractice.getPracticeId());
        tvPracticeDetailLayPercent.setText("" + getResources().getText(R.string.template_practice_lay_percent) + mainTemplatePractice.getPercent() + getResources().getText(R.string.template_practice_lay_percent_end));
        tvPracticeDetailLayFileName.setText("" + getResources().getText(R.string.template_practice_lay_fileName_pre) + mainTemplatePractice.getFileName());
        btnPracticeDetailLaySwitch.setText(getResources().getText(R.string.btn_switch_guide));
        PresentFile.fileName = mainTemplatePractice.getFileName();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
