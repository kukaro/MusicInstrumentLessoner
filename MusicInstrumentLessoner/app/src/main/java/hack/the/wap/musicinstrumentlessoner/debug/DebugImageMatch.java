package hack.the.wap.musicinstrumentlessoner.debug;

import hack.the.wap.musicinstrumentlessoner.R;

public class DebugImageMatch {
    public static int getImageFromStringIdName(int stringIdName) {
        switch (stringIdName) {
            case R.string.debug_aoa_choa_name:
                return R.drawable.choa_round;
            case R.string.debug_twice_dahyun_name:
                return R.drawable.dahyun_round;
            case R.string.nav_header_title:
                return R.drawable.mina;
            case R.string.debug_beethoven_name:
                return R.drawable.beethoven_round;
            case R.string.debug_haydn_name:
                return R.drawable.haydn_round;
            default:
                return R.drawable.logo_user_round;
        }
    }
}
