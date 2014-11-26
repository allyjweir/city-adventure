package com.vlad.cityadventure.adventure;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.dashboard.DashboardAdventureFragment;
import com.vlad.cityadventure.object.ObjectActivity;
import com.vlad.cityadventure.utils.MockDatabase;
import com.vlad.cityadventure.utils.UserManager;
import com.vlad.cityadventure.utils.Utils;

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
        Utils.setMenuListener(mDrawerList, this);

        /** initializing the actual adventure activity views*/
        if (!setAdventure(getIntent().getStringExtra(DashboardAdventureFragment.ID)))
            finish();
        ListView adventureSteps = (ListView) findViewById(R.id.directions_list);
        adventureSteps.setAdapter(new AdventureStepsAdapter(adventure.getRoute(), progress, AdventureActivity.this));
        adventureSteps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo meaningful logic
                Intent intent = new Intent(AdventureActivity.this, ObjectActivity.class);
                intent.putExtra("ID", ((AdventureStepsAdapter) parent.getAdapter()).getId(position));
                startActivity(intent);
            }
        });

        setupMap();

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
        if (!UserManager.getInstance().getUser().getAdventures().contains(getIntent().getStringExtra(DashboardAdventureFragment.ID))){
            TextView join = (TextView) v.findViewById(R.id.join_adventure_button);
            join.setVisibility(View.VISIBLE);
            join.setTypeface(tf);
        }

        ab.setCustomView(v);

//        ab.setDisplayHomeAsUpEnabled(false); todo no idea why this is needed in this activity but not dashboard
        ab.setHomeButtonEnabled(true);
    }

    /**
     * Gets the adventure from the database based on its id
     * at the moment this is mocked
     */
    private boolean setAdventure(String adventureId){
        adventure = MockDatabase.getInstance().getAdventures().get(adventureId);
        progress = 1;
        return true;
    }

    public void setupMap(){

        GoogleMap googleMap;
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.adventure_map)).getMap();
        double lat = 55.871620;
        double lng = -4.289067;
        LatLng myLocation = new LatLng(lat, lng);//todo Glasgow Uni can use location manager instead, which is more time consuming
        CameraPosition cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(14.0f).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        for (String m : adventure.getRoute()){//adds marker for each location with title
            Landmark landm = MockDatabase.getInstance().getLandmarks().get(m);
            googleMap.addMarker(new MarkerOptions().position(new LatLng(landm.getLatitude(), landm.getLongitude())).title(landm.getName()));
        }
        googleMap.moveCamera(cameraUpdate);
    }
}
