package com.example.atlabu;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Button;
import java.util.Locale;

public class Challange_me extends Fragment {

    private static final long CHALLENGE_TIME_LENGTH = 6000;
    private static final long WARNING_TIME_LENGTH = 6000;
    private RelativeLayout FirstRun;
    private RelativeLayout SecondRun;
    private TextView mTextViewCountDownPRIMARY;
    private TextView mTextViewCountDownWARNING;
    private CountDownTimer Running1;
    private CountDownTimer Running2;
    private TextView mTextMessage;
    private Button buttonHolder;
    private View navBar;
    private long mTimeLeftInMillis;
    private long mTimeLeftForWarning;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_challange_me, container, false);
    }

    public void clock(View navBar) {
        this.navBar = navBar;
        mTextMessage = (TextView) getView().findViewById(R.id.message);
        mTextViewCountDownPRIMARY = getView().findViewById(R.id.textViewCountDown);
        mTextViewCountDownWARNING = getView().findViewById(R.id.WARNING_NUMBER);
        buttonHolder = getView().findViewById(R.id.cButton);
        FirstRun = getView().findViewById(R.id.SecondPanel);
        SecondRun = getView().findViewById(R.id.INITIALCOUNTDOWN);
        mTimeLeftForWarning = WARNING_TIME_LENGTH;
        mTimeLeftInMillis = CHALLENGE_TIME_LENGTH;
        buttonHolder.setVisibility(View.INVISIBLE);
        FirstRun.setVisibility(View.VISIBLE);
        navBar.setVisibility(View.INVISIBLE);
        startTimer1();
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
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                SecondRun.setVisibility(View.INVISIBLE);
                buttonHolder.setVisibility(View.VISIBLE);
                navBar.setVisibility(View.VISIBLE);
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