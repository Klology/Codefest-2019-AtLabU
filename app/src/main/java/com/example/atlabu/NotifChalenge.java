package com.example.atlabu;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class NotifChalenge extends AppCompatActivity {
    /*private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_chalenge);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }*/ //old
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
    private boolean isMath;
    private Button buttonHolder;
    private View navBar;
    private long mTimeLeftInMillis;
    private long mTimeLeftForWarning;
    private Button submit;
    private TextView Question;
    private tester test = tester.getOurInstance();
    private Random r = new Random();
    private boolean exercise, brain, health;
    private int answer;


    ArrayList<String> exercises = Arrays.getExercise();
    ArrayList<String> brains = Arrays.getBrain();
    ArrayList<String> healths = Arrays.getHealth();

    public View onCreate(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_challange_me, container, false);

    }

    public void clock(View navBar) {
        exercise = test.getPs() || test.getPUs() || test.getSUs() || test.getSs();
        brain = test.getMs() || test.getRs();
        health = test.getSLEs() || test.getWs();
        if(!(brain || health || exercise)) {
            Toast toast = Toast.makeText(getApplicationContext(),"Profile has no challenge preferences saved!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        this.navBar = navBar;
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextViewCountDownPRIMARY = findViewById(R.id.textViewCountDown);
        mTextViewCountDownWARNING = findViewById(R.id.WARNING_NUMBER);
        Question = findViewById(R.id.Question);
        buttonHolder = findViewById(R.id.cButton);
        FirstRun = findViewById(R.id.SecondPanel);
        SecondRun = findViewById(R.id.INITIALCOUNTDOWN);
        mPostQuesRW = findViewById(R.id.Reading_Workout_Answer);
        mPostQuesMAT = findViewById(R.id.mat_layout);
        mTimeLeftForWarning = WARNING_TIME_LENGTH;
        mTimeLeftInMillis = CHALLENGE_TIME_LENGTH;
        buttonHolder.setVisibility(View.INVISIBLE);
        FirstRun.setVisibility(View.VISIBLE);
        navBar.setVisibility(View.INVISIBLE);
        startTimer1();

    }

    private void doExercise(){
        switch(r.nextInt(4)){
            case 0:
                if(test.getPUs()) {
                    ((TextView)findViewById(R.id.didYouDo)).setText("Did you do your push-ups?");
                    Question.setText(exercises.get(0));
                    break;
                }

            case 1:
                if(test.getSUs()) {
                    ((TextView)findViewById(R.id.didYouDo)).setText("Did you do your sit-ups?");
                    Question.setText(exercises.get(1));
                    break;
                }

            case 2:
                if(test.getSs()) {
                    ((TextView)findViewById(R.id.didYouDo)).setText("Did you do your squats?");
                    Question.setText(exercises.get(2));
                    break;
                }

            default:
                ((TextView)findViewById(R.id.didYouDo)).setText("Did you plank?");
                Question.setText(exercises.get(3));
                break;
        }

        isMath = false;
    }

    private void doHealth(){
        switch(r.nextInt(2)){
            case 0:
                if(test.getWs()) {
                    ((TextView)findViewById(R.id.didYouDo)).setText(healths.get(0));
                    break;
                }
            default:
                ((TextView)findViewById(R.id.didYouDo)).setText(healths.get(1));
                break;
        }

        mTimeLeftInMillis = 0;
        isMath = false;
    }

    private void doRead(){
        switch(r.nextInt(4)){
            case 0:
                Question.setText(brains.get(0));
                break;

            case 1:
                Question.setText(brains.get(1));
                break;

            case 2:
                Question.setText(brains.get(2));
                break;

            case 3:
                Question.setText(brains.get(3));
                break;

        }

        ((TextView)findViewById(R.id.didYouDo)).setText("Did you finish Reading?");
        isMath = false;
    }

    private void doMath(){
        isMath = true;

        String mathsing = "";
        int mNum1 = r.nextInt(10);
        int mNum2 = r.nextInt(10);

        switch(r.nextInt(3)){
            case 0:
                mathsing = " " + mNum1 + " + " + mNum2 +" ";
                Question.setText(mathsing);
                answer = mNum1 + mNum2;
                break;
            case 1:
                mathsing = " " + mNum1 + " - " + mNum2 +" ";
                Question.setText(mathsing);
                answer = mNum1 - mNum2;
                break;
            case 2:
                mathsing = " " + mNum1 + " X " + mNum2 +" ";
                Question.setText(mathsing);
                answer = mNum1 * mNum2;
                break;
        }

        mPostQuesMAT.setVisibility(View.VISIBLE);
        submit = findViewById(R.id.SubMath);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = ((EditText)findViewById(R.id.mathInput)).getText().toString();
                if ("".equals(input)){
                    Toast toast = Toast.makeText(getApplicationContext(),"Incorrect!", Toast.LENGTH_SHORT);
                    toast.show();

                } else if (answer == Integer.parseInt(input)) {
                    test.mutCash(getApplicationContext(),50);
                    Question.setText("Correct!");
                    Question.setTextColor(Color.GREEN);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }

    private void getChallenge(){
        switch(r.nextInt(3)){
            case 0:
                if(health){
                    doHealth();
                    break;
                }

            case 1:
                if(exercise){
                    doExercise();
                    break;
                }
            case 2:
                if(brain){

                    if(!test.getMs()){
                        doRead();
                        break;
                    } else {
                        switch (r.nextInt(2)) {
                            case 0:
                                if (test.getRs()) {
                                    doRead();
                                    break;
                                }
                            default:
                                doMath();
                        }
                        break;
                    }
                }
            default:
                getChallenge();

        }
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

                getChallenge();

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


                if(!isMath){
                    SecondRun.setVisibility(View.INVISIBLE);
                    mPostQuesRW.setVisibility(View.VISIBLE);
                    submit = findViewById(R.id.subYes);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            test.mutCash(getApplicationContext(),50);
                            mPostQuesRW.setVisibility(View.INVISIBLE);
                            buttonHolder.setVisibility(View.VISIBLE);
                            navBar.setVisibility(View.VISIBLE);

                        }
                    });
                    findViewById(R.id.subNo).setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            mPostQuesRW.setVisibility(View.INVISIBLE);
                            buttonHolder.setVisibility(View.VISIBLE);
                            navBar.setVisibility(View.VISIBLE);
                        }
                    });
                } else {

                    Question.setTextColor(Color.BLACK);
                    ((EditText)findViewById(R.id.mathInput)).setText("");
                    mPostQuesMAT.setVisibility(View.INVISIBLE);
                    buttonHolder.setVisibility(View.VISIBLE);
                    navBar.setVisibility(View.VISIBLE);
                }

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
