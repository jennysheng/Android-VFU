package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.jenny_2.android_vfu.R.id.dataText;

public class FileIO extends AppCompatActivity {
    TextView dataText=null;

    private static final int REQUESTCODE_PICK_TEXTFILE =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);
        dataText=(TextView)findViewById(R.id.dataText);



        final Button button2 = (Button) findViewById(R.id.Read_externalButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // to retrieve a file from another app
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
            Uri uri = data.getData();
            Log.d("", "Text URI= " + uri);
            try {
                dataText.setText(readTextFromUri(uri));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readTextFromUri(Uri uri) throws IOException {
        InputStream inputStream = getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder.toString();
    }
}
