package info.saberlion.v2ex.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import info.saberlion.Models.V2exBaseModel;
import info.saberlion.Models.V2exTopicReplyModel;
import info.saberlion.v2exme.R;

/**
 * Created by shirley on 15/10/24.
 */
public class NodeTopicInfoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<?> list;
    private V2exBaseModel v2exBaseModel;

    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private LruCache<String, Bitmap> imageCache;

    private class ViewHolder{
        TextView nodeTopicTitleTextView;
        TextView topicInfoRepliesNumTextView;
        TextView topicInfoUserNameTextView;
        TextView topicInfoNodeNameTextView;
        TextView contentInfoTextView;
        NetworkImageView imageView;
        TextView userNameTextView;
        TextView contentTextView;
    }


    public NodeTopicInfoAdapter(Context context, V2exBaseModel v2exBaseModel) {

        this.context = context;
        this.v2exBaseModel = v2exBaseModel;

        requestQueue = Volley.newRequestQueue(context);

        imageCache = new LruCache<String, Bitmap>(200);

        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return imageCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                imageCache.put(url, bitmap);
            }
        });
    }

    @Override
    public int getCount() {
        return 2 + list.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            if (getItemViewType(position) == 0) {

                view = LayoutInflater.from(context).inflate(R.layout.content_topic_head_item, parent, false);

                viewHolder.nodeTopicTitleTextView = (TextView) view.findViewById(R.id.topic_info_title_text_view);

                viewHolder.imageView = (NetworkImageView) view.findViewById(R.id.topic_avatar_image_view);

                viewHolder.topicInfoNodeNameTextView = (TextView) view.findViewById(R.id.topic_info_node_name_text_view);


                viewHolder.topicInfoRepliesNumTextView = (TextView) view.findViewById(R.id.topic_info_replies_num);

                viewHolder.topicInfoUserNameTextView= (TextView) view.findViewById(R.id.topic_info_user_name_title);

            } else if (getItemViewType(position) == 1) {

                view = LayoutInflater.from(context).inflate(R.layout.content_topic_content_info, parent, false);

                viewHolder. contentInfoTextView = (TextView) view.findViewById(R.id.topic_info_content_info_text_view);

            } else {//getItemViewType(position) == 2

                view = LayoutInflater.from(context).inflate(R.layout.content_topic_reply, parent, false);

                int index = position - 2;
                V2exTopicReplyModel v2exTopicReplyModel = (V2exTopicReplyModel)list.get(index);

                if (v2exTopicReplyModel != null) {

                    viewHolder.imageView = (NetworkImageView) view.findViewById(R.id.content_topic_reply_avatar_image_view);

                    viewHolder.userNameTextView = (TextView) view.findViewById(R.id.content_topic_reply_user_name_text_view);

                    viewHolder.contentTextView = (TextView) view.findViewById(R.id.content_topic_reply_content_text_view);

                }


            }
            view.setTag(viewHolder);
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();

        }


        if (getItemViewType(position) == 0) {
            if (viewHolder.nodeTopicTitleTextView != null) {
                viewHolder.nodeTopicTitleTextView.setTypeface(null, Typeface.BOLD);
                viewHolder.nodeTopicTitleTextView.setText(v2exBaseModel.title);
            }
            if (viewHolder.imageView != null) {

                viewHolder.imageView.setImageUrl("https:" + v2exBaseModel.memberModel.avatar_large, imageLoader);
            }

            if (viewHolder.topicInfoNodeNameTextView != null) {

                viewHolder.topicInfoNodeNameTextView.setText(v2exBaseModel.nodeModel.title);
                viewHolder.topicInfoNodeNameTextView.setTypeface(null, Typeface.BOLD);
            }

            if (viewHolder.topicInfoRepliesNumTextView != null) {
                viewHolder.topicInfoRepliesNumTextView.setText(v2exBaseModel.replies);
            }

            if (viewHolder.topicInfoUserNameTextView != null) {
                viewHolder.topicInfoUserNameTextView.setTypeface(null, Typeface.BOLD);
                viewHolder.topicInfoUserNameTextView.setText("@" + v2exBaseModel.memberModel.username);
            }
        } else if (getItemViewType(position) == 1) {

            if (viewHolder. contentInfoTextView != null) {

                viewHolder. contentInfoTextView.setText(v2exBaseModel.content);
            }
        } else {//getItemViewType(position) == 2

            int index = position - 2;
            V2exTopicReplyModel v2exTopicReplyModel = (V2exTopicReplyModel)list.get(index);
            if (v2exTopicReplyModel != null) {
                if (viewHolder.imageView != null) {
                    viewHolder.imageView.setImageUrl("https:" + v2exTopicReplyModel.memberModel.avatar_large, imageLoader);
                }
                if (viewHolder.userNameTextView != null) {
                    viewHolder.userNameTextView.setText("@" + v2exTopicReplyModel.memberModel.username + "#"+ index);
                    viewHolder.userNameTextView.setTypeface(null, Typeface.BOLD);
                }

                if (viewHolder.contentTextView != null) {

                    viewHolder.contentTextView.setText(v2exTopicReplyModel.content);
                }
            }


        }
        return view;
    }

    public void setDataList(ArrayList<?> list) {

        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) return 0;
        else if (position == 1) return 1;
        return 2;
    }
}
