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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Challange_me extends Fragment {

    private static final long CHALLENGE_TIME_LENGTH = 6000;
    private static final long WARNING_TIME_LENGTH = 6000;
    private RelativeLayout FirstRun;
    private RelativeLayout SecondRun;
    private RelativeLayout mPostQuesRW;
    private RelativeLayout mPostQuesMAT;
    private TextView mTextViewCountDownPRIMARY;
    private TextView mTextViewCountDownWARNING;
    private CountDownTimer Running1;
    private CountDownTimer Running2;
    private TextView mTextMessage;
    private Button buttonHolder;
    private View navBar;
    private long mTimeLeftInMillis;
    private long mTimeLeftForWarning;

    private boolean SitingUp=false, PushingUp=false, Squating=false, Planking=false;
    private boolean Watering=false, Sleeping=false;


    ArrayList<String> Exers = new ArrayList<>();
    ArrayList<String> Brai = new ArrayList<>();
    ArrayList<String> Health = new ArrayList<>();

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
        mPostQuesRW = getView().findViewById(R.id.Reading_Workout_Answer);
        mPostQuesMAT = getView().findViewById(R.id.MAT_ANSWER);
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

                tester test = tester.getOurInstance();
                PushingUp=test.getPUs();
                SitingUp=test.getSUs();
                Planking=test.getPs();
                Squating=test.getSs();
                Watering=test.getWs();
                Sleeping=test.getSLEs();

                Random r = new Random();

                switch(r.nextInt(3)) {
                    case 0:

                        if(PushingUp || SitingUp || Planking || Squating){

                        }

                    case 1:
                        if(Watering || Sleeping){

                        }

                    case 2:

                        break;

                }
                /*
                if(i1==0){
                    int i2=4;
                    //                           Toast toast2 = Toast.makeText(getApplicationContext(), "working0 " + i1, Toast.LENGTH_SHORT); toast2.show();
                    Exers=Arrays.getExercise();
                    boolean running = true;
                    while(running){
                        i2 = r.nextInt(5);
                            /*exerciseList.add("Sit-Ups- Perform as many push-ups as you can in 1 Minute.");
                            exerciseList.add("Perform as many sit-ups as you can in 1 Minute.");
                            exerciseList.add("Perform as many squats as you can in 1 Minute.");
                            exerciseList.add("Perform as much of a one minute plank as you can.");
                            exerciseList.add("Free Style Exercise!!!!");*//*
                            if(PushingUp && i2==0){running = false;}
                            else if(SitingUp && i2==1){running = false;}
                            else if(Squating && i2==2){running = false;}
                            else if(Planking && i2==3){running = false;}
                            else if(i2==4){running = false;}
                            else{
                                running=true;
                            }
                    }
                    Watering=test.getWs();
                    Toast toast2 = Toast.makeText(getContext(), "working0 " + i2 + Exers.get(i2), Toast.LENGTH_SHORT); toast2.show();

                }if(i1==1){
                    Toast toast2 = Toast.makeText(getContext(), "working1 " + i1, Toast.LENGTH_SHORT); toast2.show();

                    Brai=Arrays.getBrain();
                    int i3 = r.nextInt(5);

                   Toast toast3 = Toast.makeText(getContext(), "working0 " + i3 + Brai.get(i3), Toast.LENGTH_SHORT); toast3.show();

                }if(i1==2){
                    //Toast toast2 = Toast.makeText(getApplicationContext(), "working2 " + i1, Toast.LENGTH_SHORT); toast2.show();
                    Health=Arrays.getHealth();
                    int i4 = r.nextInt(3);

                    Toast toast2 = Toast.makeText(getContext(), "working0 " + i4 + Health.get(i4), Toast.LENGTH_SHORT); toast2.show();

                }
                //Toast toast2 = Toast.makeText(getApplicationContext(), "working " + i1, Toast.LENGTH_SHORT); toast2.show();

*/
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
                int isMath = 1;
                if(isMath ==0) {
                    buttonHolder.setVisibility(View.INVISIBLE);
                    mPostQuesRW.setVisibility(View.VISIBLE);
                }
                else{
                    buttonHolder.setVisibility(View.INVISIBLE);
                    mPostQuesMAT.setVisibility(View.VISIBLE);
                }

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