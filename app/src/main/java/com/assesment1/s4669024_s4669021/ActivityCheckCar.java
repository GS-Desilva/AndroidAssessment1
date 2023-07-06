package com.assesment1.s4669024_s4669021;

//imported
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.assesment1.assessment_s4669024_s4669021.R;
import com.assesment1.s4669024_s4669021.data.DBHelper;

import androidx.appcompat.app.AppCompatActivity;
public class ActivityCheckCar extends AppCompatActivity implements View.OnClickListener{

    Button checkPriceBtn, backBtn;
    EditText checkBrandEx,checkModelEx,checkPriceEx;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcar);

        checkPriceBtn = findViewById(R.id.checkPriceBtn);
        backBtn = findViewById(R.id.backBtn);

        checkBrandEx = findViewById(R.id.checkBrandEx);
        checkModelEx = findViewById(R.id.checkModelEx);
        checkPriceEx = findViewById(R.id.checkPriceEx);

        checkPriceBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.backBtn)
        {
            goToHomePage();
        }

        if(id == R.id.checkPriceBtn)
        {
            displayPrice();
        }
    }

    private void displayPrice(){
        String brand = checkBrandEx.getText().toString().trim();
        String model = checkModelEx.getText().toString().trim();

        if(brand.isEmpty())
        {
            Toast.makeText(this, "Please enter brand name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(model.isEmpty())
        {
            Toast.makeText(this, "Please enter model name!", Toast.LENGTH_SHORT).show();
            return;
        }

        int price = dbHelper.getPrice(brand,model);

        if(price == -1){
            Toast.makeText(this, "Car not found. Please enter the brand and model again!",Toast.LENGTH_SHORT).show();
            checkPriceEx.setText("");
        }
        else {
            checkPriceEx.setText(String.valueOf(price));
        }
    }

    private void goToHomePage()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

