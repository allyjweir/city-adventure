package com.vlad.cityadventure.object;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.utils.MockDatabase;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class ObjectTaskAdapter extends BaseAdapter {
    private String[] options;
    private LayoutInflater inflater;

    public ObjectTaskAdapter(String[] options) {
        this.options = options;

    }

    @Override
    public int getCount() {
        return options.length;
    }

    @Override
    public String getItem(int position) {
        return options[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getId(int position) {
        return options[position];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));
        convertView = inflater.inflate(R.layout.row_question_option, parent, false);
        ((TextView) convertView.findViewById(R.id.option_text)).setText(getItem(position));
        return convertView;

    }
}
