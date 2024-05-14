package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView displayNama = findViewById(R.id.displayNama);
        TextView displayUsername = findViewById(R.id.displayUsername);
        TextView displayJob = findViewById(R.id.displayJob);
        TextView displayBio = findViewById(R.id.displayBio);
        ImageView displayFoto = findViewById(R.id.displayFoto);

        String imageView = getIntent().getStringExtra("keyImage");
        Uri imageUri = Uri.parse(imageView);

        displayNama.setText(getIntent().getStringExtra("keyName"));
        displayFoto.setImageURI(imageUri);
        displayUsername.setText(getIntent().getStringExtra("keyUsername"));
        displayJob.setText(getIntent().getStringExtra("keyJob"));
        displayBio.setText(getIntent().getStringExtra("keyBio"));

    }
}