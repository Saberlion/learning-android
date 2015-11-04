package info.saberlion.zhihudaily.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Arthur on 2015/11/4.
 */
public class ToastUtils {
    Context mContext;

    private ToastUtils() {
    }

    public static void show(Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    public static void show(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }


}
