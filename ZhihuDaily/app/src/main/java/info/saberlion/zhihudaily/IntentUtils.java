package info.saberlion.zhihudaily;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Arthur on 2015/10/29.
 */
public class IntentUtils {
    public static void openMain(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    public static void openAbout(Context context){
        Intent intent = new Intent(context,AboutActivity.class);
        context.startActivity(intent);
    }
}
