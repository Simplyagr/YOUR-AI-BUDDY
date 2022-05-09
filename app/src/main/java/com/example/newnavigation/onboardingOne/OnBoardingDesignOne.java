package com.example.newnavigation.onboardingOne;

import static com.example.newnavigation.FirstActivity.buttonClick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newnavigation.FirstActivity;
import com.example.newnavigation.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingDesignOne extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton buttonOnboardingAction;
    public static SharedPreferences sharedpreferences;
    public static Boolean bool = Boolean.FALSE;

    @Override
    protected void onResume() {
        super.onResume();

        sharedpreferences = getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
        if(!sharedpreferences.getBoolean("FirstTimeInstall", bool) || buttonClick=="Yes")  //first condition is if application is opened for first time
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            bool = Boolean.TRUE;
            editor.putBoolean("FirstTimeInstall", bool);
            editor.apply();
        }
        else {
            Intent intent = new Intent(OnBoardingDesignOne.this, FirstActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_design_one);

        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardingAction);

        setOnboardingItem();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setOnboadingIndicator();
        setCurrentOnboardingIndicators(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                    finish();
                }
            }
        });
    }

    private void setOnboadingIndicator() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicators(int index) {
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive));
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1){
            buttonOnboardingAction.setText("Start");
        }else {
            buttonOnboardingAction.setText("Next");
        }
    }

    private void setOnboardingItem() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem welcome = new OnBoardingItem();
        welcome.setTitle("Hello!!!");
        welcome.setDescription("Let's take a look at some of our features!");
        welcome.setImage(R.drawable.welcome);

        OnBoardingItem chatbot = new OnBoardingItem();
        chatbot.setTitle("Chatbot AI");
        chatbot.setDescription("‘How are you feeling?’, such a rare question nowadays. Not anymore. Our personalized chat-bot is made to help you. Based on your initial input, the bot deciphers how to assist you further through text. You can also scroll horizontally to avail the ‘others’ option, allowing you to type your message in an elaborate way.");
        chatbot.setImage(R.drawable.chatbot);

        OnBoardingItem meditate = new OnBoardingItem();
        meditate.setTitle("Meditate");
        meditate.setDescription("Meditation is a practice in which an individual uses mindfulness, focus to train attention and awareness. Our meditate tab helps you achieve the same. You can select the audio of your choice and set in the amount of time (in minutes). You can pause, restart and stop the music according to your need.");
        meditate.setImage(R.drawable.meditate);

        OnBoardingItem goals = new OnBoardingItem();
        goals.setTitle("My goals");
        goals.setDescription("Pending tasks? Incomplete assignments? Let’s get it done! Click on the plus icon and add your task in our to-do list. You can swipe right, if you want to edit the text. You can swipe left, if you want to delete any task. After completion, you can tick your completed task. Good job!");
        goals.setImage(R.drawable.goal);

        OnBoardingItem faq = new OnBoardingItem();
        faq.setTitle("FAQs");
        faq.setDescription("Confused about your privacy? Worried about your data? Curious how this application works? Want to know who we are? Check out the FAQs (Frequently Asked Questions) and know for yourself!");
        faq.setImage(R.drawable.faq);

        onBoardingItems.add(welcome);
        onBoardingItems.add(chatbot);
        onBoardingItems.add(meditate);
        onBoardingItems.add(goals);
        onBoardingItems.add(faq);

        onboardingAdapter = new OnboardingAdapter(onBoardingItems);

    }
}