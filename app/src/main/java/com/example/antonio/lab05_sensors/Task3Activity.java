package com.example.antonio.lab05_sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Task3Activity extends AppCompatActivity implements SensorEventListener {

    private TextView tvX,tvY, tvZ;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_task3 );
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        tvX = findViewById( R.id.tvMagnoX );
        tvY = findViewById( R.id.tvMagnoY);
        tvZ = findViewById( R.id.tvMagnoZ );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tvX.setText( "X: "+sensorEvent.values[0] );
        tvY.setText( "Y: "+sensorEvent.values[1] );
        tvZ.setText( "Z: "+sensorEvent.values[2] );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
