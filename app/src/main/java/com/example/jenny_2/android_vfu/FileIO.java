package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class FileIO extends AppCompatActivity {


    private static final int REQUESTCODE_PICK_TEXTFILE = 1;
    ArrayList<DataLogger> channelsdata = new ArrayList<>();
    private ArrayList<String> channel1list = new ArrayList<>();
    private ArrayList<String> channel2list = new ArrayList<>();
    private ArrayList<String> channel3list = new ArrayList<>();
    private ArrayList<String> channel4list = new ArrayList<>();
    private ArrayList<String> channel5list = new ArrayList<>();
    private ArrayList<String> channel6list = new ArrayList<>();
    private ArrayList<String> channel7list = new ArrayList<>();
    private ArrayList<String> channel8list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);
        final Button button2 = (Button) findViewById(R.id.Read_externalButton);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // to retrieve a file from another app
                Intent textFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                textFileIntent.setType("text/*");
                startActivityForResult(textFileIntent, REQUESTCODE_PICK_TEXTFILE);



            }
        });
        final Button button3 = (Button) findViewById(R.id.buttonShow);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Scatterchart.class);
                intent.putStringArrayListExtra("channel1data", channel1list);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE_PICK_TEXTFILE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            Log.d("", "Text URI= " + uri);
            try {
                readTextFromUri(uri);
                createchart();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<DataLogger> readTextFromUri(Uri uri) throws IOException {

        InputStream inputStream = getContentResolver().openInputStream(uri);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder filecontent = new StringBuilder();
        String line = reader.readLine();
        int j = 0;
        while ((line) != null) {
            line = reader.readLine();
            filecontent.append(line + "\t").trimToSize();
            j++;
        }
        String content = filecontent.toString();
        String[] parts = content.split("\t");

        System.out.println(j);
        int i = 0;

        while (i < ((j - 1) * 9)) {

            channelsdata.add(new DataLogger(parts[i], parts[i + 1], parts[i + 2], parts[i + 3], parts[i + 4], parts[i + 5], parts[i + 6], parts[i + 7], parts[i + 8]));

            i += 9;
        }

        inputStream.close();
        return channelsdata;
    }

    public ArrayList<DataLogger> getChannelsdata() {
        return channelsdata;
    }

    private void createchart() {

// add jackoption to build.gradle to enable this method
        getChannelsdata().stream().forEach((c) -> {
            channel1list.add(c.getValue1());
            channel2list.add(c.getValue2());
            channel3list.add(c.getValue3());
            channel4list.add(c.getValue4());
            channel5list.add(c.getValue5());
            channel6list.add(c.getValue6());
            channel7list.add(c.getValue7());
            channel8list.add(c.getValue8());


        });
    }

}
