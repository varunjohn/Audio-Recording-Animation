package com.varunjohn1990.audiorecordingview;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private RecordViewHelper recordViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordViewHelper = new RecordViewHelper(this, new RecordViewHelper.RecordingListener() {
            @Override
            public void onRecordingStarted() {
                showToast("started");
                debug("started");
            }

            @Override
            public void onRecordingLocked() {
                showToast("locked");
                debug("locked");
            }

            @Override
            public void onRecordingCompleted() {
                showToast("completed");
                debug("completed");
            }

            @Override
            public void onRecordingCanceled() {
                showToast("canceled");
                debug("canceled");
            }
        });

        recordViewHelper.getSendView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordViewHelper.getMessageView().setText("");
                showToast("Message Sent");
            }
        });
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void debug(String log) {
        Log.d("VarunJohn", log);
    }
}
