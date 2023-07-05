package com.assesment1.s4669024_s4669021;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAddCar extends AppCompatActivity implements View.OnClickListener{

    Button addcar2Btn;
    EditText addBrandSpace,addModelSpace,addPriceSpace;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        addcar2Btn=(Button) findViewById(R.id.addcar2btn);
        addBrandSpace=findViewById(R.id.addBrandSpace);
        addModelSpace=findViewById(R.id.addModelSpace);
        addPriceSpace=findViewById(R.id.addPriceSpace);

        addcar2Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int id=view.getId();
    }
}
