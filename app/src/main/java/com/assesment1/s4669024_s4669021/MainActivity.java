package com.assesment1.s4669024_s4669021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assesment1.assessment_s4669024_s4669021.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button addCarBtn, checkCarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        addCarBtn= findViewById(R.id.addCarBtn);
        checkCarBtn= findViewById(R.id.checkCarBtn);

        addCarBtn.setOnClickListener(this);
        checkCarBtn.setOnClickListener(this);
        // ensuring that the ActionBar is not null (not absent) before setting its title
        //Objects.requireNonNull(getSupportActionBar()).setTitle("assessment_s4669021-s4669024");
    }

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
    private void goToAddCarPage(){
        Intent intent=new Intent(this, ActivityAddCar.class);
        startActivity(intent);
    }
    private void gotoCheckCarPage(){
        Intent intent=new Intent(this, ActivityCheckCar.class);
        startActivity(intent);
    }
}