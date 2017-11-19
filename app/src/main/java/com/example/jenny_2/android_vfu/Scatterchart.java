package com.example.jenny_2.android_vfu;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.github.mikephil.charting.charts.ScatterChart;


import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Jenny_2 on 2017-05-21.
 */

public  class Scatterchart extends AppCompatActivity implements View.OnClickListener {
    public ArrayList<Datalogger> channeldata;
    public ArrayList<String> list1 = new ArrayList<>();
    public ArrayList<String> list2 = new ArrayList<>();
    public ArrayList<String> list3 = new ArrayList<>();
    public ArrayList<String> list4 = new ArrayList<>();
    public ArrayList<String> list5 = new ArrayList<>();
    public ArrayList<String> list6 = new ArrayList<>();
    public ArrayList<String> list7 = new ArrayList<>();
    public ArrayList<String> list8 = new ArrayList<>();

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn10;
    ScatterChart scatterChart;
    ArrayList<Entry> entries, entries2, entries3, entries4, entries5, entries6, entries7, entries8, entriesSingle;
    ArrayList<String> labels, labels2, labels3, labels4, labels5, labels6, labels7, labels8, labels10;

    ScatterDataSet dataset, dataset2, dataset3, dataset4, dataset5, dataset6, dataset7, dataset8, dataset10;
    ScatterData data, data2, data3, data4, data5, data6, data7, data8, data10;
    FileIOService mService ;
    boolean mBound = false;


    EditText editText;
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

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            FileIOService.LocalBinder binder = (FileIOService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
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
        editText = (EditText) findViewById(R.id.editText);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        editText.setText("1000");
        Button writeButton = (Button) findViewById(R.id.button9);
        writeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Date dateobj = new Date();
                //File file = new File(Environment.getExternalStorageDirectory() + "/Documents/", "file:" + df.format(dateobj));
                File file2 = new File(Environment.getExternalStorageDirectory() + "/Documents/", "jennydata.txt");
                Uri uri = Uri.fromFile(file2);
                file2.setWritable(true);
                Log.i("writeUri:", file2.getPath());
                WriteThread ws = new WriteThread(uri);
                ws.start();


            }
        });
        Button readButton = (Button) findViewById(R.id.button11);
        readButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mService.read();
                channeldata=mService.getChannelsdata();

                    // Call a method from the LocalService.
                    // However, if this call were something that might hang, then this request should
                    // occur in a separate thread to avoid slowing down the activity performance.

                    while (channeldata.iterator().hasNext()) {
                        list1.add(channeldata.iterator().next().value1);
                        Log.i("fuck",channeldata.iterator().next().value1);
                        list2.add(channeldata.iterator().next().value2);
                        list3.add(channeldata.iterator().next().value3);
                        list4.add(channeldata.iterator().next().value4);
                        list5.add(channeldata.iterator().next().value5);
                        list6.add(channeldata.iterator().next().value6);
                        list7.add(channeldata.iterator().next().value7);
                        list8.add(channeldata.iterator().next().value8);
                        channeldata.remove(0);


                }



            }
        });
        entries = new ArrayList<>();
        labels = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            entries.add(new Entry(Float.parseFloat(list1.get(i)), i));
            labels.add("" + i);
        }
        entries2 = new ArrayList<>();
        labels2 = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            entries2.add(new Entry(Float.parseFloat(list2.get(i)), i));
            labels2.add("" + i);
        }
        entries3 = new ArrayList<>();
        labels3 = new ArrayList<>();
        for (int i = 0; i < list3.size(); i++) {
            entries3.add(new Entry(Float.parseFloat(list3.get(i)), i));
            labels3.add("" + i);
        }
        entries4 = new ArrayList<>();
        labels4 = new ArrayList<>();
        for (int i = 0; i < list4.size(); i++) {
            entries4.add(new Entry(Float.parseFloat(list4.get(i)), i));
            labels4.add("" + i);
        }
        entries5 = new ArrayList<>();
        labels5 = new ArrayList<>();
        for (int i = 0; i < list5.size(); i++) {
            entries5.add(new Entry(Float.parseFloat(list5.get(i)), i));
            labels5.add("" + i);
        }
        entries6 = new ArrayList<>();
        labels6 = new ArrayList<>();
        for (int i = 0; i < list6.size(); i++) {
            entries6.add(new Entry(Float.parseFloat(list6.get(i)), i));
            labels6.add("" + i);
        }
        entries6 = new ArrayList<>();
        labels6 = new ArrayList<>();
        for (int i = 0; i < list6.size(); i++) {
            entries6.add(new Entry(Float.parseFloat(list6.get(i)), i));
            labels6.add("" + i);
        }
        entries7 = new ArrayList<>();
        labels7 = new ArrayList<>();
        for (int i = 0; i < list7.size(); i++) {
            entries7.add(new Entry(Float.parseFloat(list7.get(i)), i));
            labels7.add("" + i);
        }
        entries8 = new ArrayList<>();
        labels8 = new ArrayList<>();
        for (int i = 0; i < list7.size(); i++) {
            entries8.add(new Entry(Float.parseFloat(list8.get(i)), i));
            labels8.add("" + i);
        }
        entriesSingle = new ArrayList<>();
        labels10 = new ArrayList<>();

        for (int i = 0; i < list7.size(); i++) {

            entriesSingle.add(new Entry(Float.parseFloat(list1.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list2.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list3.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list4.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list5.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list6.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list7.get(i)), i));
            entriesSingle.add(new Entry(Float.parseFloat(list8.get(i)), i));
            labels10.add("" + i);
        }
        scatterChart.setNoDataText("Scroll seekbar->choose channel");



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (btn1.getText().equals("Ch1")) {
                    dataset = new ScatterDataSet(entries, "Channel1");
                    data = new ScatterData(labels, dataset);
                    dataset.setColors(new int[]{colors[0]});
                    dataset.setScatterShapeSize(3);
                    dataset.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart.setData(data);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn1.setText("Off1");

                } else {
                    data.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn1.setText("Ch1");
                }
                break;

            case R.id.button2:
                if (btn2.getText().equals("Ch2")) {
                    dataset2 = new ScatterDataSet(entries2, "Channel2");
                    data2 = new ScatterData(labels2, dataset2);
                    dataset2.setColors(new int[]{colors[1]});
                    dataset2.setScatterShapeSize(5);
                    dataset2.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data2);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn2.setText("Off2");


                } else {

                    data2.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn2.setText("Ch2");
                }
                break;

            case R.id.button3:
                if (btn3.getText().equals("Ch3")) {
                    dataset3 = new ScatterDataSet(entries3, "Channel3");
                    data3 = new ScatterData(labels3, dataset3);
                    dataset3.setColors(new int[]{colors[2]});
                    dataset3.setScatterShapeSize(5);
                    dataset3.setScatterShape(ScatterChart.ScatterShape.SQUARE);
                    scatterChart.setData(data3);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn3.setText("Off3");

                } else {
                    data3.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn3.setText("Ch3");
                }
                break;
            case R.id.button4:
                if (btn4.getText().equals("Ch4")) {
                    dataset4 = new ScatterDataSet(entries4, "Channel4");
                    data4 = new ScatterData(labels4, dataset4);
                    dataset4.setColors(new int[]{colors[3]});
                    dataset4.setScatterShapeSize(5);
                    dataset4.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
                    scatterChart.setData(data4);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn4.setText("Off4");

                } else {
                    data4.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn4.setText("Ch4");
                }
                break;

            case R.id.button5:
                if (btn5.getText().equals("Ch5")) {
                    dataset5 = new ScatterDataSet(entries5, "Channel5");
                    data5 = new ScatterData(labels5, dataset5);
                    dataset5.setColors(new int[]{colors[4]});
                    dataset5.setScatterShapeSize(5);
                    dataset5.setScatterShape(ScatterChart.ScatterShape.SQUARE);
                    scatterChart.setData(data5);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn5.setText("Off5");

                } else {
                    data5.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn5.setText("Ch5");
                }
                break;
            case R.id.button6:

                if (btn6.getText().equals("Ch6")) {
                    dataset6 = new ScatterDataSet(entries6, "Channel6");
                    data6 = new ScatterData(labels6, dataset6);
                    dataset6.setColors(new int[]{colors[5]});
                    dataset6.setScatterShapeSize(5);
                    dataset6.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
                    scatterChart.setData(data6);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn6.setText("Off6");

                } else {
                    data6.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn6.setText("Ch6");
                }
                break;

            case R.id.button7:
                if (btn7.getText().equals("Ch7")) {
                    dataset7 = new ScatterDataSet(entries7, "Channel7");
                    data7 = new ScatterData(labels7, dataset7);
                    dataset7.setColors(new int[]{colors[6]});
                    dataset7.setScatterShapeSize(5);
                    dataset7.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
                    scatterChart.setData(data7);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn7.setText("Off7");

                } else {
                    data7.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn7.setText("Ch7");
                }
                break;

            case R.id.button8:
                if (btn8.getText().equals("Ch8")) {
                    dataset8 = new ScatterDataSet(entries8, "Channel8");
                    data8 = new ScatterData(labels8, dataset8);
                    dataset8.setColors(new int[]{colors[7]});
                    dataset8.setScatterShapeSize(5);
                    dataset8.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data8);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn8.setText("Off8");

                } else {
                    data8.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn8.setText("Ch8");
                }
                break;


            case R.id.button10:
                if (btn10.getText().equals("Single")) {
                    dataset10 = new ScatterDataSet(entriesSingle, "All");
                    data10 = new ScatterData(labels10, dataset10);
                    dataset10.setColors(ColorTemplate.JOYFUL_COLORS);
                    dataset10.setScatterShapeSize(5);
                    dataset10.setScatterShape(ScatterChart.ScatterShape.CROSS);
                    scatterChart.setData(data10);
                    if (editText.getText() != null) {
                        scatterChart.animateX(Integer.parseInt(String.valueOf(editText.getText())));
                    }
                    btn10.setText("All");
                    scatterChart.resetViewPortOffsets();
                } else {
                    data10.clearValues();
                    scatterChart.clearAnimation();
                    scatterChart.clearValues();
                    scatterChart.clear();
                    btn10.setText("Single");
                }
                break;


            default:
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        // Bind to the service
        bindService(new Intent(this, FileIOService.class), mConnection,
                Context.BIND_AUTO_CREATE);
    }
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
        System.exit(0);

    }


}



