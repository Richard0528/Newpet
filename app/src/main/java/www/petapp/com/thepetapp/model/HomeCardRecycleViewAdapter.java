package www.petapp.com.thepetapp.model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.petapp.com.thepetapp.R;

public class HomeCardRecycleViewAdapter extends RecyclerView.Adapter<HomeCardRecycleViewAdapter.ViewHolder> {

    private List<PetCardItem> petCards;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;
        private ImageView mImageURL;
        private TextView mDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.home_recycleview_card);
            mImageURL = itemView.findViewById(R.id.cardImage);
            mDescription = itemView.findViewById(R.id.cardDescription);
        }
    }

    public HomeCardRecycleViewAdapter(List<PetCardItem> petCards) {
        this.petCards = petCards;
    }

    @Override
    public HomeCardRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.square_cardview_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageURL.setImageResource(petCards.get(position).getImageURL());
        holder.mDescription.setText(petCards.get(position).getDescription());
//        Log.d("Card info", "Description: " + petCards.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return petCards.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
