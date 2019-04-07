package com.example.atlabu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.prefs.Preferences;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private Challange_me challange_me;
    private Button lButton;
    private ImageButton shopButton, articleButton, testimonialButton;
    private View curContent, navBar;
    private tester test = tester.getOurInstance();


    //SharedPreferences sharedPref = MainActivity.this.getAct().getPreferences(Context.MODE_PRIVATE);


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
                    setProfile();
                    changeContent(findViewById(R.id.profile));
                    return true;
            }
            return false;
        }
    };

    private View.OnClickListener cListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            challange_me.clock(navBar);
        }
    };

    private View.OnClickListener lListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.navigation_notifications).callOnClick();
            EditText edit = findViewById(R.id.userNameSub);
            TextView text = findViewById(R.id.userNameDis);
            text.setText(edit.getText());
            navBar.setVisibility(View.VISIBLE);
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


    private void setProfile(){
        ((CompoundButton)findViewById(R.id.Ms)).setChecked(test.getMs());
        ((CompoundButton)findViewById(R.id.SleepS)).setChecked(test.getSLEs());
        ((CompoundButton)findViewById(R.id.Ss)).setChecked(test.getSs());
        ((CompoundButton)findViewById(R.id.SUs)).setChecked(test.getSUs());
        ((CompoundButton)findViewById(R.id.Ps)).setChecked(test.getPs());
        ((CompoundButton)findViewById(R.id.PUs)).setChecked(test.getPUs());
        ((CompoundButton)findViewById(R.id.Ws)).setChecked(test.getWs());
        ((CompoundButton)findViewById(R.id.Rs)).setChecked(test.getRs());
    }

    private View.OnClickListener profListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            test.setMs(((CompoundButton)findViewById(R.id.Ms)).isChecked());
            test.setSLEs(((CompoundButton)findViewById(R.id.SleepS)).isChecked());
            test.setSs(((CompoundButton)findViewById(R.id.Ss)).isChecked());
            test.setSUs(((CompoundButton)findViewById(R.id.SUs)).isChecked());
            test.setPs(((CompoundButton)findViewById(R.id.Ps)).isChecked());
            test.setPUs(((CompoundButton)findViewById(R.id.PUs)).isChecked());
            test.setWs(((CompoundButton)findViewById(R.id.Ws)).isChecked());
            test.setRs(((CompoundButton)findViewById(R.id.Rs)).isChecked());

        }
    };

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
        challange_me = (Challange_me) fm.findFragmentById(R.id.challange);
        navBar = findViewById(R.id.navBar);
        navBar.setVisibility(View.INVISIBLE);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        lButton = findViewById(R.id.LButton);
        lButton.setOnClickListener(lListener);
        shopButton = makeMoreButton(findViewById(R.id.shop), (ImageButton) findViewById(R.id.shopButton));
        articleButton = makeMoreButton(findViewById(R.id.article), (ImageButton) findViewById(R.id.articleButton));
        testimonialButton = makeMoreButton(findViewById(R.id.testimonial), (ImageButton) findViewById(R.id.testimonialButton));
        findViewById(R.id.cButton).setOnClickListener(cListener);
        findViewById(R.id.subProfile).setOnClickListener(profListener);


    }


}
