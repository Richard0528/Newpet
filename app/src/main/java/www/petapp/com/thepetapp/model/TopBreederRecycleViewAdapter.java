package www.petapp.com.thepetapp.model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import www.petapp.com.thepetapp.R;

public class TopBreederRecycleViewAdapter extends RecyclerView.Adapter<TopBreederRecycleViewAdapter.ViewHolder> {

    private List<PetCardItem> breederCards;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private ImageView mImageView;
        private TextView mDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.topBreeder_recycleview_card);
            mImageView = itemView.findViewById(R.id.topBreederImage);
            mDescription = itemView.findViewById(R.id.topBreederDescription);
        }
    }

    public TopBreederRecycleViewAdapter(List<PetCardItem> breederCards) {
        this.breederCards = breederCards;
    }

    @Override
    public TopBreederRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_breeder_recycleview_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(breederCards.get(position).getImageURL());
        holder.mDescription.setText(breederCards.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return breederCards.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
