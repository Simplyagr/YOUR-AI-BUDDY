package com.example.newnavigation;

import static com.example.newnavigation.onboardingOne.OnBoardingDesignOne.bool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.newnavigation.onboardingOne.OnBoardingDesignOne;

public class FirstActivity extends BaseActivity {

    public static String buttonClick="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        @SuppressLint("InflateParams")
        View contentView = inflater.inflate(R.layout.activity_first, null, false);
        drawer.addView(contentView, 0);
        navigationView.setCheckedItem(R.id.nav_activity1);

        //the below lines basically print hello first activity if we click on the email icon
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatbot = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(chatbot);
            }
        });
        defineButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //exit app
        if(id == R.id.action_exit)
        {
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            } else {
                super.onBackPressed();
            }
        }
    }

    public void defineButtons() {
        findViewById(R.id.chatbotai).setOnClickListener(buttonClickListener);
        findViewById(R.id.meditate).setOnClickListener(buttonClickListener);
        findViewById(R.id.mygoals).setOnClickListener(buttonClickListener);
        findViewById(R.id.faqs).setOnClickListener(buttonClickListener);
        findViewById(R.id.howToUse).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.chatbotai:
                    Intent intent1 = new Intent(FirstActivity.this, SecondActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.meditate:
                    Intent intent2 = new Intent(FirstActivity.this, ThirdActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.mygoals:
                    Intent intent3 = new Intent(FirstActivity.this, FourthActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.faqs:
                    Intent intent4 = new Intent(FirstActivity.this, FifthActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.howToUse:
                    buttonClick = "Yes";
                    OnBoardingDesignOne.sharedpreferences.getBoolean("yes", bool);
                    Intent intent5 = new Intent(FirstActivity.this, OnBoardingDesignOne.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
}