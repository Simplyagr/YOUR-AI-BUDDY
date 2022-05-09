package com.example.newnavigation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends BaseActivity {

    Context context = AboutUs.this;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_about_us, null, false);
        drawer.addView(contentView, 0);
        navigationView.setCheckedItem(R.id.nav_activity2);
        fab.hide();

        alertDialog = new AlertDialog.Builder(context).create();
        defineImages();

    }
    public void defineImages() {
        findViewById(R.id.chaitali).setOnClickListener(imageClickListener);
        findViewById(R.id.aryan).setOnClickListener(imageClickListener);
        findViewById(R.id.arya).setOnClickListener(imageClickListener);
        findViewById(R.id.nimisha).setOnClickListener(imageClickListener);
    }
    private View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.chaitali:
                    alertDialog.setTitle("Chaitali Gaikwad");
                    alertDialog.setMessage(Html.fromHtml("<a href=\"https://github.com/chaitali-gaikwad\">Github</a>"));
                    alertDialog.show();
                    ((TextView)alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case R.id.aryan:
                    alertDialog.setTitle("Aryan Raje");
                    alertDialog.setMessage(Html.fromHtml("<a href=\"https://github.com/Simplyagr\">GitHub</a>"));
                    alertDialog.show();
                    ((TextView)alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case R.id.arya:
                    alertDialog.setTitle("Arya Raje");
                    alertDialog.setMessage(Html.fromHtml("<a href=\"https://github.com/AryaRaje\">GitHub</a>"));
                    alertDialog.show();
                    ((TextView)alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case R.id.nimisha:
                    alertDialog.setTitle("Nimisha Gharat");
                    alertDialog.setMessage(Html.fromHtml("<a href=\"https://github.com/NimishaGharat\">GitHub</a>"));
                    alertDialog.show();
                    ((TextView)alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
                    break;
            }
        }
    };
}