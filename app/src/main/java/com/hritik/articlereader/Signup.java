package com.hritik.articlereader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup extends AppCompatActivity {


    ImageView logosmall;
    TextView titletext;
    EditText email, username, password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        logosmall = findViewById(R.id.logosmall);
        titletext = findViewById(R.id.titletext);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_home = new Intent(Signup.this, Hamburger_menu.class);
                startActivity(i_home);

            }
        });

    }
}
