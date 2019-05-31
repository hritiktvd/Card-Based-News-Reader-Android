package com.hritik.articlereader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    ImageView logosmall;
    TextView titletext, titletagline;
    Button signin, signup;

    @Override
    //bundle used to transfer data between different activities
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        logosmall = findViewById(R.id.logosmall);
        titletext = findViewById(R.id.titletext);
        titletagline = findViewById(R.id.titletagline);
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_signin = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(i_signin);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_signup = new Intent(WelcomeScreen.this, Signup.class);
                startActivity(i_signup);
            }
        });


    }
}
