package com.assesment1.s4669024_s4669021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ActivityCheckCar extends AppCompatActivity implements View.OnClickListener{

    Button btnBack, checkPriceBtn;
    EditText checkBrandEx,checkModelEx,checkPriceEx;
    DBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcar);

        //btnBack = (Button) findViewById(R.id.btnBack);
        checkPriceBtn = (Button) findViewById(R.id.checkPriceBtn);


        checkBrandEx = (EditText) findViewById(R.id.checkBrandEx);
        checkModelEx = (EditText) findViewById(R.id.checkModelEx);
        checkPriceEx = (EditText) findViewById(R.id.checkPriceEx);

        btnBack.setOnClickListener(this);
        checkPriceBtn.setOnClickListener(this);

        DBHelper = new DBHelper(this);
    }
}
