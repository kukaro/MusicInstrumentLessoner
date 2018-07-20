package hack.the.wap.musicinstrumentlessoner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
    private static LoginActivity instance;
    private static ImageView iv;

    /*
        init block
     */
    {
        instance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv = findViewById(R.id.ivLogin);
        iv.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.getInstance(), MainActivity.class);
            intent.putExtra("login", "success");
            startActivity(intent);
            finish();
        });
    }

    public static LoginActivity getInstance() {
        return instance;
    }
}
