package com.hritik.articlereader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Main_hamburger extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar hamburger_toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView hamburger_view;
    BottomNavigationView bottom_navigation;
    private DrawerLayout hamburger_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hamburger);

        //implementing the Hamburger listener
        hamburger_view = findViewById(R.id.hamburger_view);
        hamburger_view.setNavigationItemSelectedListener(this);

        //implementing the bottom navbar listener
        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(this); //this will point the item listner to the bottom_navigation part


        hamburger_toolbar = findViewById(R.id.hamburger_toolbar);
        setSupportActionBar(hamburger_toolbar); //this is used to replace action bar with the toolbar we defined

        hamburger_layout = findViewById(R.id.hamburger_layout);

        //the layout and the toolbar communicate with each other by this way
        toggle = new ActionBarDrawerToggle(this, hamburger_layout, hamburger_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        hamburger_layout.addDrawerListener(toggle);
        //to animate the hamburger icon
        toggle.syncState();

        //Default Loading activity
        loadFragment(new Fragment_technology());
    }

    //If back button is pressed when menu is open.
    @Override
    public void onBackPressed() {
        if (hamburger_layout.isDrawerOpen(GravityCompat.START)) {
            hamburger_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


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

            case R.id.hamburger_profile:
                fragment = new Fragment_profile();
                break;

            case R.id.hamburger_live:
                fragment = new Fragment_live();
                break;

            case R.id.hamburger_discover:
                fragment = new Fragment_discover();
                break;

            case R.id.hamburger_settings:
                fragment = new Fragment_settings();
                break;
            case R.id.hamburger_about_us:
                fragment = new Fragment_about();
                break;


        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        hamburger_layout.closeDrawer(GravityCompat.START);
        return true;
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
