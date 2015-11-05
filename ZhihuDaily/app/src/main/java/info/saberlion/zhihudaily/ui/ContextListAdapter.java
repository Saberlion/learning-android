package info.saberlion.zhihudaily.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

import info.saberlion.zhihudaily.R;
import info.saberlion.zhihudaily.api.ZhihuApi;
import info.saberlion.zhihudaily.model.ListItem;
import info.saberlion.zhihudaily.net.NetController;
import info.saberlion.zhihudaily.utils.IntentUtils;

/**
 * Created by Arthur on 2015/10/29.
 */
public class ContextListAdapter extends RecyclerView.Adapter<ContextListAdapter.ViewHolder> {


    final static String TAG = ContextListAdapter.class.getName();

    Context mContext;

    List<ListItem> items = new ArrayList<>();

    RequestQueue requestQueue = NetController.getInstance().getRequestQueue();

    ImageLoader imageLoader = NetController.getInstance().getImageLoader();

    public ContextListAdapter(Context mContext) {
        this.mContext = mContext;
    }


    public void setItems(List<ListItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem item = items.get(position);
        holder.setItem(item);
        holder.imageView.setImageUrl(item.images.get(0), imageLoader);
        holder.textView.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        private final NetworkImageView imageView;
        private final TextView textView;
        public void setItem(ListItem item) {
            this.item = item;
        }

        private ListItem item;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.pic);
            textView = (TextView) itemView.findViewById(R.id.title);
            imageView.setOnClickListener(this);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG,"onClick"+v.getId());
            switch (v.getId()) {
                case R.id.pic:

                case R.id.title:
                    String topic_title = item.title;
                    String openUrl = ZhihuApi.getNewsContent(item.id);
                    IntentUtils.openWebView(v.getContext(),topic_title,openUrl);
                    break;

            }
        }
    }
}
