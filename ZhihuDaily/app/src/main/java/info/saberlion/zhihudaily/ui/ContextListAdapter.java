package info.saberlion.zhihudaily.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import info.saberlion.zhihudaily.R;

/**
 * Created by Arthur on 2015/10/29.
 */
public class ContextListAdapter extends RecyclerView.Adapter<ContextListAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pic);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
