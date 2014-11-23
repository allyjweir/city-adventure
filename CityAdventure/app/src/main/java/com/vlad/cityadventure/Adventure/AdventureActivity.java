package com.vlad.cityadventure.adventure;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.dashboard.DashboardAdventureFragment;

import java.util.LinkedList;

public class AdventureActivity extends Activity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private Adventure adventure;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        setupActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
       mDrawerList = (ListView) findViewById(R.id.left_drawer);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new AdventureMenuAdapter());
        // Set the list's click listener
       // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        /** initializing the actual adventure activity views*/
        if (!setAdventure(getIntent().getStringExtra(DashboardAdventureFragment.ID)))
            finish();
        ListView adventureSteps = (ListView) findViewById(R.id.directions_list);
        adventureSteps.setAdapter(new AdventureStepsAdapter(adventure.getRoute(), progress, AdventureActivity.this));

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * sets up the action bar with a custom view and changes its font
     */
    private void setupActionBar() {
        ActionBar ab = getActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setIcon(R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha);
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);

        TextView titleTV = (TextView) v.findViewById(R.id.title);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        titleTV.setTypeface(tf);

        ab.setCustomView(v);

//        ab.setDisplayHomeAsUpEnabled(false); todo no idea why this is needed in this activity but not dashboard
        ab.setHomeButtonEnabled(true);
    }

    /**
     * Gets the adventure from the database based on its id
     * at the moment this is mocked
     */
    private boolean setAdventure(String adventureId){
        Adventure adventure = new Adventure();
        LinkedList<Landmark> landmarks = new LinkedList<Landmark>();
        Landmark hunterian = new Landmark("Hunterian Museum and Art Gallery", "The University of Glasgow's Hunterian is the oldest museum in Scotland. " +
                "It covers The Hunterian Museum, The Hunterian Art Gallery, The Mackintosh House, The Zoology Museum and The Anatomy Museum, " +
                "all located in various buildings on the main campus of the University in the west end of Glasgow.", "museum", (float) 55.8719,
                (float) 4.2886, null, null, null, 10032);
        landmarks.add(hunterian);
        Landmark kelvingrove = new Landmark("Kelvingrove Art Gallery and Museum", "The Kelvingrove Art Gallery and Museum is a museum and art gallery" +
                " in Glasgow, Scotland. The building houses one of Europe's great civic art collections. Since its 2003–06 refurbishment, " +
                "the museum has been the most popular free-to-enter visitor attraction in Scotland,and the most visited museum in the United " +
                "Kingdom outside London.", "museum", (float) 55.8686,
                (float) 4.2905, null, null, null, 192032);
        landmarks.add(kelvingrove);
        Landmark riverside = new Landmark("Riverside Museum", "The Riverside Museum is a new development for the Glasgow Museum of Transport," +
                " completed on 20 June 2011, at Pointhouse Quay in the Glasgow Harbour regeneration district of Glasgow, Scotland. The next day" +
                " it opened to the public.On 18 May 2013, the museum was announced as the Winner of the 2013 European Museum of the Year Award.", "museum", (float) 55.8651,
                (float) 4.3064, null, null, null, 3032);
        landmarks.add(riverside);
        adventure.setRoute(landmarks);
        this.adventure = adventure;
        progress = 1;
        return true;
    }
}
