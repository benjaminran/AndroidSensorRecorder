package com.bran.androidsensorrecorder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class RestroomDetectionService extends Service {

    private DataRecordingRunnable dataRecordingRunnable;
    private Thread dataRecordingThread;
    private MyBinder myBinder = new MyBinder();

    public RestroomDetectionService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("DR", "RestroomDetectionService: onStartCommand called");
        dataRecordingRunnable = new DataRecordingRunnable();
        dataRecordingThread = new Thread(dataRecordingRunnable, "Data Recording Thread");
        dataRecordingThread.start();
        return START_NOT_STICKY;
    }

    public void stop() {
        Log.d("DR", "RestroomDetectionService: stop called");
        dataRecordingRunnable.stop();
        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("DR", "RestroomDetectionService: onBind called");
        return myBinder;
    }

    public class MyBinder extends Binder {
        RestroomDetectionService getService() {
            Log.d("DR", "RestroomDetectionService: MyBinder: getService called");
            return RestroomDetectionService.this;
        }
    }
}
