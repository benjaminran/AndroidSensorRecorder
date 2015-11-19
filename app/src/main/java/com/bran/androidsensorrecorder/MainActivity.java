package com.bran.androidsensorrecorder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements ServiceConnection{

    Intent intent;

    private ToggleButton recordingControl;
    private TextView status;
    private EditText noteInput;
    private Button noteSubmit;

    private DatabaseHelper databaseHelper;
    private RestroomDetectionService detectionService;
    private boolean serviceBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DR", "MainActivity: onCreate called");
        setContentView(R.layout.activity_main);
        initUI();
        serviceBound = false;
        intent = new Intent(this, RestroomDetectionService.class);
        startService(intent);
        bindService(intent, this, 0);
    }

    private void initUI() {
        Log.d("DR", "MainAcitivity: initUI called");
        recordingControl = (ToggleButton) findViewById(R.id.recording_control);
        recordingControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start/stop recording as necessary
                Log.d("DR", "MainActivity: recordingControl clicked");
                if(recordingControl.isChecked()) {
                    Log.d("DR", "MainActivity: recordingControl toggled on");
                    // start service if necessary

                }
                else {
                    Log.d("DR", "MainActivity: recordingControl toggled off");
                    // stop service if necessary
                    detectionService.stop();
                    stopService(intent);
                }
            }
        });
        recordingControl.setChecked(true);
        status = (TextView) findViewById(R.id.status);
        noteInput = (EditText) findViewById(R.id.note_input);
        noteSubmit = (Button) findViewById(R.id.note_submit);
        noteSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save the note to the database
                Log.d("DR", "MainActivity: noteSubmit clicked with noteInput: " + noteInput.getText().toString());
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("DR", "MainActivity: onServiceConnected called");
        RestroomDetectionService.MyBinder myBinder = (RestroomDetectionService.MyBinder) service;
        detectionService = myBinder.getService();
        serviceBound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        // disconnected from service
        Log.d("DR", "MainActivity: onServiceDisconnected called");
        serviceBound = false;
    }
}
