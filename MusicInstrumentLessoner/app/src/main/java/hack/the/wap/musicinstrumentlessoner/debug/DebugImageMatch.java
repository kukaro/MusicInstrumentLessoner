package hack.the.wap.musicinstrumentlessoner.debug;

import android.support.v7.app.AppCompatActivity;

import hack.the.wap.musicinstrumentlessoner.R;

public class DebugImageMatch extends AppCompatActivity{
    public static DebugImageMatch instance;

    private DebugImageMatch() {

    }

    public static int getImageFromName(String stringName) {
        switch (stringName) {
            case "AOA Choa":
                return R.drawable.choa_round;
            case "Twice Dahyun":
                return R.drawable.dahyun_round;
            case "GirlsDay mina":
                return R.drawable.mina;
            case "Beethoven":
                return R.drawable.beethoven_round;
            case "Segyong":
                return R.drawable.segyong_round;
            case "Gain":
                return R.drawable.gain_round;
            case "Hyoju":
                return R.drawable.hyoju_round;
            case "Kanna":
                return R.drawable.kanna_round;
            case "Haydn":
                return R.drawable.haydn_round;
            case "피아노리브레 강남센터":
                return R.drawable.music_place_round;
            case "SMMA아카데미":
                return R.drawable.kanna_round;
            default:
                return R.drawable.logo_user_round;
        }
    }
}
