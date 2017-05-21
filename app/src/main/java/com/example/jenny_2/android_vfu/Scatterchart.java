package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.numetriclabz.numandroidcharts.MultiScatterChart;

/**
 * Created by Jenny_2 on 2017-05-21.
 */

public class Scatterchart extends Activity {

    public MultiScatterChart multiScatterChart ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatterchart);
        multiScatterChart = (MultiScatterChart) findViewById(R.id.chart);

















    }

}
