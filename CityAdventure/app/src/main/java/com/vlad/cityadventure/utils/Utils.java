package com.vlad.cityadventure.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vlad.cityadventure.adventure.AdventureActivity;
import com.vlad.cityadventure.adventureselection.AdventureSelectionActivity;
import com.vlad.cityadventure.dashboard.DashboardActivity;
import com.vlad.cityadventure.dashboard.DashboardAdventureFragment;

/**
 * Created by Vladislavs on 23/11/2014.
 */
public class Utils {

    public static void setMenuListener(ListView menu, final Activity activity){
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ( position) {
                    case 1:
                        activity.startActivity(new Intent(activity, DashboardActivity.class));
                        break;
                    case 2:
                        //todo fetch adventure data and launch adventure activity
                        Intent intent = new Intent(activity, AdventureActivity.class);
                        intent.putExtra(DashboardAdventureFragment.ID, UserManager.getInstance().getUser().getCurrentAdventure());
                        activity.startActivity(intent);
                        break;
                    case 3:
                        Intent intent2 = new Intent(activity, AdventureSelectionActivity.class);
                        activity.startActivity(intent2);
                        break;
                    case 4:
                        String url2 = "http://allyjweir.github.io/city-adventure";
                        Intent help2 = new Intent(Intent.ACTION_VIEW);
                        help2.setData(Uri.parse(url2));
                        activity.startActivity(help2);
                        break;
                    case 5:
                        String url = "http://allyjweir.github.io/city-adventure/help";
                        Intent help = new Intent(Intent.ACTION_VIEW);
                        help.setData(Uri.parse(url));
                        activity.startActivity(help);
                        break;
                    case 6:
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", "zaharovs92v@gmail.com", null));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "City Adventure Android");
                        activity.startActivity(Intent.createChooser(emailIntent, "Send email..."));
                        break;
                    default:
                        //todo there cant be a default value as position will always be one of those, can redirect to website on default
                        break;

                }
            }
        });
    }
}
