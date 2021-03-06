package com.example.atlabu;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
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
    private Articles articles;
    private Shop shop;
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
                    ((TextView)findViewById(R.id.menuScore)).setText("Score: " + test.getCash());
                    ((TextView)findViewById(R.id.shopScore)).setText("Score: " + test.getCash());
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

    private View.OnClickListener articleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeContent(findViewById(R.id.article));
            articles.init();
        }
    };


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
            Toast toast = Toast.makeText(getApplicationContext(),"Saved! go do a challenge!", Toast.LENGTH_SHORT); toast.show();
            //doNotif("try");

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
        shop = (Shop) fm.findFragmentById(R.id.shop);
        articles = (Articles) fm.findFragmentById(R.id.article);
        navBar = findViewById(R.id.navBar);
        navBar.setVisibility(View.INVISIBLE);
        articles.init();

        articles.init();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        lButton = findViewById(R.id.LButton);
        lButton.setOnClickListener(lListener);
        findViewById(R.id.articleButton).setOnClickListener(articleListener);
        shopButton = makeMoreButton(findViewById(R.id.shop), (ImageButton) findViewById(R.id.shopButton));
        testimonialButton = makeMoreButton(findViewById(R.id.testimonial), (ImageButton) findViewById(R.id.testimonialButton));
        shop.setUpShop();
        findViewById(R.id.cButton).setOnClickListener(cListener);
        findViewById(R.id.subProfile).setOnClickListener(profListener);

        //if((int)SystemClock.currentThreadTimeMillis() >= 5){
            doNotif("A Workout");
        //}





    }
    public void doNotif(String title){
        //int check =0;

        /*NotificationManager notif = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "20")
                .setSmallIcon(R.drawable.thewiz3)
                .setContentTitle("Challenge available")
                .setContentText(title)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.build();*/
        //NotificationManager notif = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= 26)
        {
            NotificationManager notif = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            if(notif.getNotificationChannel("Notif_channel") == null)
            {
                CharSequence channel_name = "notif_ch_name";
                String description = "This is the channel for the notifications.";
                NotificationChannel channel = new NotificationChannel("Notif_channel", channel_name, NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription(description);
                notif.createNotificationChannel(channel);
            }
        }
        NotificationManagerCompat compat_manager = NotificationManagerCompat.from(getApplicationContext());
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
// Create the PendingIntent
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );


        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "Notif_channel");

                builder.setContentTitle("You Have A Challenge")
                .setContentText("Time for A Challenge! Click Here!")
                .setSmallIcon(R.drawable.thewiz2)
                .setContentIntent(notifyPendingIntent);

                Notification notification = builder.build();
        //notify.flags |= Notification.FLAG_AUTO_CANCEL;
        compat_manager.notify((int)SystemClock.currentThreadTimeMillis(), notification);


        //return check;
    }




}
