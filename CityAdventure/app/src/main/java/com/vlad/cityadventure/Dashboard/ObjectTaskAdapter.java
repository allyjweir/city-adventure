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
public class ObjectTaskAdapter extends BaseAdapter {
    private String[] tasks;
    private LayoutInflater inflater;

    public ObjectTaskAdapter(String[] tasks) {
        this.tasks = tasks;

    }

    @Override
    public int getCount() {
        return tasks.length;
    }

    @Override
    public Object getItem(int position) {
        return tasks[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));

            convertView = inflater.inflate(R.layout.row_task, parent, false);
            ((TextView) convertView.findViewById(R.id.task_text)).setText(tasks[position]);
            return convertView;

    }
}
