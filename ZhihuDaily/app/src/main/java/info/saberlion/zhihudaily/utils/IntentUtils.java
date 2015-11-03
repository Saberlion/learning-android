package info.saberlion.zhihudaily.utils;

import android.content.Context;
import android.content.Intent;

import info.saberlion.zhihudaily.ui.AboutActivity;
import info.saberlion.zhihudaily.ui.MainActivity;
import info.saberlion.zhihudaily.ui.WebviewActivity;

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

    public static void openWebView(Context context,String title,String url){
        Intent intent = new Intent(context,WebviewActivity.class);
        intent.putExtra(WebviewActivity.EXTRA_TITLE, title);
        intent.putExtra(WebviewActivity.EXTRA_URL, url);
        context.startActivity(intent);
    }
}
