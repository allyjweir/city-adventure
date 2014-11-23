package com.vlad.cityadventure.adventure;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.Landmark;

import java.util.LinkedList;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class AdventureStepsAdapter extends BaseAdapter {
    private LinkedList<Landmark> landmarks;
    private LayoutInflater inflater;
    private int progress;
    private Activity activity;

    public AdventureStepsAdapter(LinkedList<Landmark> landmarks, int progress, Activity activity) {
        this.landmarks = landmarks;
        this.progress = progress;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return landmarks.size();
    }

    @Override
    public Landmark getItem(int position) {
        return landmarks.get(position);
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
        ((TextView) convertView.findViewById(R.id.adventure_location_title)).setText(landmarks.get(position).getName());
        ((TextView) convertView.findViewById(R.id.adventure_location_description)).setText(landmarks.get(position).getDescription());
        if (progress>position){//if this landmark has been visited and completed change color to green, might want to have orange for partial completion as well
            convertView.findViewById(R.id.progress_line).setBackgroundColor(activity.getResources().getColor(R.color.city_green));
            convertView.findViewById(R.id.circle).setBackground(activity.getResources().getDrawable(R.drawable.green_circle));
        }
        return convertView;

    }
}
