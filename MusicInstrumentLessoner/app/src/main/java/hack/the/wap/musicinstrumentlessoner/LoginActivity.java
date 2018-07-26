package hack.the.wap.musicinstrumentlessoner;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import hack.the.wap.musicinstrumentlessoner.debug.DebugMode;
import hack.the.wap.musicinstrumentlessoner.model.dto.NotificationDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserDto;
import hack.the.wap.musicinstrumentlessoner.session.Session;

public class LoginActivity extends AppCompatActivity {
    private static LoginActivity instance;
    private static ImageView ivLogin;
    private static EditText etEmail;
    private static EditText etPassword;
    private static Session session;

    /*
     init block
     */ {
        instance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        ivLogin = findViewById(R.id.ivLogin);
        ivLogin.setOnClickListener(v -> {
            String name = loginProcess(etEmail.getText().toString(), etPassword.getText().toString());
            if (name != null) {
                Intent intent = new Intent(LoginActivity.getInstance(), MainActivity.class);
                intent.putExtra("actLoginName", name);
                intent.putExtra("actLoginEmail", etEmail.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * @param email
     * @param password
     * @return If you success login then return is name. Otherwise, it is null.
     */
    public String loginProcess(String email, String password) {
        setSession();
        return getResources().getString(R.string.nav_header_title);
    }

    public static LoginActivity getInstance() {
        return instance;
    }

    public void setSession() {
        session = Session.getInstance();
        DEBUG_SET_SESSION();
    }


    private void DEBUG_SET_SESSION() {
        if (DebugMode.DEBUG_MOD) {

            /*
                Debug : All users password
             */
            String password = "1234";

            /*
                insert user data
             */
            String name = getResources().getString(R.string.nav_header_title);
            String email = getResources().getString(R.string.nav_header_subtitle);
            UserDto mina = new UserDto(name, email, password);

            /*
                Dummy User1 : Choa
             */
            String name1 = getResources().getString(R.string.debug_aoa_choa_name);
            String email1 = getResources().getString(R.string.debug_aoa_choa_email);
            UserDto choa = new UserDto(name1, email1, password);

            /*
                Dummy User2 : Dahyun
             */
            String name2 = getResources().getString(R.string.debug_twice_dahyun_name);
            String email2 = getResources().getString(R.string.debug_twice_dahyun_emai);
            UserDto dahyun = new UserDto(name2, email2, password);

            /*
                Dummy Template1 : Moonlight3rd
             */
            UserDto owner1 = choa;
            String musicTitle1 = getResources().getString(R.string.debug_beethoven_music);
            String musician1 = getResources().getString(R.string.debug_beethoven_name);
            String tMain1 = getResources().getString(R.string.debug_beethoven_main);
            String tSub1 = getResources().getString(R.string.debug_beethoven_sub);
            TemplateDto moonlight3rd = new TemplateDto(owner1, musicTitle1, musician1, tMain1, tSub1);

             /*
                Dummy Template2 : SurpriseSymphony
             */
            UserDto owner2 = dahyun;
            String musicTitle2 = getResources().getString(R.string.debug_haydn_music);
            String musician2 = getResources().getString(R.string.debug_haydn_name);
            String tMain2 = getResources().getString(R.string.debug_haydn_main);
            String tSub2 = getResources().getString(R.string.debug_haydn_sub);
            TemplateDto surpriseSymphony = new TemplateDto(owner2, musicTitle2, musician2, tMain2, tSub2);
            
            /*
                Dummy Template3 : CzernyNo95
             */
            UserDto owner3 = choa;
            String musicTitle3 = getResources().getString(R.string.debug_czerny_music);
            String musician3 = getResources().getString(R.string.debug_czerny_name);
            String tMain3 = getResources().getString(R.string.debug_czerny_main);
            String tSub3 = getResources().getString(R.string.debug_czerny_sub);
            TemplateDto czernyNo95 = new TemplateDto(owner3, musicTitle3, musician3, tMain3, tSub3);
            
            /*
                Dummy Template4 : Canon
             */
            UserDto owner4 = choa;
            String musicTitle4 = getResources().getString(R.string.debug_pachelbel_music);
            String musician4 = getResources().getString(R.string.debug_pachelbel_name);
            String tMain4 = getResources().getString(R.string.debug_pachelbel_main);
            String tSub4 = getResources().getString(R.string.debug_pachelbel_sub);
            TemplateDto canon = new TemplateDto(owner4, musicTitle4, musician4, tMain4, tSub4);

            /*
                Dummy Notification1 : not1
             */
            boolean trueUser1 = true;
            TemplateDto template1 = moonlight3rd;
            String nMain1 = getResources().getString(R.string.teacher_upload_music);
            String nDate1 = getResources().getString(R.string.debug_aoa_choa_date1);
            NotificationDto not1 = new NotificationDto(trueUser1, template1, nMain1, nDate1);
            
            /*
                Dummy Notification2 : not2
            */
            boolean trueUser2 = false;
            TemplateDto template2 = czernyNo95;
            String nMain2 = getResources().getString(R.string.debug_mi_main);
            String nDate2 = getResources().getString(R.string.debug_mi_date1);
            NotificationDto not2 = new NotificationDto(trueUser2, template2, nMain2, nDate2);
            
            /*
                Dummy Notification3 : not3
            */
            boolean trueUser3 = true;
            TemplateDto template3 = canon;
            String nMain3 = getResources().getString(R.string.friend_complete_music);
            String nDate3 = getResources().getString(R.string.debug_twice_dahyun_date1);
            NotificationDto not3 = new NotificationDto(trueUser3, template3, nMain3, nDate3);

            /*
                Insert Template data
             */
            ArrayList<TemplateDto> templates = new ArrayList<>();
            templates.add(moonlight3rd);
            templates.add(surpriseSymphony);
            templates.add(czernyNo95);
            templates.add(canon);

            /**
             * insert notification data
             */
            ArrayList<NotificationDto> notifications = new ArrayList<>();
            notifications.add(not1);
            notifications.add(not2);
            notifications.add(not3);

            session.setMainUser(mina);
            session.setTemplates(templates);
            session.setNotifications(notifications);
        }
    }
}
