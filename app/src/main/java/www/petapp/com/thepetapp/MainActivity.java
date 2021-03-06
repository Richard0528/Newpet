package www.petapp.com.thepetapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity implements FeaturedFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;
    private static final String TAG = "MainActivity";
    String toOpen = null;

    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_favor:
                    loadFragment(new FavorFragment());
                    return true;
                case R.id.navigation_add:
                    loadFragment(new AddFragment());
                    return true;
                case R.id.navigation_message:
                    loadFragment(new MessageFragment());
                    return true;
                case R.id.navigation_profile:
                    loadFragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);



//        BottomNavigationView navigation = findViewById(R.id.main_bottom_navigation);
        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.main_bottom_navigation);
        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);
        navigation.setTextSize(10);
        navigation.setIconSize(18,18);
        navigation.setItemHeight(BottomNavigationViewEx.dp2px(this,50));
        navigation.setIconsMarginTop(BottomNavigationViewEx.dp2px(this, 10));

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());

//        toOpen = ;

//        if (getIntent().getExtras().getString("toOpen") != null) {
//            //toOpen = getIntent().getExtras().getString("toOpen");
//            loadFragment(new ProfileFragment());
//        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void loadFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getTag());
        fragmentTransaction.commit();

    }
}
