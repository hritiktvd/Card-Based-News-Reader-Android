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
import com.hritik.articlereader.discover.Discover_abcnews;
import com.hritik.articlereader.discover.Discover_bloomberg;
import com.hritik.articlereader.discover.Discover_buzzfeed;
import com.hritik.articlereader.discover.Discover_engadget;
import com.hritik.articlereader.discover.Discover_entweekly;
import com.hritik.articlereader.discover.Discover_hindu;
import com.hritik.articlereader.discover.Discover_huffpost;
import com.hritik.articlereader.discover.Discover_ign;
import com.hritik.articlereader.discover.Discover_mashable;
import com.hritik.articlereader.discover.Discover_mtv;
import com.hritik.articlereader.discover.Discover_natgeo;
import com.hritik.articlereader.discover.Discover_nytimes;
import com.hritik.articlereader.discover.Discover_polygon;
import com.hritik.articlereader.discover.Discover_time;
import com.hritik.articlereader.discover.Discover_toi;
import com.hritik.articlereader.discover.Discover_verge;
import com.hritik.articlereader.discover.Discover_wired;
import com.hritik.articlereader.discover.Discover_wsj;

public class Fragment_discover_publishers extends Fragment implements View.OnClickListener {

    View view;
    CardView verge, ign, abc, bloomberg, buzzfeed, ent_weekly, mashable, engadget, mtv, natgeo, polygon, hindu, huffpost, nytimes, wsj, toi, time, wired;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discover_publishers, container, false);

        verge = view.findViewById(R.id.verge);
        ign = view.findViewById(R.id.ign);
        abc = view.findViewById(R.id.abcnews);
        bloomberg = view.findViewById(R.id.bloomberg);
        buzzfeed = view.findViewById(R.id.buzzfeed);
        ent_weekly = view.findViewById(R.id.ent_weekly);
        mashable = view.findViewById(R.id.mashable);
        engadget = view.findViewById(R.id.engadget);
        mtv = view.findViewById(R.id.mtv);
        natgeo = view.findViewById(R.id.natgeo);
        polygon = view.findViewById(R.id.polygon);
        hindu = view.findViewById(R.id.thehindu);
        huffpost = view.findViewById(R.id.huffpost);
        nytimes = view.findViewById(R.id.newyorktimes);
        wsj = view.findViewById(R.id.wsj);
        toi = view.findViewById(R.id.toi);
        time = view.findViewById(R.id.time);
        wired = view.findViewById(R.id.wired);


        verge.setOnClickListener(this);
        ign.setOnClickListener(this);
        abc.setOnClickListener(this);
        bloomberg.setOnClickListener(this);
        buzzfeed.setOnClickListener(this);
        ent_weekly.setOnClickListener(this);
        mashable.setOnClickListener(this);
        engadget.setOnClickListener(this);
        mtv.setOnClickListener(this);
        natgeo.setOnClickListener(this);
        polygon.setOnClickListener(this);
        hindu.setOnClickListener(this);
        huffpost.setOnClickListener(this);
        nytimes.setOnClickListener(this);
        wsj.setOnClickListener(this);
        toi.setOnClickListener(this);
        time.setOnClickListener(this);
        wired.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.verge:
                Intent i_verge = new Intent(getActivity(), Discover_verge.class);
                startActivity(i_verge);
                break;
            case R.id.ign:
                Intent i_ign = new Intent(getActivity(), Discover_ign.class);
                startActivity(i_ign);
                break;
            case R.id.abcnews:
                Intent i_abc = new Intent(getActivity(), Discover_abcnews.class);
                startActivity(i_abc);
                break;
            case R.id.bloomberg:
                Intent i_bloom = new Intent(getActivity(), Discover_bloomberg.class);
                startActivity(i_bloom);
                break;
            case R.id.buzzfeed:
                Intent i_buzz = new Intent(getActivity(), Discover_buzzfeed.class);
                startActivity(i_buzz);
                break;
            case R.id.ent_weekly:
                Intent i_ent = new Intent(getActivity(), Discover_entweekly.class);
                startActivity(i_ent);
                break;
            case R.id.mashable:
                Intent i_mash = new Intent(getActivity(), Discover_mashable.class);
                startActivity(i_mash);
                break;
            case R.id.engadget:
                Intent i_engadget = new Intent(getActivity(), Discover_engadget.class);
                startActivity(i_engadget);
                break;
            case R.id.mtv:
                Intent i_mtv = new Intent(getActivity(), Discover_mtv.class);
                startActivity(i_mtv);
                break;
            case R.id.natgeo:
                Intent i_natgeo = new Intent(getActivity(), Discover_natgeo.class);
                startActivity(i_natgeo);
                break;
            case R.id.polygon:
                Intent i_poly = new Intent(getActivity(), Discover_polygon.class);
                startActivity(i_poly);
                break;
            case R.id.thehindu:
                Intent i_hindu = new Intent(getActivity(), Discover_hindu.class);
                startActivity(i_hindu);
                break;
            case R.id.huffpost:
                Intent i_huff = new Intent(getActivity(), Discover_huffpost.class);
                startActivity(i_huff);
                break;
            case R.id.newyorktimes:
                Intent i_ntimes = new Intent(getActivity(), Discover_nytimes.class);
                startActivity(i_ntimes);
                break;
            case R.id.wsj:
                Intent i_wsj = new Intent(getActivity(), Discover_wsj.class);
                startActivity(i_wsj);
                break;
            case R.id.toi:
                Intent i_toi = new Intent(getActivity(), Discover_toi.class);
                startActivity(i_toi);
                break;
            case R.id.time:
                Intent i_time = new Intent(getActivity(), Discover_time.class);
                startActivity(i_time);
                break;
            case R.id.wired:
                Intent i_wired = new Intent(getActivity(), Discover_wired.class);
                startActivity(i_wired);
                break;


        }

    }
}
