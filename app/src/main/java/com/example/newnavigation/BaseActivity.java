package com.example.newnavigation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.newnavigation.onboardingOne.OnBoardingDesignOne;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

//import com.example.newnavigation.databinding.ActivityMainBinding;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawer;
    FloatingActionButton fab;
    NavigationView navigationView;
    View headerview;
    TextView username;
    final Context context = this;
    boolean showToast = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerview = navigationView.getHeaderView(0);
        username = (TextView) headerview.findViewById(R.id.nav_name);
        navigationView.setNavigationItemSelectedListener(this);

        headerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.layout_dialog, null);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder.setView(promptsView);



               // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton(Html.fromHtml("<a href=\"www.google.com\">OK</a>"),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        username.setText(userInput.getText());
                                    }
                                })
                        .setNegativeButton(Html.fromHtml("<a href=\"www.google.com\">Cancel</a>"),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }


    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", username.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("Preferences", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        username.setText(s1);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_activity1) {
            startAnimatedActivity(new Intent(getApplicationContext(), FirstActivity.class));
        } else if (id == R.id.nav_activity2) {
            startAnimatedActivity(new Intent(getApplicationContext(), SecondActivity.class));
        } else if (id == R.id.nav_activity3) {
            startAnimatedActivity(new Intent(getApplicationContext(), ThirdActivity.class));
        } else if (id == R.id.nav_activity4) {
            startAnimatedActivity(new Intent(getApplicationContext(), FourthActivity.class));
        } else if (id == R.id.nav_activity5) {
            startAnimatedActivity(new Intent(getApplicationContext(), FifthActivity.class));
        } else if (id == R.id.nav_activity6) {
            FirstActivity.buttonClick = "Yes";
            startAnimatedActivity(new Intent(getApplicationContext(), OnBoardingDesignOne.class));
        } else if (id == R.id.nav_activity7) {
            startAnimatedActivity(new Intent(getApplicationContext(), AboutUs.class));
        }else if (id == R.id.nav_activity8) {
            startAnimatedActivity(new Intent(getApplicationContext(), SeventhActivity.class));
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void startAnimatedActivity(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}