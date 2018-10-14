package com.example.antonio.lab05_sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Task1Activity extends AppCompatActivity implements SensorEventListener {

    private TextView tvX,tvY, tvZ;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_task1 );
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        tvX = findViewById( R.id.tvGryoX );
        tvY = findViewById( R.id.tvGryoY );
        tvZ = findViewById( R.id.tvGryoZ );
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
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
