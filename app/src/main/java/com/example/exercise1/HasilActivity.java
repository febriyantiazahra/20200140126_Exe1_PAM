package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HasilActivity extends AppCompatActivity {
    TextView TaskTV, JenisTV, TimeTV;

    String stTask, stJenis, stTime;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mnLogOut)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TaskTV = findViewById(R.id.fTask);
        JenisTV = findViewById(R.id.fJenis);
        TimeTV = findViewById(R.id.fTime);

        Bundle b = getIntent().getExtras();

        stTask = b.getString("Task");
        stJenis = b.getString("Jenis");
        stTime = b.getString("Time");

        TaskTV.setText(stTask);
        JenisTV.setText(stJenis);
        TimeTV.setText(stTime);
    }
}