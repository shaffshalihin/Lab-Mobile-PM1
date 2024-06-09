package com.example.praktikum_8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {

    TextInputEditText et_title, et_desc;
    Button btn_submit;
    String date, time;
    Calendar calendar;
    int id = -1;
    String title, description;
    boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_title = findViewById(R.id.et_title);
        et_desc = findViewById(R.id.et_desc);
        btn_submit = findViewById(R.id.btn_submit);

        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        // Check if we're updating an existing note
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ID")) {
            getSupportActionBar().setTitle("Update");
            isUpdate = true;
            id = intent.getIntExtra("ID", -1);
            title = intent.getStringExtra("title");
            description = intent.getStringExtra("description");
            date = intent.getStringExtra("date");
            time = intent.getStringExtra("time");
            et_title.setText(title);
            et_desc.setText(description);
        } else {
            getSupportActionBar().setTitle("Add");
        }

        btn_submit.setOnClickListener(v -> {
            String title1 = et_title.getText().toString();
            if (title1.isEmpty()) {
                et_title.setError("Field should be filled");
                return;
            }
            date = dateFormat.format(calendar.getTime());
            time = timeFormat.format(calendar.getTime());

            NoteModel noteModel = new NoteModel(et_title.getText().toString(), et_desc.getText().toString(), date, time);
            DatabaseHelper db = new DatabaseHelper(NoteActivity.this);

            if (isUpdate) {
                db.updateNote(noteModel, id);
                Toast.makeText(NoteActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            } else {
                db.addNote(noteModel);
                Toast.makeText(NoteActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
            db.close();

            Intent mainIntent = new Intent(NoteActivity.this, MainActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainIntent);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isUpdate) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.delete_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (isUpdate && item.getItemId() == R.id.delete) {
            new AlertDialog.Builder(this)
                    .setTitle("Delete Note")
                    .setMessage("Apakah Anda yakin ingin menghapus catatan ini?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        DatabaseHelper db = new DatabaseHelper(this);
                        db.deleteNote(id);
                        db.close();
                        Toast.makeText(NoteActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(NoteActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        showExitConfirmationDialog();
        return true;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        showExitConfirmationDialog();
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Exit")
                .setMessage("Are you sure you want to leave this form?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}