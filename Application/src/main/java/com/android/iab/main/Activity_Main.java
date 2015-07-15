package com.android.iab.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.iab.helper.HelperMethods;
import com.example.android.actionbarcompat.styled.R;
import com.navdrawer.SimpleSideDrawer;

/**
 * Created by Syed
 */
    public class Activity_Main extends ActionBarActivity implements View.OnClickListener, FragmentDrawer.FragmentDrawerListener {

    ImageView slider_shutter_ImageView;  //Image to open & close slider
    //SimpleSideDrawer slider; //for slider
    LinearLayout back_layout;
    String ACTIVITY_LOG = "";
    SharedPreferences mPrefs; // SharedPreferences object to store coomon sharable data.

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
         //   requestWindowFeature(Window.FEATURE_NO_TITLE);   //Hiding default app header
            setContentView(R.layout.sample_main);

            ACTIVITY_LOG = this.getClass().getSimpleName();                     // get class name
            mPrefs= getSharedPreferences(HelperMethods.MODE_TYPE, MODE_PRIVATE); // Initializing the SharedPreferences

           // slider = new SimpleSideDrawer(this); // Initializing the slider

           // slider.setLeftBehindContentView(R.layout.left_menu);

            mToolbar = (Toolbar) findViewById(R.id.toolbar);

            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            drawerFragment = (FragmentDrawer)
                    getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
            drawerFragment.setDrawerListener(this);

            getUIobjects();
            addClickListner();

            // Set the Action Bar to use tabs for navigation
//            ActionBar ab = getSupportActionBar();
//            ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//            // Add three tabs to the Action Bar for display
//            ab.addTab(ab.newTab().setText("Tab 1").setTabListener(this));
//            ab.addTab(ab.newTab().setText("Tab 2").setTabListener(this));
//            ab.addTab(ab.newTab().setText("Tab 3").setTabListener(this));




        }

    private void addClickListner() {

       // slider_shutter_ImageView.setOnClickListener(this);
       // back_layout.setOnClickListener(this);

    }

    private void getUIobjects() {

       // slider_shutter_ImageView = (ImageView) findViewById(R.id.slider_shutter_ImageView);
        back_layout = (LinearLayout) findViewById(R.id.back_layout);

    }

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();

        Boolean loginStatus =  mPrefs.getBoolean("isLogin", false);

        if(loginStatus){
            //Intent  intent = new Intent(getApplicationContext(), Activity_Main.class);
//            Intent  intent = new Intent();
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            finish();  //finishing all the activity
//            System.exit(0);   //Exiting all the activity
            Log.e(ACTIVITY_LOG,"YOU ARE STILL LOGGED IN");

          //  finishAffinity();  only support in Android 4.1+
            ActivityCompat.finishAffinity(this);      //finishing all the activity

        }



    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate menu from menu resource (res/menu/main)
            getMenuInflater().inflate(R.menu.main, menu);

            return super.onCreateOptionsMenu(menu);
        }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_layout:

                // opens up left drawer
             //   slider.toggleLeftDrawer();
                break;

        }

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}

