package com.example.atlabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
=======
import android.widget.EditText;
import android.widget.TextView;
>>>>>>> f4fd653231feeba9de21214cbda3732dbc044479

public class MainActivity extends AppCompatActivity {

    private Button lButton;
    private Button shopButton;
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
            findViewById(R.id.navigation_notifications).callOnClick();
            EditText edit = findViewById(R.id.userNameSub);
            TextView text = findViewById(R.id.userNameDis);
            text.setText(edit.getText());

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


////////////////////////////////////////////////////////////////////////////////////////////////////
        Switch mySwitch = findViewById(R.id.PUs);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-Ups ON!", Toast.LENGTH_SHORT); toast.show();

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-ups OFF", Toast.LENGTH_SHORT); toast.show();
                }

                //Toast toast = Toast.makeText(getApplicationContext(), "This is a message displayed in a Toast", Toast.LENGTH_SHORT); toast.show();
            }
        });
        Switch mySwitch2 = findViewById(R.id.PUs);
        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-Ups ON!", Toast.LENGTH_SHORT); toast.show();

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-ups OFF", Toast.LENGTH_SHORT); toast.show();
                }            }
        });
        Switch mySwitch3 = findViewById(R.id.PUs);
        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-Ups ON!", Toast.LENGTH_SHORT); toast.show();

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-ups OFF", Toast.LENGTH_SHORT); toast.show();
                }            }
        });
        Switch mySwitch4 = findViewById(R.id.PUs);
        mySwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-Ups ON!", Toast.LENGTH_SHORT); toast.show();

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Push-ups OFF", Toast.LENGTH_SHORT); toast.show();
                }            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void changeV(){

        changeContent(findViewById(R.id.more));
    }

}
