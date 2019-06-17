package com.hritik.articlereader;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hritik.articlereader.fragments.Fragment_about;
import com.hritik.articlereader.fragments.Fragment_discover;
import com.hritik.articlereader.fragments.Fragment_entertainment;
import com.hritik.articlereader.fragments.Fragment_live;
import com.hritik.articlereader.fragments.Fragment_profile;
import com.hritik.articlereader.fragments.Fragment_settings;
import com.hritik.articlereader.fragments.Fragment_sports;
import com.hritik.articlereader.fragments.Fragment_technology;

public class Hamburger_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    //The Default Navigation Drawer Activity was Used.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //To set the background color of the toolbar/actionbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hamburger_header)));


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //the layout and the toolbar communicate with each other by this way. The two strings
        //below are used for people with disability.
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        //To animate the three line hamburger menu icon.
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //implementing the Hamburger listener
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //implementing the bottom navbar listener
        BottomNavigationView bottom_navigation = findViewById(R.id.bottom_navigation);
        //Method to call the Switch cases for the Bottom Navigation Bar
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                displaySelectedScreen(menuItem.getItemId());
                return true;
            }
        });

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.navigation_tech);
    }

    //Comes with Default Activity
    //Used when the back button is pressed on the phone.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) { //gravitycompat :from where the navbar will come from
            drawer.closeDrawer(GravityCompat.START);    //START:from left of screen. END: from right of screen.
        } else {
            super.onBackPressed();
        }
    }

    //Comes with Default Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger_menu, menu);

        return true;
    }

    //Comes with Default Activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Method to call the Switch cases for the Navigation Bar
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //make this method blank
        displaySelectedScreen(item.getItemId());

        return true;
    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {

            case R.id.hamburger_home:
                fragment = new Fragment_technology();
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

            case R.id.navigation_tech:
                fragment = new Fragment_technology();
                break;

            case R.id.navigation_sports:
                fragment = new Fragment_sports();
                break;

            case R.id.navigation_entertainment:
                fragment = new Fragment_entertainment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }

        //Loading the Frame Layout
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
