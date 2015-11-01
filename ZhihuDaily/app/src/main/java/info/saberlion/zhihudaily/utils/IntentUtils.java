package info.saberlion.zhihudaily.utils;

import android.content.Context;
import android.content.Intent;

import info.saberlion.zhihudaily.ui.AboutActivity;
import info.saberlion.zhihudaily.ui.MainActivity;

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
