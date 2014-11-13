package com.vlad.cityadventure.Adventure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.cityadventure.R;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class AdventureStepsAdapter extends BaseAdapter {
    private String[] landmarks;//todo this should be either tasks or landmarks
    private LayoutInflater inflater;

    public AdventureStepsAdapter(String[] landmarks) {
        this.landmarks = landmarks;

    }

    @Override
    public int getCount() {
        return landmarks.length;
    }

    @Override
    public Object getItem(int position) {
        return landmarks[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));
        convertView = inflater.inflate(R.layout.row_adventure_location, parent, false);
        ((TextView) convertView.findViewById(R.id.adventure_location_title)).setText(landmarks[position]);
        ((TextView) convertView.findViewById(R.id.adventure_location_description)).setText("This is a landmark. Here you can find it's description and maybe an idea of what you could do here. Clicking on it will bring up the tasks associated with this landmark.");
        return convertView;

    }
}
