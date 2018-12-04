package com.varunjohn1990.audiorecordingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class AudioRecordView extends LinearLayout {

    public AudioRecordView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public AudioRecordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AudioRecordView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.recording_layout, null);
        addView(view);
    }
}
