package com.example.atlabu;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem
import android.widget.RelativeLayout;
import android.widget.Button;
import java.util.Locale;

public class Challange_me extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_challange_me, container, false);
    }

    private static final long CHALLENGE_TIME_LENGTH = 60000;
    private static final long WARNING_TIME_LENGTH = 6000;
    private RelativeLayout FirstRun;
    private RelativeLayout SecondRun;
    private TextView mTextViewCountDownPRIMARY;
    private TextView mTextViewCountDownWARNING;
    private CountDownTimer Running1;
    private CountDownTimer Running2;
    private TextView mTextMessage;
    private Button buttonHolder;
    private long mTimeLeftInMillis = CHALLENGE_TIME_LENGTH;
    private long mTimeLeftForWarning = WARNING_TIME_LENGTH;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    startActivity(new Intent(Challange_me.this, More.class));
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    startActivity(new Intent(Challange_me.this, Challange_me.class));
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    startActivity(new Intent(Challange_me.this, profile.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challange_me);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextViewCountDownPRIMARY = findViewById(R.id.textViewCountDown);
        mTextViewCountDownWARNING = findViewById(R.id.WARNING_NUMBER);
        buttonHolder = findViewById(R.id.cButton);
        FirstRun = findViewById(R.id.SecondPanel);
        SecondRun = findViewById(R.id.INITIALCOUNTDOWN);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        buttonHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e(TAG, "onClick: ");
                FirstRun.setVisibility(View.VISIBLE);
                startTimer1();
                //mTextViewCountDownPRIMARY.setVisibility(View.VISIBLE);
                //startTimer2();

            }

        });
    }


    private void startTimer1() {

        Running1  = new CountDownTimer (mTimeLeftForWarning, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftForWarning = millisUntilFinished;
                updateCountDownWarningText();

            }

            @Override
            public void onFinish() {
                FirstRun.setVisibility(View.INVISIBLE);
                cancel();
                SecondRun.setVisibility(View.VISIBLE);
                startTimer2();
            }
        }.start();
        updateCountDownWarningText();
    }
    private void startTimer2() {

        Running2  = new CountDownTimer (mTimeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUntilFinished){
                mTimeLeftInMillis =millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                cancel();

            }
        }.start();
        updateCountDownText();
    }
    private void updateCountDownWarningText(){
        int minutes = (int) (mTimeLeftForWarning / 1000) / 60;
        int seconds = (int) (mTimeLeftForWarning / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDownWARNING.setText(timeLeftFormatted);

    }
    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDownPRIMARY.setText(timeLeftFormatted);
    }
}