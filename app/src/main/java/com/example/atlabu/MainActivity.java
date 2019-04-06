package com.example.atlabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("More!");
                    startActivity(new Intent(MainActivity.this, More.class));



                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("Challenge Me!");
                    //startActivity(new Intent(MainActivity.this, My_Courses.class));
                    startActivity(new Intent(MainActivity.this, Challange_me.class));
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Profile");
                    startActivity(new Intent(MainActivity.this, profile.class));
                    return true;
                    //startActivity(new Intent(MainActivity.this, profile.class));
                //startActivity(new Intent(MainActivity.this, Challange_me.class));
                //startActivity(new Intent(MainActivity.this, More.class));
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
