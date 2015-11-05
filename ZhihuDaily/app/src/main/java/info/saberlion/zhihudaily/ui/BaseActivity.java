package info.saberlion.zhihudaily.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Arthur on 2015/11/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    abstract protected int provideContentViewId();

    public static String TAG;

    private Context mContext;

    public Context getmContext() {
        return mContext;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
    }
}
