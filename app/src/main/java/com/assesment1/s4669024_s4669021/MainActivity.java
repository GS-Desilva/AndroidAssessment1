package com.assesment1.s4669024_s4669021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ensuring that the ActionBar is not null (not absent) before setting its title
        Objects.requireNonNull(getSupportActionBar()).setTitle("assessment_s4669021-s4669024");
    }
}