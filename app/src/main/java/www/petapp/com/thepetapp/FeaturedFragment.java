package www.petapp.com.thepetapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import www.petapp.com.thepetapp.model.PetCardItem;
import www.petapp.com.thepetapp.model.TopBreederRecycleViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends Fragment {

    private RecyclerView mPetNewsRecycleView;
    private ArrayList<PetCardItem> mFeaturedPetNewsList;
    private TopBreederRecycleViewAdapter featuredPetNewsAdapter;

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured, container, false);

        mPetNewsRecycleView = view.findViewById(R.id.featured_pet_news);
        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    public void onStart() {
        super.onStart();

        // pet news
        mFeaturedPetNewsList = new ArrayList<>();
        mFeaturedPetNewsList.add(new PetCardItem(R.drawable.images_1, "First Pet news"));
        mFeaturedPetNewsList.add(new PetCardItem(R.drawable.images_2, "Second Pet news"));
        mFeaturedPetNewsList.add(new PetCardItem(R.drawable.images_3, "Third Pet news"));
        mFeaturedPetNewsList.add(new PetCardItem(R.drawable.images_4, "Forth Pet news"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mPetNewsRecycleView.setLayoutManager(linearLayoutManager);

        featuredPetNewsAdapter = new TopBreederRecycleViewAdapter(mFeaturedPetNewsList);
        mPetNewsRecycleView.setAdapter(featuredPetNewsAdapter);

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
