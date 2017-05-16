package com.example.jenny_2.android_vfu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FileIO extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);

        final TextView dataText=(TextView)findViewById(R.id.dataText);


        final Button button2 = (Button) findViewById(R.id.Reade_externalButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataText.setText("Jenny");
            }
        });
    }
}
