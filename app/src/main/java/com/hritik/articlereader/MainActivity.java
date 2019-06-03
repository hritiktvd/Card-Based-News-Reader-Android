package com.hritik.articlereader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView logosmall;
    TextView titletext;
    EditText username, password;
    Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logosmall = findViewById(R.id.logosmall);
        titletext = findViewById(R.id.titletext);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Switiching to the next screen
                Intent i_home = new Intent(MainActivity.this, Hamburger_menu.class);
                startActivity(i_home);
            }
        });


    }
}


