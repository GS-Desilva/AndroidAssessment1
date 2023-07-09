package com.assesment1.s4669024_s4669021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assesment1.assessment_s4669024_s4669021.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declaring variables
    Button addCarBtn, checkCarBtn;

    //method that initializes this activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCarBtn= findViewById(R.id.addCarBtn);
        checkCarBtn= findViewById(R.id.checkCarBtn);

        addCarBtn.setOnClickListener(this);
        checkCarBtn.setOnClickListener(this);
    }

    //button handling
    @Override
    public void onClick(View view){
        int id= view.getId();
        if(id==R.id.addCarBtn){
            goToAddCarPage();
        }
        if(id==R.id.checkCarBtn){
            gotoCheckCarPage();
        }
    }

    //Creating explicit intents
    private void goToAddCarPage(){
        Intent intent=new Intent(this, ActivityAddCar.class);
        startActivity(intent);
    }

    private void gotoCheckCarPage(){
        Intent intent = new Intent(this, ActivityCheckCar.class);
        startActivity(intent);
    }
}