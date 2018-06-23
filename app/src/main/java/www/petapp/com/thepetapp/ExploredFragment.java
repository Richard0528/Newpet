package www.petapp.com.thepetapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import www.petapp.com.thepetapp.model.ImageSliderAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploredFragment extends Fragment {

    private ViewPager viewPager;
    ArrayList<Integer> images;
    ImageSliderAdapter imageSliderAdapter;

    public ExploredFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explored, container, false);

        images = new ArrayList<>();
        images.add(R.drawable.images_1);
        images.add(R.drawable.images_2);
        images.add(R.drawable.images_3);
        images.add(R.drawable.images_4);

        viewPager = (ViewPager)view.findViewById(R.id.new_pets_pager);
        TabLayout tabLayout = view.findViewById(R.id.tabDots);
        imageSliderAdapter = new ImageSliderAdapter(getContext(), images);

        viewPager.setAdapter(imageSliderAdapter);
        tabLayout.setupWithViewPager(viewPager, true);

        return view;
    }

}
