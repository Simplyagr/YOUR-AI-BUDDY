package com.example.newnavigation;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class ThirdActivity extends BaseActivity implements View.OnClickListener {

    private long timeCountInMilliSeconds = 1 * 60000;
    private long timeLeft = 0;

    private enum TimerStatus {
        STARTED,
        STOPPED

    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private ProgressBar progressBarCircle;
    private EditText editTextMinute;
    private TextView textViewTime;
    private ImageView imageViewStart;
    private ImageView imageViewPauseResume;
    private ImageView imageViewStop;
    private CountDownTimer countDownTimer;

    private RadioButton r1, r2, r3, r4;
    public static View natureGif;
    public static View fireGif;
    public static View whaleGif;
    public static View acousticGuitarGif;
    private TextView textViewMusic;
    // gif size: width: 360px, height: 640px

    private MediaPlayer ring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_third, null, false);
        drawer.addView(contentView, 0);
        navigationView.setCheckedItem(R.id.nav_activity3);
        fab.hide();

        // method call to initialize the views
        initViews();
        // method call to initialize the listeners
        initListeners();


        natureGif.setVisibility(View.VISIBLE);
        fireGif.setVisibility(View.GONE);
        whaleGif.setVisibility(View.GONE);
        acousticGuitarGif.setVisibility(View.GONE);

        changeTextColorRadio();
        textViewMusic.setTextColor(Color.BLACK);

        //default music as nature
        r1.setChecked(true);
        ring = MediaPlayer.create(ThirdActivity.this, R.raw.waterfall);
    }

    //method to initialize the views
    private void initViews() {
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        editTextMinute = (EditText) findViewById(R.id.editTextMinute);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        imageViewStart = (ImageView) findViewById(R.id.imageViewStart);
        imageViewPauseResume = (ImageView) findViewById(R.id.imageViewPauseResume );
        imageViewStop = (ImageView) findViewById(R.id.imageViewStop);
        textViewMusic = (TextView) findViewById(R.id.textViewMusic);
        r1 = (RadioButton) findViewById(R.id.nature);
        r2 = (RadioButton) findViewById(R.id.fire);
        r3 = (RadioButton) findViewById(R.id.whale);
        r4 = (RadioButton) findViewById(R.id.acousticGuitar);
        natureGif = (View) findViewById(R.id.natureGif);
        fireGif = (View) findViewById(R.id.fireGif);
        whaleGif = (View) findViewById(R.id.whaleGif);
        acousticGuitarGif = (View) findViewById(R.id.acousticGuitarGif);
    }

    //method to initialize the click listeners
    private void initListeners() {
        imageViewStart.setOnClickListener(this);
        imageViewPauseResume.setOnClickListener(this);
        imageViewStop.setOnClickListener(this);
    }

    private void changeTextColorRadio(){
        textViewMusic.setTextColor(Color.WHITE);
        r1.setTextColor(Color.WHITE);
        r2.setTextColor(Color.WHITE);
        r3.setTextColor(Color.WHITE);
        r4.setTextColor(Color.WHITE);
    }
    public void onClickedNature(View view) {
        ring.pause();
        ring = MediaPlayer.create(ThirdActivity.this, R.raw.waterfall);
        ring.start();
        changeTextColorRadio();
        textViewMusic.setTextColor(Color.BLACK);
        natureGif.setVisibility(View.VISIBLE);
        fireGif.setVisibility(View.GONE);
        whaleGif.setVisibility(View.GONE);
        acousticGuitarGif.setVisibility(View.GONE);
    }
    public void onClickedFire(View view) {
        ring.pause();
        ring = MediaPlayer.create(ThirdActivity.this, R.raw.fire);
        ring.start();
        changeTextColorRadio();
        fireGif.setVisibility(View.VISIBLE);
        natureGif.setVisibility(View.GONE);
        whaleGif.setVisibility(View.GONE);
        acousticGuitarGif.setVisibility(View.GONE);
    }
    public void onClickedWhale(View view) {
        ring.pause();
        ring = MediaPlayer.create(ThirdActivity.this, R.raw.whale);
        ring.start();
        changeTextColorRadio();
        whaleGif.setVisibility(View.VISIBLE);
        natureGif.setVisibility(View.GONE);
        fireGif.setVisibility(View.GONE);
        acousticGuitarGif.setVisibility(View.GONE);
    }
    public void onClickedAcousticGuitar(View view) {
        ring.pause();
        ring = MediaPlayer.create(ThirdActivity.this, R.raw.acoustic_guitar);
        ring.start();
        changeTextColorRadio();
        acousticGuitarGif.setVisibility(View.VISIBLE);
        natureGif.setVisibility(View.GONE);
        fireGif.setVisibility(View.GONE);
        whaleGif.setVisibility(View.GONE);
    }

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewStart:
                start();
                break;
            case R.id.imageViewPauseResume:
                pauseResume();
                break;
            case R.id.imageViewStop:
                stop();
                break;
        }
    }

    //method to initialize the values for count down timer
    private void setTimerValues() {
        int time = 0;
        if (!editTextMinute.getText().toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {
            // toast message to fill edit text
            Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
        }
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = time * 60 * 1000;
    }

    //method to start count down timer
    private void start() {

        //if already started do not restart and exit
        if (timerStatus == TimerStatus.STARTED)
            return;


        ring.setLooping(true);
        ring.start();
        Toast.makeText(ThirdActivity.this, "Timer Set/Reset", Toast.LENGTH_SHORT).show();
        // call to initialize the timer values
        setTimerValues();
        // call to initialize the progress bar values
        setProgressBarValues();
        // making edit text not editable
        editTextMinute.setEnabled(false);
        // changing the timer status to started
        // changing reset icon to resume icon
        imageViewStart.setImageResource(R.drawable.icon_restart);
        timerStatus = TimerStatus.STARTED;

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));
                timeLeft = millisUntilFinished;
                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // changing stop icon to start icon
                imageViewStart.setImageResource(R.drawable.icon_restart);
                // making edit text editable
                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();

    }



    //method to pause count down timer
    private void resume() {

        ring.setLooping(true);
        ring.start();

        Toast.makeText(ThirdActivity.this, "Timer Resumed", Toast.LENGTH_SHORT).show();
        timeCountInMilliSeconds = timeLeft;

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));
                timeLeft = millisUntilFinished;
                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // changing stop icon to start icon
                imageViewStart.setImageResource(R.drawable.icon_resume);
                // making edit text editable
                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();
    }

    //method to pause count down timer
    private void pause() {
        ring.pause();
        Toast.makeText(ThirdActivity.this, "Timer Paused", Toast.LENGTH_SHORT).show();
        // making edit text editable
        editTextMinute.setEnabled(true);
        // changing the timer status to stopped
        timerStatus = TimerStatus.STOPPED;
        countDownTimer.cancel();
    }

    //method to pause or resume
    private void pauseResume() {
        if (timerStatus == TimerStatus.STOPPED) {
            // making edit text not editable
            editTextMinute.setEnabled(false);
            // changing resume icon to pause icon
            imageViewPauseResume.setImageResource(R.drawable.icon_pause);
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED;
            resume();

        }
        else {

            // changing pause icon to resume icon
            imageViewPauseResume.setImageResource(R.drawable.icon_resume);
            // enable resume button
            //imageViewResume.setEnabled(true);
            // making edit text editable
            editTextMinute.setEnabled(true);
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            pause();

        }
    }

    //method to stop count down timer
    private void stop() {
        ring.pause();
        if (timerStatus == TimerStatus.STARTED){
            Toast.makeText(ThirdActivity.this, "Timer Cancelled", Toast.LENGTH_SHORT).show();
            // making edit text editable
            editTextMinute.setEnabled(true);
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            countDownTimer.cancel();
        }

    }

    //method to set circular progress bar values
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }

    public void onBackPressed() {
        ring.pause();
        this.finish();
    }
    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;

    }
}