package com.bran.restroomdetection;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RestroomDetectionService extends Service {
    public RestroomDetectionService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // <do anything needed with intent>
        // continue running explicitly stopped
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
