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
public class AdventureMenuAdapter extends BaseAdapter {
    private String[] menuTitles;
    private LayoutInflater inflater;

    public AdventureMenuAdapter(){
        menuTitles = new String[3];
        menuTitles[0] = menuTitles[1] = menuTitles[2] = "Test";

    }

    @Override
    public int getCount() {
        return menuTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return menuTitles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));

            convertView = inflater.inflate(R.layout.row_adventure_option, parent, false);
        ((TextView) convertView.findViewById(R.id.menu_item_title)).setText(menuTitles[position]);
        return convertView;
    }
}
