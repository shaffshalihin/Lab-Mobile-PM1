package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> dataList = new ArrayList<>(); // Daftar untuk menyimpan data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextLainnya = findViewById(R.id.editTextLainnya);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        LinearLayout listLayout = findViewById(R.id.listLayout);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editTextLainnya.getText().toString();

                dataList.add(inputText);
                listLayout.removeAllViews();

                for (String data : dataList) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(data);
                    listLayout.addView(textView);
                }
                editTextLainnya.setText("");
            }
        });
    }
}
