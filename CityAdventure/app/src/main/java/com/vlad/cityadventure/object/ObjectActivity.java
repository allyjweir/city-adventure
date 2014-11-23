package com.vlad.cityadventure.object;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.adventure.AdventureMenuAdapter;
import com.vlad.cityadventure.dashboard.DashboardAdventureFragment;
import com.vlad.cityadventure.dashboard.DashboardRecommendFragment;
import com.vlad.cityadventure.utils.Utils;

public class ObjectActivity extends FragmentActivity implements ObjectAvhievementFragment.OnObjectFragmentInteractionListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private String title;//todo should contain a reference to the actual object, such as a city or landmark or user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        title = getIntent().getStringExtra("TITLE");
        ((TextView) findViewById(R.id.object_title)).setText(title);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.object_achievement_container, ObjectAvhievementFragment.newInstance("vlad"));
            transaction.add(R.id.object_task_container, ObjectTaskFragment.newInstance("vlad"));
            transaction.commit();
        }

        setupActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.object_drawer_layout);
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


        mDrawerList = (ListView) findViewById(R.id.object_left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new AdventureMenuAdapter());
        // Set the list's click listener
        Utils.setMenuListener(mDrawerList, this);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");//gets the font ttf file from assets
        TextView title = (TextView) findViewById(R.id.quiz_button);
        title.setTypeface(tf);//sets the font for these views
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //deals with the slide out drawer clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //todo
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

        ab.setDisplayHomeAsUpEnabled(false);
        ab.setHomeButtonEnabled(true);
    }
}
