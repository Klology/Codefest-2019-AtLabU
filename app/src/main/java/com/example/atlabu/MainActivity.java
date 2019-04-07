package com.example.atlabu;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button lButton;
    private ImageButton shopButton, articleButton, testimonialButton;
    private View curContent;
    private boolean SitingUp=false, PushingUp=false, Squating=false, Planking=false;
    private boolean Watering=false, Sleeping=false;
    ArrayList<String> Exers = new ArrayList<>();
    ArrayList<String> Brai = new ArrayList<>();
    ArrayList<String> Health = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            BottomNavigationView navigation;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //startActivity(new Intent(MainActivity.this, More.class));
                    changeContent(findViewById(R.id.more));
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    //startActivity(new Intent(MainActivity.this, Challange_me.class));
                    changeContent(findViewById(R.id.challange));
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    //startActivity(new Intent(MainActivity.this, profile.class));
                    changeContent(findViewById(R.id.profile));
                    return true;
            }
            return false;
        }
    };

    private View.OnClickListener lListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.navigation_notifications).callOnClick();
            EditText edit = findViewById(R.id.userNameSub);
            TextView text = findViewById(R.id.userNameDis);
            text.setText(edit.getText());
        }
    };

    private ImageButton makeMoreButton(final View view, ImageButton button){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changeContent(view);
            }
        });

        return button;
    }

    private void changeContent(View view){
        curContent.setVisibility(View.INVISIBLE);
        view.setVisibility(View.VISIBLE);
        curContent = view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.shop).setVisibility(View.INVISIBLE);
        findViewById(R.id.testimonial).setVisibility(View.INVISIBLE);
        findViewById(R.id.article).setVisibility(View.INVISIBLE);
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        findViewById(R.id.more).setVisibility(View.INVISIBLE);
        findViewById(R.id.challange).setVisibility(View.INVISIBLE);
        findViewById(R.id.profile).setVisibility(View.INVISIBLE);
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        curContent = findViewById(R.id.login);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        lButton = findViewById(R.id.LButton);
        lButton.setOnClickListener(lListener);
        shopButton = makeMoreButton(findViewById(R.id.shop), (ImageButton) findViewById(R.id.shopButton));
        articleButton = makeMoreButton(findViewById(R.id.article), (ImageButton) findViewById(R.id.articleButton));
        testimonialButton = makeMoreButton(findViewById(R.id.testimonial), (ImageButton) findViewById(R.id.testimonialButton));



////////////////////////////////////////////////////////////////////////////////////////////////////
        final Switch PushUp = findViewById(R.id.PUs);
        PushUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-Ups ON!", Toast.LENGTH_SHORT); toast.show();
                    PushingUp=true;
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-ups OFF", Toast.LENGTH_SHORT); toast.show();
                    PushingUp=false;
                }

                //Toast toast = Toast.makeText(getApplicationContext(), "This is a message displayed in a Toast", Toast.LENGTH_SHORT); toast.show();
            }
        });
        Switch SitUp = findViewById(R.id.SUs);
        SitUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Sit-Ups ON!", Toast.LENGTH_SHORT); toast.show();
                    SitingUp=true;
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Sit-ups OFF", Toast.LENGTH_SHORT); toast.show();
                    SitingUp=false;
                }            }
        });
        Switch Squ = findViewById(R.id.Ss);
        Squ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Squats ON!", Toast.LENGTH_SHORT); toast.show();
                    Squating=true;
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Squats OFF", Toast.LENGTH_SHORT); toast.show();
                    Squating=false;
                }            }
        });
        Switch plank = findViewById(R.id.Ps);
        plank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Plank ON!", Toast.LENGTH_SHORT); toast.show();
                    Planking=true;

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Plank OFF", Toast.LENGTH_SHORT); toast.show();
                    Planking=false;
                }            }
        });
        Switch Water = findViewById(R.id.Ws);
        Water.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Water ON!", Toast.LENGTH_SHORT); toast.show();
                    Watering=true;
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Water OFF", Toast.LENGTH_SHORT); toast.show();
                    Watering=false;
                }            }
        });
        Switch Sleep = findViewById(R.id.SleepS);
        Sleep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Toast toast = Toast.makeText(getApplicationContext(), "Sleep ON!", Toast.LENGTH_SHORT); toast.show();
                    Sleeping=true;

                    if(Sleeping) {
                        Random r = new Random();
                        int i1 = r.nextInt(3 - 0);
                        if(i1==0){
 //                           Toast toast2 = Toast.makeText(getApplicationContext(), "working0 " + i1, Toast.LENGTH_SHORT); toast2.show();
                            Exers=Arrays.getExercise();
                            int i2 = r.nextInt(4 - 0);

                            Toast toast2 = Toast.makeText(getApplicationContext(), "working0 " + i2 + Exers.get(i2), Toast.LENGTH_SHORT); toast2.show();

                        }if(i1==1){
                            //Toast toast2 = Toast.makeText(getApplicationContext(), "working1 " + i1, Toast.LENGTH_SHORT); toast2.show();

                            Brai=Arrays.getBrain();
                            int i3 = r.nextInt(5 - 0);

                            Toast toast2 = Toast.makeText(getApplicationContext(), "working0 " + i3 + Brai.get(i3), Toast.LENGTH_SHORT); toast2.show();

                        }if(i1==2){
                            //Toast toast2 = Toast.makeText(getApplicationContext(), "working2 " + i1, Toast.LENGTH_SHORT); toast2.show();
                            Health=Arrays.getHealth();
                            int i4 = r.nextInt(3 - 0);

                            Toast toast2 = Toast.makeText(getApplicationContext(), "working0 " + i4 + Health.get(i4), Toast.LENGTH_SHORT); toast2.show();

                        }
                        //Toast toast2 = Toast.makeText(getApplicationContext(), "working " + i1, Toast.LENGTH_SHORT); toast2.show();
                    }


                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Sleep OFF", Toast.LENGTH_SHORT); toast.show();
                    Sleeping=false;
                }            }
        });

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //new section
    ////////////////////////////////////////////////////////////////////////////////////////////////
         //boolean polder = true;



    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void changeV(){

        changeContent(findViewById(R.id.more));
    }

}
