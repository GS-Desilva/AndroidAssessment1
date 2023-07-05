package com.assesment1.s4669024_s4669021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ActivityCheckCar extends AppCompatActivity implements View.OnClickListener{

    Button checkPriceBtn;
    EditText checkBrandEx,checkModelEx,checkPriceEx;
    DBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcar);

        checkPriceBtn = (Button) findViewById(R.id.checkPriceBtn);


        checkBrandEx = (EditText) findViewById(R.id.checkBrandEx);
        checkModelEx = (EditText) findViewById(R.id.checkModelEx);
        checkPriceEx = (EditText) findViewById(R.id.checkPriceEx);


        checkPriceBtn.setOnClickListener(this);

        DBHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.checkPriceBtn) {
            viewPrice();
        }
    }

    private void viewPrice() {
        String brand = checkBrandEx.getText().toString().trim();
        String model = checkModelEx.getText().toString().trim();

        if(brand.isEmpty() || model.isEmpty()) {
            Toast.makeText(this, "Please enter brand name and model name", Toast.LENGTH_SHORT).show();
            return;
        }

        int price = DBHelper.getPrice(brand, model);

        if(price == -1) {
            Toast.makeText(this, "Car not found. Please try again!", Toast.LENGTH_SHORT).show();
            checkPriceEx.setText("");
        } else {
            checkPriceEx.setText(String.valueOf(price));
        }
    }

}
