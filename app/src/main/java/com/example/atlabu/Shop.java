package com.example.atlabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class Shop extends Fragment {

    private tester test = tester.getOurInstance();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.activity_shop, container, false);
    }

    public void setUpShop(){
        getView().findViewById(R.id.coupon_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(test.getCash() >= 5) {
                    test.mutCash(getContext(),-5);
                    ((TextView)getView().findViewById(R.id.coupon_button)).setText("Code: 84790CHE");
                }
                else {
                    Toast toast = Toast.makeText(getContext(),"Not enough points!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                ((TextView)getView().findViewById(R.id.shopScore)).setText("Score: " + test.getCash());
            }
        });
        getView().findViewById(R.id.coupon_button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(test.getCash() >= 10) {
                    test.mutCash(getContext(),-10);
                    ((TextView)getView().findViewById(R.id.coupon_button2)).setText("Code: 73917DIO");
                }
                else {
                    Toast toast = Toast.makeText(getContext(),"Not enough points!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                ((TextView)getView().findViewById(R.id.shopScore)).setText("Score: " + test.getCash());
            }
        });
        getView().findViewById(R.id.coupon_button3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(test.getCash() >= 15) {
                    test.mutCash(getContext(),-15);
                    ((TextView)getView().findViewById(R.id.coupon_button3)).setText("Code: 05248BNK");
                }
                else {
                    Toast toast = Toast.makeText(getContext(),"Not enough points!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                ((TextView)getView().findViewById(R.id.shopScore)).setText("Score: " + test.getCash());
            }
        });
    }
}
