package com.assesment1.s4669024_s4669021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.assesment1.s4669024_s4669021.R;

public class ActivityAddCar extends AppCompatActivity implements View.OnClickListener{

    Button addCar2Btn;
    EditText addBrandSpace,addModelSpace,addPriceSpace;
    DBHelper dbHelper;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        dbHelper=new DBHelper(this);

        addCar2Btn= findViewById(R.id.addcar2btn);

        addBrandSpace=findViewById(R.id.addBrandSpace);
        addModelSpace=findViewById(R.id.addModelSpace);
        addPriceSpace=findViewById(R.id.addPriceSpace);

        addCar2Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.addcar2btn){
            insertData();
        }
    }

    private void insertData(){
        String brand =addBrandSpace.getText().toString();
        String model =addModelSpace.getText().toString();
        String price =addPriceSpace.getText().toString();

        boolean isInserted=dbHelper.insertData(brand,model, Integer.parseInt(price));
        if(isInserted){
            Toast.makeText(ActivityAddCar.this,"Data Inserted successfully!", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(ActivityAddCar.this,"Data is not inserted!",Toast.LENGTH_LONG).show();
        }
    }
}
