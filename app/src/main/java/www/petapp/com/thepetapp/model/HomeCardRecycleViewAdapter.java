package www.petapp.com.thepetapp.model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import www.petapp.com.thepetapp.R;

public class HomeCardRecycleViewAdapter extends RecyclerView.Adapter<HomeCardRecycleViewAdapter.ViewHolder> {

    private List<PetCardItem> petCards;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.home_recycleview_card);
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
        holder.mCardView.setTag(petCards.get(position));
    }


    @Override
    public int getItemCount() {
        return petCards.size();
    }


}
