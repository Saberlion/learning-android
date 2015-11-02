package info.saberlion.zhihudaily.ui;

import android.support.v7.widget.RecyclerView;
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
import info.saberlion.zhihudaily.model.ListItem;
import info.saberlion.zhihudaily.net.NetController;

/**
 * Created by Arthur on 2015/10/29.
 */
public class ContextListAdapter extends RecyclerView.Adapter<ContextListAdapter.ViewHolder> {

    List<ListItem> items = new ArrayList<ListItem>();
    RequestQueue requestQueue = NetController.getInstance().getRequestQueue();
    ImageLoader imageLoader = NetController.getInstance().getImageLoader();
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


        }

        @Override
        public void onClick(View v) {

        }
    }
}
