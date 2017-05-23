package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
    ArrayList<String> list1, list2, list3, list4, list5, list6, list7, list8;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    ScatterChart scatterChart1, scatterChart2, scatterChart3, scatterChart4, scatterChart5, scatterChart6, scatterChart7, scatterChart8;
    ArrayList<Entry> entries, entries2, entries3, entries4, entries5, entries6, entries7, entries8;
    ArrayList<String> labels, labels2, labels3, labels4, labels5, labels6, labels7, labels8;
    ScatterDataSet dataset, dataset2, dataset3, dataset4, dataset5, dataset6, dataset7, dataset8;
    ScatterData data, data2, data3, data4, data5, data6, data7, data8;
    SeekBar seekBar, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6, seekBar7, seekBar8;
    int[] colors = new int[]{
            Color.rgb(255, 0, 0),//red
            Color.rgb(255, 153, 0),//orange
            Color.rgb(0, 204, 0),//green
            Color.rgb(255, 255, 0),//light blue
            Color.rgb(102, 51, 0),//black
            Color.rgb(0, 0, 255),//dark blue
            Color.rgb(102, 0, 102),//purple
            Color.rgb(255, 0, 255)};//pink


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scatterchart);
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

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.incrementProgressBy(1000);
        seekBar.setMax(40000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart1.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.incrementProgressBy(1000);
        seekBar2.setMax(40000);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart2.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.incrementProgressBy(1000);
        seekBar3.setMax(40000);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart3.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar4.incrementProgressBy(1000);
        seekBar4.setMax(40000);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart4.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar5.incrementProgressBy(1000);
        seekBar5.setMax(40000);
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart5.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
        seekBar6.incrementProgressBy(1000);
        seekBar6.setMax(40000);
        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart6.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar7 = (SeekBar) findViewById(R.id.seekBar7);
        seekBar7.incrementProgressBy(1000);
        seekBar7.setMax(40000);
        seekBar7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart7.animateX(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        seekBar8 = (SeekBar) findViewById(R.id.seekBar8);
        seekBar8.incrementProgressBy(1000);
        seekBar8.setMax(40000);
        seekBar8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scatterChart8.animateX(progress);
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
                if (btn1.getText().equals("Channel1")) {
                    scatterChart1 = (ScatterChart) findViewById(R.id.chart);
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
                    dataset.setColors(new int[]{colors[0]}); //
                    dataset.setScatterShapeSize(10);
                    dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart1.setData(data);
                    btn1.setText("Off1");

                } else {
                    scatterChart1.clearValues();
                    btn1.setText("Channel1");
                }
                break;

            case R.id.button2:
                if (btn2.getText().equals("Channel2")) {
                    scatterChart2 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list2 = bundle.getStringArrayList("channel2data");
                    }
                    entries2 = new ArrayList<>();
                    labels2 = new ArrayList<String>();
                    for (int i = 0; i < list2.size(); i++) {
                        entries2.add(new Entry(Float.parseFloat(list2.get(i)), i));
                        labels2.add("" + i);
                    }
                    dataset2 = new ScatterDataSet(entries2, "channel2");
                    data2 = new ScatterData(labels2, dataset2);
                    dataset2.setColors(new int[]{colors[1]}); //
                    dataset2.setScatterShapeSize(10);
                    dataset2.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart2.setData(data2);
                    btn2.setText("Off2");

                } else {
                    scatterChart2.clearValues();
                    btn2.setText("Channel2");
                }
                break;

            case R.id.button3:
                if (btn3.getText().equals("Channel3")) {
                    scatterChart3 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list3 = bundle.getStringArrayList("channel3data");
                    }
                    entries3 = new ArrayList<>();
                    labels3 = new ArrayList<String>();
                    for (int i = 0; i < list3.size(); i++) {
                        entries3.add(new Entry(Float.parseFloat(list3.get(i)), i));
                        labels3.add("" + i);
                    }
                    dataset3 = new ScatterDataSet(entries3, "channel3");
                    data3 = new ScatterData(labels3, dataset3);
                    dataset3.setColors(new int[]{colors[2]}); //
                    dataset3.setScatterShapeSize(10);
                    dataset3.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart3.setData(data3);
                    btn3.setText("Off3");

                } else {
                    scatterChart3.clearValues();
                    btn3.setText("Channel3");
                }
                break;
            case R.id.button4:
                if (btn4.getText().equals("Channel4")) {
                    scatterChart4 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list4 = bundle.getStringArrayList("channel4data");
                    }
                    entries4 = new ArrayList<>();
                    labels4 = new ArrayList<String>();
                    for (int i = 0; i < list4.size(); i++) {
                        entries4.add(new Entry(Float.parseFloat(list4.get(i)), i));
                        labels4.add("" + i);
                    }
                    dataset4 = new ScatterDataSet(entries4, "channel4");
                    data4 = new ScatterData(labels4, dataset4);
                    dataset4.setColors(new int[]{colors[3]}); //
                    dataset4.setScatterShapeSize(10);
                    dataset4.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart4.setData(data4);
                    btn4.setText("Off4");

                } else {
                    scatterChart4.clearValues();
                    btn4.setText("Channel4");
                }
                break;

            case R.id.button5:
                if (btn5.getText().equals("Channel5")) {
                    scatterChart5 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list5 = bundle.getStringArrayList("channel5data");
                    }
                    entries5 = new ArrayList<>();
                    labels5 = new ArrayList<String>();
                    for (int i = 0; i < list5.size(); i++) {
                        entries5.add(new Entry(Float.parseFloat(list5.get(i)), i));
                        labels5.add("" + i);
                    }
                    dataset5 = new ScatterDataSet(entries5, "channel5");
                    data5 = new ScatterData(labels5, dataset5);
                    dataset5.setColors(new int[]{colors[4]}); //
                    dataset5.setScatterShapeSize(10);
                    dataset5.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart5.setData(data5);
                    btn5.setText("Off5");

                } else {
                    scatterChart5.clearValues();
                    btn5.setText("Channel5");
                }
                break;
            case R.id.button6:

                if (btn6.getText().equals("Channel6")) {
                    scatterChart6 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list6 = bundle.getStringArrayList("channel6data");
                    }
                    entries6 = new ArrayList<>();
                    labels6 = new ArrayList<String>();
                    for (int i = 0; i < list6.size(); i++) {
                        entries6.add(new Entry(Float.parseFloat(list6.get(i)), i));
                        labels6.add("" + i);
                    }
                    dataset6 = new ScatterDataSet(entries6, "channel6");
                    data6 = new ScatterData(labels6, dataset6);
                    dataset6.setColors(new int[]{colors[5]}); //
                    dataset6.setScatterShapeSize(10);
                    dataset6.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart6.setData(data6);
                    btn6.setText("Off6");

                } else {
                    scatterChart6.clearValues();
                    btn6.setText("Channel6");
                }
                break;

            case R.id.button7:
                if (btn7.getText().equals("Channel7")) {
                    scatterChart7 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list7 = bundle.getStringArrayList("channel7data");
                    }
                    entries7 = new ArrayList<>();
                    labels7 = new ArrayList<String>();
                    for (int i = 0; i < list7.size(); i++) {
                        entries7.add(new Entry(Float.parseFloat(list7.get(i)), i));
                        labels7.add("" + i);
                    }
                    dataset7 = new ScatterDataSet(entries7, "channel7");
                    data7 = new ScatterData(labels7, dataset7);
                    dataset7.setColors(new int[]{colors[6]}); //
                    dataset7.setScatterShapeSize(10);
                    dataset7.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart7.setData(data7);
                    btn7.setText("Off7");

                } else {
                    scatterChart7.clearValues();
                    btn7.setText("Channel7");
                }
                break;

            case R.id.button8:
                if (btn8.getText().equals("Channel8")) {
                    scatterChart8 = (ScatterChart) findViewById(R.id.chart);
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        list8 = bundle.getStringArrayList("channel8data");
                    }
                    entries8 = new ArrayList<>();
                    labels8 = new ArrayList<String>();
                    for (int i = 0; i < list8.size(); i++) {
                        entries8.add(new Entry(Float.parseFloat(list8.get(i)), i));
                        labels8.add("" + i);
                    }
                    dataset8 = new ScatterDataSet(entries8, "channel8");
                    data8 = new ScatterData(labels8, dataset8);
                    dataset8.setColors(new int[]{colors[7]}); //
                    dataset8.setScatterShapeSize(10);
                    dataset8.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart8.setData(data8);
                    btn8.setText("Off8");

                } else {
                    scatterChart8.clearValues();
                    btn8.setText("Channel8");
                }
                break;

            default:
                break;
        }
    }


}



