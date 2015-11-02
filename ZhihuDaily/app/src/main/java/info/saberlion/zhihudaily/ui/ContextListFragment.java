package info.saberlion.zhihudaily.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import java.util.ArrayList;
import java.util.List;

import info.saberlion.zhihudaily.R;
import info.saberlion.zhihudaily.api.ZhihuApi;
import info.saberlion.zhihudaily.model.DailyList;
import info.saberlion.zhihudaily.model.ListItem;
import info.saberlion.zhihudaily.net.GsonRequest;
import info.saberlion.zhihudaily.net.NetController;

/**
 * Created by Arthur on 2015/10/29.
 */

public class ContextListFragment extends Fragment {

    final static String TAG = "ContextListFragment";

    private List<ListItem> mNewsList = new ArrayList<>();

    SwipeRefreshLayout swipeRefreshLayout;

    ContextListAdapter mContextListAdapter;

    RequestQueue mRequestQueue;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = NetController.getInstance().getRequestQueue();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipe_refresh_layout,container,false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        //       swipeRefreshLayout.setOnRefreshListener(this);
        mContextListAdapter = new ContextListAdapter();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mContextListAdapter);


        GsonRequest<DailyList> request = new GsonRequest<DailyList>(ZhihuApi.getDailyNews("20151101"),DailyList.class,
                new Response.Listener<DailyList>() {
                    @Override
                    public void onResponse(DailyList response) {
                        Log.d(TAG,response.toString());
                        mNewsList=response.stories;
                        mContextListAdapter.setItems(response.stories);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                    }
                });

        mRequestQueue.add(request);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
