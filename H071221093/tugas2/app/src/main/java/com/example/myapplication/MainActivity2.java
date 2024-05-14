package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText inputBio = findViewById(R.id.editTextBio);
        EditText inputJob = findViewById(R.id.editTextJob);
        Button save = findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getIntent().getStringExtra("keyName");
                String username = getIntent().getStringExtra("keyUsername");
                String image = getIntent().getStringExtra("keyImage");

                String bioValue = inputBio.getText().toString();
                String jobValue = inputJob.getText().toString();

                if (!bioValue.isEmpty() && !jobValue.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("keyName", name);
                    intent.putExtra("keyUsername", username);
                    intent.putExtra("keyBio", bioValue);
                    intent.putExtra("keyJob", jobValue);
                    intent.putExtra("keyImage", image);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Harap isi semua!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
