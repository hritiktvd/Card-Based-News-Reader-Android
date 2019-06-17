package com.hritik.articlereader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        sessionManager = new SessionManager(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sessionManager.isLoggedIn()) {
                    Intent i = new Intent(Splash.this, Hamburger_menu.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Splash.this, WelcomeScreen.class);
                    startActivity(i);
                }

                finish();
            }
        }, 3000);
    }
}
