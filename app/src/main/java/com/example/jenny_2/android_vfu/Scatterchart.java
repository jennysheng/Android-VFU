package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


import com.github.mikephil.charting.charts.ScatterChart;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * Created by Jenny_2 on 2017-05-21.
 */

public class Scatterchart extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> list1;
    Button btn1 = null;
    ScatterChart scatterChart;
    ArrayList<Entry> entries;
    ArrayList<String> labels;
    ScatterDataSet dataset;
    ScatterData data;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatterchart);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.incrementProgressBy(10000);
        seekBar.setMax(40000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart.animateX(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    @Override
    public void onClick(View v) {

        if (btn1.getText().equals("Channel1")) {

            scatterChart = (ScatterChart) findViewById(R.id.chart);
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                list1 = bundle.getStringArrayList("channel1data");
            }

            entries = new ArrayList<>();
            labels = new ArrayList<String>();
            for (int i = 0; i < list1.size(); i++) {
                entries.add(new Entry(Float.parseFloat(list1.get(i)), i));
                labels.add("" + i);
            }
            dataset = new ScatterDataSet(entries, "channel1");
            data = new ScatterData(labels, dataset);
           // dataset.setColors(new int[]{ColorTemplate.getHoloBlue()}); //
            dataset.setScatterShapeSize(10);
            dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
            scatterChart.setData(data);

            btn1.setText("Off1");

        } else {
            scatterChart.clearValues();
            btn1.setText("Channel1");
        }
    }

}

