package info.saberlion.zhihudaily.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.android.volley.RequestQueue;

/**
 * Created by Arthur on 2015/10/29.
 */

public class ContextListFrapment extends Fragment {


    SwipeRefreshLayout swipeRefreshLayout;

    ContextListAdapter adapter;

    RequestQueue mRequestQueue;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
