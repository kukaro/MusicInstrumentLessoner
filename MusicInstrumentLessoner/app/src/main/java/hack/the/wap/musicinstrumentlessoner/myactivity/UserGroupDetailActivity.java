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
import hack.the.wap.musicinstrumentlessoner.model.dto.UserGroupDto;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class UserGroupDetailActivity extends AppCompatActivity {
    private static Session session;
    private UserGroupDto mainUserGroup;
    private ImageView ivActUserGroupDetailLeftArrow;
    private ImageView ivActUserGroupDetailMusicPlace;
    private TextView tvActUserGroupDetailName;
    private TextView tvActUserGroupDetailMain;
    private TextView tvActUserGroupDetailSub;


    {
        session = Session.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_group_detail);
        Intent intent = getIntent();
        mainUserGroup = (UserGroupDto) intent.getSerializableExtra("data");
        Log.e("SAFE", "onCreate >>> " + mainUserGroup);

        ivActUserGroupDetailLeftArrow = findViewById(R.id.ivActUserGroupDetailLeftArrow);
        ivActUserGroupDetailMusicPlace = findViewById(R.id.ivActUserGroupDetailMusicPlace);
        tvActUserGroupDetailName = findViewById(R.id.tvActUserGroupDetailName);
        tvActUserGroupDetailMain = findViewById(R.id.tvActUserGroupDetailMain);
        tvActUserGroupDetailSub = findViewById(R.id.tvActUserGroupDetailSub);

        viewSetListener();
        viewSetValue();
    }

    private void viewSetListener(){
        ivActUserGroupDetailLeftArrow.setOnClickListener(v->{
            finish();
        });
    }

    private void viewSetValue(){
        ivActUserGroupDetailMusicPlace.setImageResource(DebugImageMatch.getImageFromName(mainUserGroup.getName()));
        tvActUserGroupDetailName.setText(mainUserGroup.getName());
    }
}
