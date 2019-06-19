package com.hritik.articlereader.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hritik.articlereader.R;
import com.hritik.articlereader.discover.Discover_aus;
import com.hritik.articlereader.discover.Discover_canada;
import com.hritik.articlereader.discover.Discover_india;
import com.hritik.articlereader.discover.Discover_newzeal;
import com.hritik.articlereader.discover.Discover_uk;
import com.hritik.articlereader.discover.Discover_usa;
import com.hritik.articlereader.discover.Discover_world;

public class Fragment_discover_country extends Fragment implements View.OnClickListener {

    View view;
    CardView india, usa, uk, aus, nz, canada, world;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discover_country, container, false);

        india = view.findViewById(R.id.india);
        usa = view.findViewById(R.id.usa);
        uk = view.findViewById(R.id.uk);
        aus = view.findViewById(R.id.aus);
        nz = view.findViewById(R.id.nz);
        canada = view.findViewById(R.id.canada);
        world = view.findViewById(R.id.world);

        india.setOnClickListener(this);
        usa.setOnClickListener(this);
        uk.setOnClickListener(this);
        aus.setOnClickListener(this);
        nz.setOnClickListener(this);
        canada.setOnClickListener(this);
        world.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.india:
                Intent i_india = new Intent(getActivity(), Discover_india.class);
                startActivity(i_india);
                break;
            case R.id.usa:
                Intent i_usa = new Intent(getActivity(), Discover_usa.class);
                startActivity(i_usa);
                break;
            case R.id.uk:
                Intent i_uk = new Intent(getActivity(), Discover_uk.class);
                startActivity(i_uk);
                break;
            case R.id.aus:
                Intent i_aus = new Intent(getActivity(), Discover_aus.class);
                startActivity(i_aus);
                break;
            case R.id.nz:
                Intent i_nz = new Intent(getActivity(), Discover_newzeal.class);
                startActivity(i_nz);
                break;
            case R.id.canada:
                Intent i_can = new Intent(getActivity(), Discover_canada.class);
                startActivity(i_can);
                break;
            case R.id.world:
                Intent i_world = new Intent(getActivity(), Discover_world.class);
                startActivity(i_world);
                break;
        }

    }
}
