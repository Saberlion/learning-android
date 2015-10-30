package info.saberlion.zhihudaily.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< .merge_file_a06248
import info.saberlion.zhihudaily.R;
=======
import java.util.List;

import info.saberlion.zhihudaily.R;
import info.saberlion.zhihudaily.model.ListItem;
>>>>>>> .merge_file_a01248

/**
 * Created by Arthur on 2015/10/29.
 */
public class ContextListAdapter extends RecyclerView.Adapter<ContextListAdapter.ViewHolder> {

<<<<<<< .merge_file_a06248
=======
    List<ListItem> items;
>>>>>>> .merge_file_a01248
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
<<<<<<< .merge_file_a06248
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
=======
        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
>>>>>>> .merge_file_a01248
        private final ImageView imageView;
        private final TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.pic);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
<<<<<<< .merge_file_a06248
=======

        @Override
        public void onClick(View v) {

        }
>>>>>>> .merge_file_a01248
    }
}
