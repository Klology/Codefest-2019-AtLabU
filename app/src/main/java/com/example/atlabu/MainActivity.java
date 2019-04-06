package com.example.atlabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button lButton;
    FragmentManager fragmentManager = getSupportFragmentManager();



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            BottomNavigationView navigation;
            FragmentTransaction ft = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //startActivity(new Intent(MainActivity.this, More.class));
                    ft.replace(R.id.content, new More());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    //startActivity(new Intent(MainActivity.this, Challange_me.class));
                    ft.replace(R.id.content, new Challange_me());
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    //startActivity(new Intent(MainActivity.this, profile.class));
                    ft.replace(R.id.content, new profile());
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        setContentView(R.layout.activity_main);
        /*lButton=findViewById(R.id.LButton);
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Challange_me.class));
            }
        });
        mTextMessage = (TextView) findViewById(R.id.message);*/
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ft.add(R.id.content, new Login());
        ft.commit();

    }

}
