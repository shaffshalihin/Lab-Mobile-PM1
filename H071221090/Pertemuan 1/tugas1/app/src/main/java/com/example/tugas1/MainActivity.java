package com.example.tugas1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextMHL;
    TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMHL = findViewById(R.id.editTextMHL);
        textViewDisplay = findViewById(R.id.textViewDisplay);
    }

    public void onButtonClick(View view) {
        String inputText = editTextMHL.getText().toString();
        textViewDisplay.append(inputText + "\n");
        editTextMHL.setText(""); // Clear EditText after appending text
    }
}