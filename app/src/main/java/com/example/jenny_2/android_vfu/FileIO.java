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
    private ArrayList<String> datetimelist = new ArrayList<>();
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
                // to retrieve a file from SD card
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
                intent.putStringArrayListExtra("channel2data", channel2list);
                intent.putStringArrayListExtra("channel3data", channel3list);
                intent.putStringArrayListExtra("channel4data", channel4list);
                intent.putStringArrayListExtra("channel5data", channel5list);
                intent.putStringArrayListExtra("channel6data", channel6list);
                intent.putStringArrayListExtra("channel7data", channel7list);
                intent.putStringArrayListExtra("channel8data", channel8list);
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readTextFromUri(Uri uri) throws IOException {

        InputStream inputStream = getContentResolver().openInputStream(uri);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder filecontent = new StringBuilder();
        String line = reader.readLine();
        int j = 0;
        while ((line) != null) {
            line = reader.readLine();
            filecontent.append(line).append("\t").trimToSize();
            j++;
        }
        String content = filecontent.toString();
        String[] parts = content.split("\t");

        Log.i("linenbr",String.valueOf(j));
        int i = 0;

        while (i < ((j - 1) * 9)) {
            datetimelist.add(parts[i]);
            channel1list.add(parts[i+1]);
            channel2list.add( parts[i +2]);
            channel3list.add(parts[i+3]);
            channel4list.add( parts[i +4]);
            channel5list.add(parts[i+5]);
            channel6list.add( parts[i +6 ]);
            channel7list.add(parts[i+7]);
            channel8list.add( parts[i + 8]);
            i += 9;
        }

        inputStream.close();

    }





}
