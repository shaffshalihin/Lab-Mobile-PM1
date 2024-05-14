package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private EditText name, username;
    private Button submit;

    Uri image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.editTextNama);
        username = findViewById(R.id.editTextUsername);
        submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_value = name.getText().toString();
                String username_value = username.getText().toString();

                if (!name_value.isEmpty() && !username_value.isEmpty() && image != null) {
                    // Jika telah diisi, buat Intent dan mulai aktivitas baru
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("keyName", name_value);
                    intent.putExtra("keyUsername", username_value);
                    intent.putExtra("keyImage", image.toString());
                    // Anda dapat menambahkan logika untuk mengirim gambar (image) ke Intent jika diperlukan
                    startActivity(intent);
                } else {
                    // Jika salah satu atau kedua bidang kosong, tampilkan pesan kesalahan
                    Toast.makeText(MainActivity.this, "Harap isi semua!", Toast.LENGTH_SHORT).show();
                }

//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra("keyName", name_value);
//                intent.putExtra("keyUsername", username_value);
//                intent.putExtra("keyImage", image.toString());
//                startActivity(intent);
            }
        });

        imageView.setOnClickListener(view -> openGallery());
        }

        private void openGallery(){
        Intent openGallery = new Intent(Intent.ACTION_PICK);
        openGallery.setType("image/*");
        launcherIntentGallery.launch(openGallery);
        }

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        image = data.getData();
                        imageView.setImageURI(image);
                    }
                }
        );
    }




