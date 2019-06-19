/*YouTubePlayerView takes care of Android Configuration Change events.
It saves and restore the state of the YouTubePlayer associated
 with the view as part of the onSaveInstanceState/onRestoreInstanceState.
 */

/*In the above code snippet, we are calling initialize(String, OnInitializedListener)
 method on YouTubePlayerView to instantiate YouTubePlayer.
 Ones YouTubePlayer instance is ready, it can be used to to load videos into this YouTubePlayerView.
  */
package com.hritik.articlereader.live;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.hritik.articlereader.R;

public class Live_news extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCyCFPvn5-ExWv2TJLuCkYn3R6pUxrGcBE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.layout_live);

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = findViewById(R.id.playerview);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(getApplicationContext(), "Failed to initialize.", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (null == youTubePlayer) return;

        //start buffering
        if (!wasRestored) {
            Intent i = getIntent();
            String getVideoId = i.getStringExtra("v_id");
            youTubePlayer.loadVideo(getVideoId);
        }
        //attach PlaybackEventListener or PlayerStateChangeListener listeners to player instance for
        // error handling or advanced configurations.
        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {
            }

            @Override
            public void onVideoStarted() {

            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        });
        youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {

            }

            @Override
            public void onPaused() {

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        });
    }


}
