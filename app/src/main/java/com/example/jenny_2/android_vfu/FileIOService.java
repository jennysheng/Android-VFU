package com.example.jenny_2.android_vfu;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FileIOService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    public ArrayList<Datalogger> channelsdata = new ArrayList<>();
    int lineNbr = 0;



    public ArrayList<Datalogger> read() {
        File file = new File(Environment.getExternalStorageDirectory() + "/Documents/", "data.txt");
       // Uri uri = Uri.fromFile(file);
        if (file!= null) {
            try {

                    FileInputStream inputStream = new FileInputStream(file);
                    assert inputStream != null;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line1 = reader.readLine();

                    while ((line1) != null) {
                        String line = reader.readLine() + "\t";
                        if (line != null) {
                            String[] parts = line.split("\t");
                            int i = 0;
                            while (8 < parts.length) {
                                channelsdata.add(new Datalogger(parts[i], parts[i + 1], parts[i + 2], parts[i + 3], parts[i + 4], parts[i + 5], parts[i + 6], parts[i + 7], parts[i + 8]));
                            }
                            Log.i("Line:" + lineNbr, parts[0] + "" + parts[1] + "" + parts[2] + "" + parts[3] + parts[4] + "" + parts[5] + "" + parts[6] + "" + parts[7] + "" + parts[8]);
                            if (lineNbr == 1000) {
                                break;
                            }
                            lineNbr++;
                        } else {
                            inputStream.close();
                        }
                    }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return channelsdata;
    }

    public ArrayList<Datalogger> getChannelsdata() {
        return channelsdata;
    }

    public void clearChannelsdata() {
        channelsdata.clear();
    }

    public class LocalBinder extends Binder {
        FileIOService getService() {
            // Return this instance of LocalService so clients can call public methods
            return FileIOService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


}




