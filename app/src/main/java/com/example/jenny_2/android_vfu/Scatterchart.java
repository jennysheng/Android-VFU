package com.example.jenny_2.android_vfu;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * Created by Jenny_2 on 2017-05-21.
 */

public class Scatterchart extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> list1, list2, list3, list4, list5, list6, list7, list8, alllist;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn10;
    ScatterChart scatterChart;
    ArrayList<Entry> entries, entries2, entries3, entries4, entries5, entries6, entries7, entries8, entriesSingle;
    ArrayList<String> labels;
    ScatterDataSet dataset, dataset2, dataset3, dataset4, dataset5, dataset6, dataset7, dataset8, dataset10;
    ScatterData data, data2, data3, data4, data5, data6, data7, data8, data10;
    SeekBar seekBar;
    int[] colors = new int[]{
            Color.rgb(255, 0, 0),//red
            Color.rgb(255, 153, 0),//orange
            Color.rgb(0, 204, 0),//green
            Color.rgb(255, 255, 0),//light blue
            Color.rgb(102, 51, 0),//black
            Color.rgb(0, 0, 255),//dark blue
            Color.rgb(102, 0, 102),//purple
            Color.rgb(255, 0, 255), //pink

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatterchart);

        scatterChart = (ScatterChart) findViewById(R.id.chart);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            list1 = bundle.getStringArrayList("channel1data");
            list2 = bundle.getStringArrayList("channel2data");
            list3 = bundle.getStringArrayList("channel3data");
            list4 = bundle.getStringArrayList("channel4data");
            list5 = bundle.getStringArrayList("channel5data");
            list6 = bundle.getStringArrayList("channel6data");
            list7 = bundle.getStringArrayList("channel7data");
            list8 = bundle.getStringArrayList("channel8data");
            alllist = bundle.getStringArrayList("allchannelsdata");
        }
        entries = new ArrayList<>();
        labels = new ArrayList<>();
        entries2 = new ArrayList<>();
        entries3 = new ArrayList<>();
        entries4 = new ArrayList<>();
        entries5 = new ArrayList<>();
        entries6 = new ArrayList<>();
        entries7 = new ArrayList<>();
        entries8 = new ArrayList<>();
        entriesSingle = new ArrayList<>();

        int i = 0;
        while (list1.iterator().hasNext()) {
            entries.add(new Entry(Float.parseFloat(list1.iterator().next()), i));
            entries2.add(new Entry(Float.parseFloat(list2.iterator().next()), i));
            entries3.add(new Entry(Float.parseFloat(list3.iterator().next()), i));
            entries4.add(new Entry(Float.parseFloat(list4.iterator().next()), i));
            entries5.add(new Entry(Float.parseFloat(list5.iterator().next()), i));
            entries6.add(new Entry(Float.parseFloat(list6.iterator().next()), i));
            entries7.add(new Entry(Float.parseFloat(list7.iterator().next()), i));
            entries8.add(new Entry(Float.parseFloat(list8.iterator().next()), i));

            labels.add("" + i);
            i++;
            list1.remove(0);
            list2.remove(0);
            list3.remove(0);
            list4.remove(0);
            list5.remove(0);
            list6.remove(0);
            list7.remove(0);
            list8.remove(0);
        }
        int j = 0;
        while (alllist.iterator().hasNext()) {
            entriesSingle.add(new Entry(Float.parseFloat(alllist.iterator().next()), j));
            labels.add("" + j);
            j++;
            alllist.remove(0);
        }


        scatterChart.setNoDataText("Scroll seekbar->choose channel");

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.incrementProgressBy(1000);
        seekBar.setMax(100000);

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
        switch (v.getId()) {
            case R.id.button1:
                if (btn1.getText().equals("Ch1")) {
                    dataset = new ScatterDataSet(entries, "channel1");
                    data = new ScatterData(labels, dataset);
                    dataset.setColors(new int[]{colors[0]}); //
                    dataset.setScatterShapeSize(3);
                    dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart.setData(data);
                    btn1.setText("Off1");
                    scatterChart.resetViewPortOffsets();

                } else {

                    data.removeDataSet(0);
                    btn1.setText("Ch1");
                }
                break;

            case R.id.button2:
                if (btn2.getText().equals("Ch2")) {
                    dataset2 = new ScatterDataSet(entries2, "channel2");
                    data2 = new ScatterData(labels, dataset2);
                    dataset2.setColors(new int[]{colors[1]}); //
                    dataset2.setScatterShapeSize(5);
                    dataset2.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data2);
                    btn2.setText("Off2");


                } else {

                    data2.removeDataSet(0);
                    btn2.setText("Ch2");
                }
                break;

            case R.id.button3:
                if (btn3.getText().equals("Ch3")) {
                    dataset3 = new ScatterDataSet(entries3, "channel3");
                    data3 = new ScatterData(labels, dataset3);
                    dataset3.setColors(new int[]{colors[2]}); //
                    dataset3.setScatterShapeSize(5);
                    dataset3.setScatterShape(ScatterChart.ScatterShape.SQUARE);
                    scatterChart.setData(data3);
                    btn3.setText("Off3");


                } else {

                    data3.removeDataSet(0);
                    btn3.setText("Ch3");
                }
                break;
            case R.id.button4:
                if (btn4.getText().equals("Ch4")) {
                    dataset4 = new ScatterDataSet(entries4, "channel4");
                    data4 = new ScatterData(labels, dataset4);
                    dataset4.setColors(new int[]{colors[3]}); //
                    dataset4.setScatterShapeSize(5);
                    dataset4.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
                    scatterChart.setData(data4);
                    btn4.setText("Off4");


                } else {
                    data4.removeDataSet(0);
                    btn4.setText("Ch4");
                }
                break;

            case R.id.button5:
                if (btn5.getText().equals("Ch5")) {
                    dataset5 = new ScatterDataSet(entries5, "channel5");
                    data5 = new ScatterData(labels, dataset5);
                    dataset5.setColors(new int[]{colors[4]}); //
                    dataset5.setScatterShapeSize(5);
                    dataset5.setScatterShape(ScatterChart.ScatterShape.SQUARE);
                    scatterChart.setData(data5);
                    btn5.setText("Off5");


                } else {

                    data5.removeDataSet(0);
                    btn5.setText("Ch5");
                }
                break;
            case R.id.button6:

                if (btn6.getText().equals("Ch6")) {
                    dataset6 = new ScatterDataSet(entries6, "channel6");
                    data6 = new ScatterData(labels, dataset6);
                    dataset6.setColors(new int[]{colors[5]}); //
                    dataset6.setScatterShapeSize(5);
                    dataset6.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart.setData(data6);
                    btn6.setText("Off6");


                } else {

                    data6.removeDataSet(0);
                    btn6.setText("Ch6");
                }
                break;

            case R.id.button7:
                if (btn7.getText().equals("Ch7")) {
                    dataset7 = new ScatterDataSet(entries7, "channel7");
                    data7 = new ScatterData(labels, dataset7);
                    dataset7.setColors(new int[]{colors[6]}); //
                    dataset7.setScatterShapeSize(5);
                    dataset7.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
                    scatterChart.setData(data7);
                    btn7.setText("Off7");


                } else {
                    data7.removeDataSet(0);
                    btn7.setText("Ch7");
                }
                break;

            case R.id.button8:
                if (btn8.getText().equals("Ch8")) {
                    dataset8 = new ScatterDataSet(entries8, "channel8");
                    data8 = new ScatterData(labels, dataset8);
                    dataset8.setColors(new int[]{colors[7]}); //
                    dataset8.setScatterShapeSize(5);
                    dataset8.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data8);
                    btn8.setText("Off8");

                } else {
                    data8.removeDataSet(0);
                    btn8.setText("Ch8");
                }
                break;


            case R.id.button10:
                if (btn10.getText().equals("Single")) {
                    dataset10 = new ScatterDataSet(entriesSingle, "all");
                    data10 = new ScatterData(labels, dataset10);
                    dataset10.setColors(ColorTemplate.JOYFUL_COLORS); //
                    dataset10.setScatterShapeSize(5);
                    dataset10.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data10);
                    btn10.setText("All");


                } else {
                    data10.removeDataSet(0);
                    btn10.setText("Single");

                }
                break;
            default:
                break;
        }
    }

    protected void onStop() {
        super.onStop();
        System.exit(0);

    }


}



