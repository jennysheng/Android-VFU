package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * Created by Jenny_2 on 2017-05-21.
 */

public class Scatterchart extends AppCompatActivity {
    ArrayList<String> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatterchart);

// get the value from the fileIO activity...........

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            list1 = bundle.getStringArrayList("channel1data");
        }
        ScatterChart scatterChart = (ScatterChart) findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        for(   int i=0; i<list1.size();i++) {
            entries.add(new Entry(Float.parseFloat(list1.get(i)), i));
            labels.add("Channel Values"+i);

        }
        ScatterDataSet dataset = new ScatterDataSet(entries, "# of Calls");



        ScatterData data = new ScatterData(labels, dataset);
        scatterChart.setData(data);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setScatterShapeSize(10);
        dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterChart.animateY(5000);}

}
