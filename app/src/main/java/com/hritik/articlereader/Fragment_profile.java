package com.hritik.articlereader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

public class Fragment_profile extends Fragment {

    View view;

    Button logoutBtn;
    TextView userName, userEmail, userId;
    ImageView profileImage;
    SessionManager sessionManager;
    String name, email, image;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        sessionManager = new SessionManager(getActivity());
        logoutBtn = view.findViewById(R.id.logoutBtn);
        userName = view.findViewById(R.id.name);
        userEmail = view.findViewById(R.id.email);
/*
        userId = view.findViewById(R.id.userId);
*/
        profileImage = view.findViewById(R.id.profileImage);

        name = sessionManager.getUserDetails().get(SessionManager.user_name);
        email = sessionManager.getUserDetails().get(SessionManager.user_email);
        image = sessionManager.getUserDetails().get(SessionManager.user_image);

        userName.setText(name);
        userEmail.setText(email);

        Glide.with(getActivity()).load(image).asBitmap().into(profileImage);


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutUser();
            }
        });


        return view;
    }

}
