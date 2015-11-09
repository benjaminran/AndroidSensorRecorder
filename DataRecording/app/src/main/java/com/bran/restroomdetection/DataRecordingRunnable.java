package com.bran.restroomdetection;

import android.util.Log;

/**
 * Created by beni on 11/6/15.
 */
public class DataRecordingRunnable implements Runnable {

    private DatabaseHelper databaseHelper;
    private volatile boolean stopped;

    @Override
    public void run() {
        stopped = false;
        Log.d("DR", "DataRecording: run called");
        int count = 1;
        while(!stopped) {
            Log.d("DR", "DataRecording: loop iteration "+count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        Log.d("DR", "DataRecording: stop called");
        // release resources
        stopped = true;
    }
}
