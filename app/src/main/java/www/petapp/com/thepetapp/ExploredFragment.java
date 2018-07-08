package www.petapp.com.thepetapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import www.petapp.com.thepetapp.model.HomeCardRecycleViewAdapter;
import www.petapp.com.thepetapp.model.HomeRecycleViewAdapter;
import www.petapp.com.thepetapp.model.ImageSliderAdapter;
import www.petapp.com.thepetapp.model.PetCardItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploredFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView mTopBreederRecyclerView;
    private RecyclerView mExploredPetsRecycleView;
    private ArrayList<Integer> mNewPetsImages;
    private ArrayList<Integer> mTopBreederImages;
    private ArrayList<String> mTopBreederTexts;
    private ArrayList<PetCardItem> mExploredPetList;
    private ImageSliderAdapter imageSliderAdapter;
    private HomeRecycleViewAdapter homeRecycleViewAdapter;
    private HomeCardRecycleViewAdapter homeCardRecycleViewAdapter;

    public ExploredFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explored, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.new_pets_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabDots);

        // Top breeder recyclerview

        mTopBreederRecyclerView = view.findViewById(R.id.top_breeder_recycleview);

        // pets published

        mExploredPetsRecycleView = view.findViewById(R.id.explored_pets_recycleview);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mNewPetsImages = new ArrayList<>();
        mNewPetsImages.add(R.drawable.images_1);
        mNewPetsImages.add(R.drawable.images_2);
        mNewPetsImages.add(R.drawable.images_3);
        mNewPetsImages.add(R.drawable.images_4);

        imageSliderAdapter = new ImageSliderAdapter(getContext(), mNewPetsImages);

        viewPager.setAdapter(imageSliderAdapter);
        tabLayout.setupWithViewPager(viewPager, true);

        // Top breeder recyclerview
        mTopBreederImages = new ArrayList<>();
        mTopBreederImages.add(R.drawable.images_1);
        mTopBreederImages.add(R.drawable.images_2);
        mTopBreederImages.add(R.drawable.images_3);
        mTopBreederImages.add(R.drawable.images_4);

        mTopBreederTexts = new ArrayList<>();
        mTopBreederTexts.add("111111111111111");
        mTopBreederTexts.add("222222222222222");
        mTopBreederTexts.add("333333333333333");
        mTopBreederTexts.add("444444444444444");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mTopBreederRecyclerView.setLayoutManager(linearLayoutManager);

        homeRecycleViewAdapter = new HomeRecycleViewAdapter(mTopBreederImages, mTopBreederTexts);
        mTopBreederRecyclerView.setAdapter(homeRecycleViewAdapter);

        // pets published
        mExploredPetList = new ArrayList<>();
        mExploredPetList.add(new PetCardItem(R.drawable.images_1, "First pet image"));
        mExploredPetList.add(new PetCardItem(R.drawable.images_2, "Second pet image"));
        mExploredPetList.add(new PetCardItem(R.drawable.images_3, "Third pet image"));
        mExploredPetList.add(new PetCardItem(R.drawable.images_4, "Forth pet image"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mExploredPetsRecycleView.setLayoutManager(gridLayoutManager);

        mExploredPetsRecycleView.setNestedScrollingEnabled(false);

        homeCardRecycleViewAdapter = new HomeCardRecycleViewAdapter(mExploredPetList);
        mExploredPetsRecycleView.setAdapter(homeCardRecycleViewAdapter);

    }

}
