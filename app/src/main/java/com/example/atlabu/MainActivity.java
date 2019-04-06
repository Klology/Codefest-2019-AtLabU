package com.example.atlabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button lButton;
    private View curContent;



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
            changeContent(findViewById(R.id.challange));
        }
    };

    private void changeContent(View view){
        curContent.setVisibility(View.INVISIBLE);
        view.setVisibility(View.VISIBLE);
        curContent = view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.more).setVisibility(View.INVISIBLE);
        findViewById(R.id.challange).setVisibility(View.INVISIBLE);
        findViewById(R.id.profile).setVisibility(View.INVISIBLE);
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        curContent = findViewById(R.id.login);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        lButton = findViewById(R.id.LButton);
        lButton.setOnClickListener(lListener);



        Switch mySwitch = findViewById(R.id.PUs);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //changeContent(getView().findViewById(R.id.challange));
                //Toast toast = Toast.makeText(this, "This is a message displayed in a Toast");
                //toast.show();
                // MainActivity.ChangeV();
                String mess = "message";
                Toast toast = Toast.makeText(getApplicationContext(), "This is a message displayed in a Toast", Toast.LENGTH_SHORT); toast.show();
                //Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void changeV(){

        changeContent(findViewById(R.id.more));
    }

}
