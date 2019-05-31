package com.hritik.articlereader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

//implementing the item listener for selecting the fragments
public class Bottom_navbar extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);

        //loading defualt fragment
        loadFragment(new Fragment_technology());

        //getting bottom navigation and attaching the listener
        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(this); //this will point the item listner to the bottom_navigation part

    }

    //selecting the item in the bottom_navbar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null; //reference to the fragment we want to open

        switch (menuItem.getItemId()) {
            case R.id.navigation_tech:
                fragment = new Fragment_technology();
                break;
            case R.id.navigation_sports:
                fragment = new Fragment_sports();
                break;
            case R.id.navigation_politics:
                fragment = new Fragment_politics();
                break;
        }
        return loadFragment(fragment);

    }

    //taking fragment as an object
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            //creating a method to load any specified fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

}
