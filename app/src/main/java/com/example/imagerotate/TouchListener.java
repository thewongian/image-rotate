package com.example.imagerotate;


import android.gesture.Gesture;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;

    public TouchListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
