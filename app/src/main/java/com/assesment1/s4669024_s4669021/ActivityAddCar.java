package com.assesment1.s4669024_s4669021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.assesment1.assessment_s4669024_s4669021.R;
import com.assesment1.s4669024_s4669021.data.DBHelper;

public class ActivityAddCar extends AppCompatActivity implements View.OnClickListener{

    Button addCar2Btn, backBtn;
    EditText addBrandSpace,addModelSpace,addPriceSpace;
    DBHelper dbHelper;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        dbHelper=new DBHelper(this);

        addCar2Btn= findViewById(R.id.addcar2btn);
        backBtn= findViewById(R.id.backBtn);
        addBrandSpace=findViewById(R.id.addBrandSpace);
        addModelSpace=findViewById(R.id.addModelSpace);
        addPriceSpace=findViewById(R.id.addPriceSpace);

        addCar2Btn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.addcar2btn){
            insertData();
        }
        if(id==R.id.backBtn){
            goToHomePage();
        }
    }

    private void insertData() {
        String brand = addBrandSpace.getText().toString();
        String model = addModelSpace.getText().toString();
        String price = addPriceSpace.getText().toString();

        boolean isInserted = false;
        if (brand.isEmpty() || model.isEmpty() || price.isEmpty()) {
            Toast.makeText(ActivityAddCar.this, "Enter values in all fields!", Toast.LENGTH_SHORT).show();
        }
        else {
            isInserted = dbHelper.insertData(brand, model, Integer.parseInt(price));
        }

        if (isInserted) {
            Toast.makeText(ActivityAddCar.this, "Data inserted Successfully!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(ActivityAddCar.this, "Data entry Failed!", Toast.LENGTH_LONG).show();
        }
    }

    private void goToHomePage(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
