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
                Dummy Template1 : SurpriseSymphony
             */
            UserDto owner2 = dahyun;
            String musicTitle2 = getResources().getString(R.string.debug_haydn_music);
            String musician2 = getResources().getString(R.string.debug_haydn_name);
            String tMain2 = getResources().getString(R.string.debug_haydn_main);
            String tSub2 = getResources().getString(R.string.debug_haydn_sub);
            TemplateDto surpriseSymphony = new TemplateDto(owner2, musicTitle2, musician2, tMain2, tSub2);

            /**
             * insert notification data
             */
            ArrayList<NotificationDto> notifications = new ArrayList<>();
//            NotificationDto notification1 = new NotificationDto(true);

            session.setMainUser(mina);
//            session.setNotifications();
        }
    }
}
