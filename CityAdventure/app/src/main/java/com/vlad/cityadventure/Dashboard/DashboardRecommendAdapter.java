package com.vlad.cityadventure.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.cityadventure.R;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class DashboardRecommendAdapter extends BaseAdapter {
    private String[] menuTitles;
    private LayoutInflater inflater;

    public DashboardRecommendAdapter(String userId) {
        menuTitles = getTags(userId);

    }

    //todo needs some meaningful logic to get the tags
    public String[] getTags(String id){
        return ("Food,Parks,Fast Food,Sushi,Acoustic Music,Shopping,Antique").split(",");
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

            convertView = inflater.inflate(R.layout.row_recommend, parent, false);
            ((TextView) convertView.findViewById(R.id.recommend_text)).setText(menuTitles[position]);
            return convertView;

    }
}
