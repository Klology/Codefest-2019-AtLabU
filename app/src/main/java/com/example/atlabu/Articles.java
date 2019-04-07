package com.example.atlabu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Articles extends Fragment {

    private static String oldText = "Were you Successful the last time?";
    private TextView text, other;
    private Button qYes, qNo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.articles, container, false);
    }

    public void init(){
        qYes = getView().findViewById(R.id.q1_Btn_Yes);
        qNo = getView().findViewById(R.id.q1_Btn_No);
        text = getView().findViewById(R.id.q1_Text);

        reset();

        qYes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                other = getView().findViewById(R.id.q5_Text);
                text.setText(other.getText());
                qYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                        other = getView().findViewById(R.id.q4_Text);
                        text.setText(other.getText());
                    }
                });
                qNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                        other = getView().findViewById(R.id.q4_Text);
                        text.setText(other.getText());
                    }
                });
            }
        });
        qNo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                other = getView().findViewById(R.id.q2_Text);
                text.setText(other.getText());
                qYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                        other = getView().findViewById(R.id.q4_Text);
                        text.setText(other.getText());
                    }
                });
                qNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                        other = getView().findViewById(R.id.q3_Text);
                        text.setText(other.getText());
                    }
                });
            }
        });

    }

    public void reset(){
        text.setText(oldText);
        qYes.setVisibility(View.VISIBLE);
        qNo.setVisibility(View.VISIBLE);

    }

    public void hide(){
        qNo.setVisibility(View.INVISIBLE);
        qYes.setVisibility(View.INVISIBLE);
    }

}
