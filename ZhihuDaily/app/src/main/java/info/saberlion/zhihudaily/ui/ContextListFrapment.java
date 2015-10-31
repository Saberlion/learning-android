package info.saberlion.zhihudaily.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.android.volley.RequestQueue;

import info.saberlion.zhihudaily.model.ListItem;
import info.saberlion.zhihudaily.net.NetController;

/**
 * Created by Arthur on 2015/10/29.
 */

public class ContextListFrapment extends Fragment {

    final static String TAG = ContextListFrapment.class.getName();

    SwipeRefreshLayout swipeRefreshLayout;

    ContextListAdapter adapter;

    RequestQueue mRequestQueue = NetController.getInstance().getRequestQueue();

    DatePagerAdapter datePagerAdapter;

    public static Fragment newInstance(Context context, ListItem listItem, String timeSpan) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_language", listItem);
        bundle.putSerializable("extra_time_span", timeSpan);
        return Fragment.instantiate(context, ContextListFrapment.class.getName(), bundle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }
}
