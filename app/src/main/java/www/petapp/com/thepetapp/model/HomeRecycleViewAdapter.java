package www.petapp.com.thepetapp.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import www.petapp.com.thepetapp.R;

public class HomeRecycleViewAdapter extends RecyclerView.Adapter<HomeRecycleViewAdapter.ViewHolder> {

    private List<Integer> images;
    private List<String> texts;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.home_recycleview_image);
            mTextView = itemView.findViewById(R.id.home_recycleview_text);
        }
    }

    public HomeRecycleViewAdapter(List<Integer> images, List<String> texts) {
        this.images = images;
        this.texts = texts;
    }

    @Override
    public HomeRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_breeder_recycleview_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(images.get(position));
        holder.mTextView.setText(texts.get(position));
    }


    @Override
    public int getItemCount() {
        return images.size();
    }
}
