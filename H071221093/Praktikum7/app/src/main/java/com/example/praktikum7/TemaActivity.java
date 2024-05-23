package com.example.praktikum7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TemaActivity extends AppCompatActivity {

    boolean nightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema);

        SwitchCompat tema = findViewById(R.id.tema);
        TextView tvTema = findViewById(R.id.tvTema);

        SharedPreferences sharedPreferences = getSharedPreferences("MODE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        nightMode = sharedPreferences.getBoolean("darkMode", false);
        if (nightMode) {
            tema.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            tvTema.setText("Dark Mode");
        } else {
            tvTema.setText("Light Mode");
        }

        tema.setOnClickListener(v -> {
            if (nightMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor.putBoolean("darkMode", false);
                tvTema.setText("Light Mode");
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putBoolean("darkMode", true);
                tvTema.setText("Dark Mode");
            }
            editor.apply();
        });
    }
}