package com.vlad.cityadventure.dashboard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.utils.MockDatabase;

import java.util.ArrayList;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class ObjectTaskAdapter extends BaseAdapter {
    private ArrayList<String> tasks;
    private LayoutInflater inflater;
    private String user;
    private Activity activity;
    private boolean showAll;

    public ObjectTaskAdapter(ArrayList<String> tasks, String user, Activity activity, boolean showAll) {
        this.showAll = showAll;
        this.user = user;
        this.tasks = tasks;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        if (tasks == null) return 0;
        else if (!showAll||tasks.size()<4){
            return 4;
        }
        else
            return tasks.size();
    }

    @Override
    public String getItem(int position) {
        return tasks.get(position);
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
        ((TextView) convertView.findViewById(R.id.task_text)).setText(MockDatabase.getInstance().getTasks().get(tasks.get(position)).getDescription());
        ((TextView) convertView.findViewById(R.id.task_text_number)).setText(position+1+")");
        if (MockDatabase.getInstance().getUsers().get(user).getCompleteTasks().contains(tasks.get(position))){
            ((TextView) convertView.findViewById(R.id.task_text)).setTextColor(activity.getResources().getColor(R.color.green));
        }
        return convertView;

    }
}
