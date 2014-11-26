package com.vlad.cityadventure;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vlad.cityadventure.dashboard.DashboardActivity;
import com.vlad.cityadventure.utils.MockDatabase;
import com.vlad.cityadventure.utils.UserManager;

/**
 * The first activity the user sees
 * it simply contains the login EditTexts and a sign in button
 * has mock login logic
 */
public class StartupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        //todo temp
       // startActivity(new Intent(StartupActivity.this, DashboardActivity.class));

        ActionBar actionBar = getActionBar();
        if (actionBar != null) actionBar.hide();//hides the actionbar
        final Button login = (Button) findViewById(R.id.login_button);
        final EditText user = (EditText) findViewById(R.id.username_entry);
        final EditText password = (EditText) findViewById(R.id.password_entry);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(user.getText().toString(), password.getText().toString());
            }
        });

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");//gets the font ttf file from assets
        TextView title = (TextView) findViewById(R.id.startup_label);
        title.setTypeface(tf);//sets the font for these views
        login.setTypeface(tf);
        user.setTypeface(tf);
        password.setTypeface(tf);
    }

    private void login(String username, String password) {
        //should contact server and verify and then fetch data, we just mock it here
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your username and password!", Toast.LENGTH_SHORT).show();
        } else if (MockDatabase.getInstance().getUsers().containsKey(username)&&MockDatabase.getInstance().getUsers().get(username).getPassword().equals(password)) {
            UserManager.getInstance().setUser(MockDatabase.getInstance().getUsers().get(username));
            UserManager.getInstance().setuId(username);
            startActivity(new Intent(StartupActivity.this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Incorrect password. Please try again!", Toast.LENGTH_SHORT).show();
        }
    }
}
