package com.example.newnavigation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SeventhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        finishAffinity();

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle(Html.fromHtml("<a href=\"www.google.com\">Are you sure you want to exit?</a>"))
                .setCancelable(false)
                .setPositiveButton(Html.fromHtml("<a href=\"www.google.com\">Yes</a>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton(Html.fromHtml("<a href=\"www.google.com\">No</a>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        SeventhActivity.this.finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();*/
    }
}