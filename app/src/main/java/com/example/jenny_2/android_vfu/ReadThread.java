package com.example.jenny_2.android_vfu;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by Jenny_2 on 2017-11-11.
 */

public class ReadThread extends Thread {
    Uri uri;
    ArrayList<DataLogger> channelsdata = new ArrayList<>();
    FileIO fileio;
    int lineNbr = 0;
  


    public ReadThread(FileIO fileio, Uri uri) {
        this.fileio = fileio;
        this.uri = uri;
    }

    public void run() {

        try {
            InputStream inputStream = fileio.getContentResolver().openInputStream(uri);
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line1 = reader.readLine();

            while ((line1) != null) {
                String line = reader.readLine() + "\t";
                if (line != null) {
                    String[] fields = line.split("\t");  // in your case s.split("\t", 11) might also do
                    int i = 0;
                    while (8 < fields.length) {
                        channelsdata.add(new DataLogger(fields[i],
                                fields[i + 1],
                                fields[i + 2],
                                fields[i + 3],
                                fields[i + 4],
                                fields[i + 5],
                                fields[i + 6],
                                fields[i + 7],
                                fields[i + 8]));

                    }
                    Log.i("Line:" + lineNbr, fields[0] + "" + fields[1] + "" + fields[2] + "" + fields[3] + fields[4] + "" + fields[5] + "" + fields[6] + "" + fields[7] + "" + fields[8]);

                    lineNbr++;
                } else {
                    inputStream.close();
                }
            }
        } catch (
                FileNotFoundException e1)

        {
            e1.printStackTrace();
        } catch (
                IOException e1)

        {
            e1.printStackTrace();
        }


    }


    public ArrayList<DataLogger> getChannelsdata() {
        return channelsdata;
    }

}
