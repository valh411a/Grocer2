package com.example.grocer2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.grocer2.ui.helpdialog.HelpDialogFragment;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FragmentManager fragmentManager;
    DrawerLayout mDrawerLayout;
    FoodViewModel foodViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //create content view and setup toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getFragmentManager();
        foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);


        //set up navigation menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
        navigationView.requestLayout();

        //set up listeners for navigation menu
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    /**
     * Function runs when the 'help' button is pressed, displaying assisting text
     * @param view the content view of the page
     */
    public void displayHelp(View view) {
        DialogFragment newHelpFragment = new HelpDialogFragment();
        newHelpFragment.show(getSupportFragmentManager(), "HelpDialog");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles the actions that are started when each button is pressed on the navigation bar
     * @param item the items that comprise the menu
     * @return default boolean handler for a successful action start
     */
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_food_list) {
            fragmentClass = food_list.class;

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        try {
            if (fragmentClass != null) {
                fragment = (Fragment) fragmentClass.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
        item.setChecked(true);
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
        return true;
    }
}
