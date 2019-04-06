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
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends Fragment {

    private void changeContent(View view){
        //curContent.setVisibility(View.INVISIBLE);
        //view.setVisibility(View.VISIBLE);
        //curContent = view;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        //Switch mySwitch = getView().findViewById(R.id.PUs);
       // mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          //  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              //changeContent(getView().findViewById(R.id.challange));
              //  Toast toast = Toast.makeText(MainActivity.this, "This is a message displayed in a Toast"); toast.show();
              // MainActivity.ChangeV();
         ///   }
      //  });







        return inflater.inflate(R.layout.activity_profile, container, false);


    }

}
