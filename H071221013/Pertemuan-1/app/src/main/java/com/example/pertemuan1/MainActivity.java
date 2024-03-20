package com.example.pertemuan1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Button button;
    ListView listview1;

    ArrayList<String> text_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edittext = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        listview1 = findViewById(R.id.listview1);
        text_list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, text_list);
        listview1.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = edittext.getText().toString().trim();
                if (!text.isEmpty()){
                    text_list.add(text);

                    adapter.notifyDataSetChanged();
                    edittext.setText("");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}