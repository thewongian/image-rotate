package com.example.imagerotate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button toCamera;
    ImageView image;
    public static final int REQUEST_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toCamera = (Button) findViewById(R.id.toCamera);
        image = (ImageView) findViewById(R.id.imageView);
        toCamera.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.toCamera) {
            Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(takePicIntent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(takePicIntent, REQUEST_IMAGE);
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnail = (Bitmap) extras.get("data");
            image.setBackground(new BitmapDrawable(getResources(), thumbnail));
            //myCanvas.setBackground(new BitmapDrawable(getResources(), thumbnail));
        }
    }
}