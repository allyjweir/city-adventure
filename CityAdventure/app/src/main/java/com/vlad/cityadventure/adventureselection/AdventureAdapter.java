package com.vlad.cityadventure.adventureselection;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.utils.MockDatabase;

import java.util.HashMap;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class AdventureAdapter extends BaseAdapter {
    private String[] adventures;
    private LayoutInflater inflater;
    private Activity activity;

    public AdventureAdapter(Activity activity) {
        adventures = "UKGLAHA01,UKGLAHA02,UKGLAHA03,UKGLAHA04,UKGLAHA05,UKGLAHA06".split(",");//todo hardcoded for now
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return adventures.length;
    }

    @Override
    public Adventure getItem(int position) {
        return MockDatabase.getInstance().getAdventures().get(adventures[position]);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getId(int position) {
        return adventures[position];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));
        convertView = inflater.inflate(R.layout.row_adventure, parent, false);
        ((TextView) convertView.findViewById(R.id.adventure_title)).setText(getItem(position).getTitle());
        ((TextView) convertView.findViewById(R.id.adventure_description)).setText(getItem(position).getDescription());
        ((ImageView) convertView.findViewById(R.id.adventure_icon)).setImageResource(getItem(position).getIcon());

        return convertView;

    }
}
