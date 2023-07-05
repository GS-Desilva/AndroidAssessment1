package com.assesment1.s4669024_s4669021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.onClickListner{

    Button addCarBtn, checkCarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addCarBtn=(Button) findViewById(R.id.addcarBtn);
        checkCarBtn=(Button) findViewById(R.id.checkcarBtn);

        addCarBtn.setOnClickListener(this);
        checkCarBtn.setOnClickListener(this);
        // ensuring that the ActionBar is not null (not absent) before setting its title
        Objects.requireNonNull(getSupportActionBar()).setTitle("assessment_s4669021-s4669024");
    }

    @Override
    public void onClick(View view){
        int id= view.getId();
        if(id==R.id.addcarBtn){
            goToActivityAddCar();
        }
        if(id==R.id.checkcarBtn){
            gotoActivityCheckCar();
        }
    }
    private void goToActivityAddCar(){

    }
}