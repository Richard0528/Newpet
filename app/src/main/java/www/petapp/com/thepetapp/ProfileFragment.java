package www.petapp.com.thepetapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import www.petapp.com.thepetapp.login.LoginActivity;

import static android.text.TextUtils.isEmpty;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";
    private Button mLogin;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*
        if(user is logged in) {
            go to fragment profile
        else {
        regisiteractivity
        goes back to oncreate view
         */
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        View v;

        if (user != null) {
            // user signed in, directed to the profile fragment
            v = inflater.inflate(R.layout.fragment_profile_logged_in, container, false);

        } else {   // user not signed in, directed to the login activity

            v = inflater.inflate(R.layout.fragment_profile_not_logged_in, container, false);

            mLogin = (Button) v.findViewById(R.id.profile_login_button);
            mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //check if the fields are filled out
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    getContext().startActivity(intent);

                }
            });

        }

        return v;
    }

}
