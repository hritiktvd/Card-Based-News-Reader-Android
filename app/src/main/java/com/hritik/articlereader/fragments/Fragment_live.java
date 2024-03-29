package com.hritik.articlereader.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hritik.articlereader.R;
import com.hritik.articlereader.live.Live_news;

public class Fragment_live extends Fragment implements View.OnClickListener {

    View view;
    CardView v_aajtak, v_abpnews, v_indiatv, v_indiatoday, v_cnn, v_republictv, v_abcnews, v_skynews, v_aljazeera, v_twittv, v_nasa, v_cbsnews, v_linustv, v_tailosivetv, v_timesnow, v_zoomtv, v_newsnation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live, container, false);
        //youtube
        v_aajtak = view.findViewById(R.id.aajtak);
        v_abpnews = view.findViewById(R.id.abpnews);
        v_aljazeera = view.findViewById(R.id.aljazeera);
        v_abcnews = view.findViewById(R.id.abcnews);
        v_indiatv = view.findViewById(R.id.indiatv);
        v_nasa = view.findViewById(R.id.nasa);
        v_cnn = view.findViewById(R.id.cnnnews);
        v_republictv = view.findViewById(R.id.republictv);
        v_skynews = view.findViewById(R.id.skynews);
        v_twittv = view.findViewById(R.id.twittv);
        v_indiatoday = view.findViewById(R.id.indiatoday);
        v_newsnation = view.findViewById(R.id.newsnation);
        //non youtube
        v_cbsnews = view.findViewById(R.id.cbsnews);
        v_linustv = view.findViewById(R.id.linustv);
        v_tailosivetv = view.findViewById(R.id.tailosivetv);
        v_timesnow = view.findViewById(R.id.timesnow);
        v_zoomtv = view.findViewById(R.id.zoomtv);

        v_aajtak.setOnClickListener(this);
        v_abpnews.setOnClickListener(this);
        v_aljazeera.setOnClickListener(this);
        v_abcnews.setOnClickListener(this);
        v_indiatv.setOnClickListener(this);
        v_nasa.setOnClickListener(this);
        v_cnn.setOnClickListener(this);
        v_republictv.setOnClickListener(this);
        v_skynews.setOnClickListener(this);
        v_twittv.setOnClickListener(this);
        v_indiatoday.setOnClickListener(this);
        v_cbsnews.setOnClickListener(this);
        v_linustv.setOnClickListener(this);
        v_tailosivetv.setOnClickListener(this);
        v_timesnow.setOnClickListener(this);
        v_zoomtv.setOnClickListener(this);
        v_newsnation.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        //video id of all live channels
        String abpnews = "vO2aWm-WAI0";
        String aajtak = "6-S4et2YpZc";
        String indiatv = "VTEdJKJlxxc";
        String indiatoday = "E7dbhET6_EA";
        String cnnnews = "VIk_6OuYkSo";
        String republictv = "X9rIbysGDxc";
        String abcnews = "BbDF_GXBmGc";
        String skynews = "lrX6ktLg8WQ";
        String aljazeera = "jL8uDJJBjMA";
        String twittv = "Y3PA5f8m8jg";
        String nasa = "21X5lGlDOfg";
        String cbs = "https://www.cbsnews.com/live/";
        String timesnow = "https://timesofindia.indiatimes.com/live-tv";
        String zoomtv = "https://timesofindia.indiatimes.com/live-tv/zoom-tv/video";
        String linustv = "https://www.twitch.tv/linustech";
        String tailosivetv = "https://www.twitch.tv/tailosivetech";
        String newsnation = "DlvSwWKafOE";


        switch (v.getId()) {
            case R.id.aajtak:
                Intent i_aaajtak = new Intent(getActivity(), Live_news.class);
                i_aaajtak.putExtra("v_id", aajtak);
                Toast.makeText(getActivity(), "Courtesy:Aaj Tak", Toast.LENGTH_LONG).show();
                startActivity(i_aaajtak);
                break;
            case R.id.abpnews:
                Intent i_abp = new Intent(getActivity(), Live_news.class);
                i_abp.putExtra("v_id", abpnews);
                Toast.makeText(getActivity(), "Courtesy:ABP News", Toast.LENGTH_LONG).show();
                startActivity(i_abp);
                break;
            case R.id.aljazeera:
                Intent i_aljz = new Intent(getActivity(), Live_news.class);
                i_aljz.putExtra("v_id", aljazeera);
                Toast.makeText(getActivity(), "Courtesy:Al Jazeera", Toast.LENGTH_LONG).show();
                startActivity(i_aljz);
                break;
            case R.id.abcnews:
                Intent i_blm = new Intent(getActivity(), Live_news.class);
                i_blm.putExtra("v_id", abcnews);
                Toast.makeText(getActivity(), "Courtesy:ABC News", Toast.LENGTH_LONG).show();
                startActivity(i_blm);
                break;
            case R.id.cbsnews:
                Intent i_cbs = new Intent(Intent.ACTION_VIEW, Uri.parse(cbs));
                startActivity(i_cbs);
                break;
            case R.id.indiatv:
                Intent i_itv = new Intent(getActivity(), Live_news.class);
                i_itv.putExtra("v_id", indiatv);
                Toast.makeText(getActivity(), "Courtesy:India TV", Toast.LENGTH_LONG).show();
                startActivity(i_itv);
                break;
            case R.id.linustv:
                Intent i_linus = new Intent(Intent.ACTION_VIEW, Uri.parse(linustv));
                startActivity(i_linus);
                break;
            case R.id.nasa:
                Intent i_nasa = new Intent(getActivity(), Live_news.class);
                i_nasa.putExtra("v_id", nasa);
                Toast.makeText(getActivity(), "Courtesy:NASA", Toast.LENGTH_LONG).show();
                startActivity(i_nasa);
                break;
            case R.id.cnnnews:
                Intent i_ndtv = new Intent(getActivity(), Live_news.class);
                i_ndtv.putExtra("v_id", cnnnews);
                Toast.makeText(getActivity(), "Courtesy:NDTV", Toast.LENGTH_LONG).show();
                startActivity(i_ndtv);
                break;
            case R.id.republictv:
                Intent i_repub = new Intent(getActivity(), Live_news.class);
                i_repub.putExtra("v_id", republictv);
                Toast.makeText(getActivity(), "Courtesy:Republic TV", Toast.LENGTH_LONG).show();
                startActivity(i_repub);
                break;
            case R.id.skynews:
                Intent i_sky = new Intent(getActivity(), Live_news.class);
                i_sky.putExtra("v_id", skynews);
                Toast.makeText(getActivity(), "Courtesy:Sky News", Toast.LENGTH_LONG).show();
                startActivity(i_sky);
                break;
            case R.id.tailosivetv:
                Intent i_tail = new Intent(Intent.ACTION_VIEW, Uri.parse(tailosivetv));
                startActivity(i_tail);
                break;
            case R.id.timesnow:
                Intent i_times = new Intent(Intent.ACTION_VIEW, Uri.parse(timesnow));
                startActivity(i_times);
                break;
            case R.id.twittv:
                Intent i_twit = new Intent(getActivity(), Live_news.class);
                i_twit.putExtra("v_id", twittv);
                Toast.makeText(getActivity(), "Courtesy:Twit TV", Toast.LENGTH_LONG).show();
                startActivity(i_twit);
                break;
            case R.id.zoomtv:
                Intent i_zoom = new Intent(Intent.ACTION_VIEW, Uri.parse(zoomtv));
                startActivity(i_zoom);
                break;
            case R.id.indiatoday:
                Intent i_itoday = new Intent(getActivity(), Live_news.class);
                i_itoday.putExtra("v_id", indiatoday);
                Toast.makeText(getActivity(), "Courtesy:India Today", Toast.LENGTH_LONG).show();
                startActivity(i_itoday);
                break;
            case R.id.newsnation:
                Intent i_newsnation = new Intent(getActivity(), Live_news.class);
                i_newsnation.putExtra("v_id", newsnation);
                Toast.makeText(getActivity(), "Courtesy:News Nation456", Toast.LENGTH_LONG).show();
                startActivity(i_newsnation);
                break;

        }

    }
}
