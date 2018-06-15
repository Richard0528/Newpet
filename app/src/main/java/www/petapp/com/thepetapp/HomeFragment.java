package www.petapp.com.thepetapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Home Fragment that include Explor
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        setupViewPager(v);
        return v;
    }


    private void setupViewPager(View v) {
        //change to get child fragment manager
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());

//        Log.e(TAG, "Support manager = " + getActivity().getSupportFragmentManager());
        adapter.addFragment(new ExploredFragment());
        adapter.addFragment(new FeaturedFragment());
        ViewPager viewPager = v.findViewById(R.id.home_viewpager_layout);
//        Log.e(TAG, "SectionPageAdapter = " + adapter );
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = v.findViewById(R.id.home_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_filter);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
    }


}
