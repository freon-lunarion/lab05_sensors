package com.example.antonio.lab05_sensors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTask1,btnTask2,btnTask3,btnTask4,btnTask5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btnTask1 = findViewById(R.id.btnTask1);
        btnTask2 = findViewById(R.id.btnTask2);
        btnTask3 = findViewById(R.id.btnTask3);
        btnTask4 = findViewById(R.id.btnTask4);
        btnTask5 = findViewById(R.id.btnTask5);
        btnTask1.setOnClickListener( this );
        btnTask2.setOnClickListener( this );
        btnTask3.setOnClickListener( this );
        btnTask4.setOnClickListener( this );
        btnTask5.setOnClickListener( this );

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.btnTask1:
                intent = new Intent(this, Task1Activity.class);
                break;

            case R.id.btnTask2:
                intent = new Intent(this, Task2Activity.class);
                break;

            case R.id.btnTask3:
                intent = new Intent(this, Task3Activity.class);
                break;
            case R.id.btnTask4:
                intent = new Intent(this, Task4Activity.class);
                break;
            case R.id.btnTask5:
                intent = new Intent(this, Task5Activity.class);
                break;

            default:
                intent = new Intent(this, Task1Activity.class);
                break;
        }
        startActivity(intent);
    }
}
