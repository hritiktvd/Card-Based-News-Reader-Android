/*YouTubePlayerView takes care of Android Configuration Change events.
It saves and restore the state of the YouTubePlayer associated
 with the view as part of the onSaveInstanceState/onRestoreInstanceState.
 */

/*In the above code snippet, we are calling initialize(String, OnInitializedListener)
 method on YouTubePlayerView to instantiate YouTubePlayer.
 Ones YouTubePlayer instance is ready, it can be used to to load videos into this YouTubePlayerView.
  */
package com.hritik.articlereader.live;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.hritik.articlereader.R;

public class Live_aajtak extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCyCFPvn5-ExWv2TJLuCkYn3R6pUxrGcBE";

    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String VIDEO_ID = "6-S4et2YpZc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.live_aajtak);

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = findViewById(R.id.playerview);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (null == youTubePlayer) return;

        //start buffering
        if (!wasRestored) {
            youTubePlayer.cueVideo("6-S4et2YpZc");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(getApplicationContext(), "Failed to initialize.", Toast.LENGTH_LONG).show();


    }
}
