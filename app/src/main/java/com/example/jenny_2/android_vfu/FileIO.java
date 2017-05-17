package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FileIO extends AppCompatActivity {


    private static final int REQUESTCODE_PICK_TEXTFILE =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);

        final TextView dataText=(TextView)findViewById(R.id.dataText);

        final Button button2 = (Button) findViewById(R.id.Reade_externalButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Pick a file from SD card using Intent
                Intent textFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                textFileIntent.setType("text/*");
                startActivityForResult(textFileIntent,REQUESTCODE_PICK_TEXTFILE);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE_PICK_TEXTFILE && resultCode == Activity.RESULT_OK) {
            Uri textUri = data.getData();
            Log.d("", "Text URI= " + textUri);
        }
    }

}
