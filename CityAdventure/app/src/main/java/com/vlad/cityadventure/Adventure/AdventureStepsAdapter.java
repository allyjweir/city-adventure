package com.vlad.cityadventure.adventure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import java.util.LinkedList;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class AdventureStepsAdapter extends BaseAdapter {
    private String[] landmarks;
    private LayoutInflater inflater;
    private int progress;
    private Activity activity;

    public AdventureStepsAdapter(String[] landmarks, int progress, Activity activity) {
        this.landmarks = landmarks;
        this.progress = progress;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return landmarks.length;
    }

    @Override
    public Landmark getItem(int position) {
        return MockDatabase.getInstance().getLandmarks().get(landmarks[position]);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getId(int position) {
        return landmarks[position];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));
        convertView = inflater.inflate(R.layout.row_adventure_location, parent, false);
        ((TextView) convertView.findViewById(R.id.adventure_location_title)).setText(getItem(position).getName());
        ((TextView) convertView.findViewById(R.id.adventure_location_description)).setText(getItem(position).getDescription());
        ((ImageView) convertView.findViewById(R.id.circle)).setImageResource(getItem(position).getIcon());
        if (progress>position){//if this landmark has been visited and completed change color to green, might want to have orange for partial completion as well
            convertView.findViewById(R.id.progress_line).setBackgroundColor(activity.getResources().getColor(R.color.city_green));
            convertView.findViewById(R.id.circle).setBackground(activity.getResources().getDrawable(R.drawable.green_circle));
        }
        convertView.findViewById(R.id.directions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?daddr={lat},{long}"
                        .replace("{lat}", Float.toString(getItem(position).getLatitude()))
                        .replace("{long}", Float.toString(getItem(position).getLongitude()));
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(url));
                activity.startActivity(intent);
            }
        });
        return convertView;

    }
}
