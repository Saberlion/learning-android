package info.saberlion.zhihudaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView textView = (TextView) findViewById(R.id.about_textview);
        textView.setText(Html.fromHtml("It's a demo with Material Design.<br>" +
                "https://github.com/trending"));
    }
}
