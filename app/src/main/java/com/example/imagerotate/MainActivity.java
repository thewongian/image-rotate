package com.example.imagerotate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
}