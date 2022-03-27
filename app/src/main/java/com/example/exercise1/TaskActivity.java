package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskActivity extends AppCompatActivity {
    TextView tvNama;

    EditText edTask, edJenis, edTime;

    FloatingActionButton fabSubmit;

    String nama, task, jenis, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tvNama = findViewById(R.id.iNama);
        edTask = findViewById(R.id.iTask);
        edJenis = findViewById(R.id.iJenis);
        edTime = findViewById(R.id.iTime);
        fabSubmit = findViewById(R.id.submit);

        Bundle b = getIntent().getExtras();
        nama = b.getString("a");
        tvNama.setText(nama);

        fabSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = edTask.getText().toString();
                jenis = edJenis.getText().toString();
                time = edTime.getText().toString();

                if(task.isEmpty()) {
                    edTask.setError("Masukkan Task!");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else if(jenis.isEmpty()) {
                    edJenis.setError("Jenis Task!");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else if(time.isEmpty()) {
                    edTime.setError("Lama Task!");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle bd = new Bundle();
                    bd.putString("Task", task.trim());
                    bd.putString("Jenis", jenis.trim());
                    bd.putString("Time", time.trim());

                    Intent in = new Intent(getApplicationContext(), HasilActivity.class);
                    in.putExtras(bd);
                    startActivity(in);
                }
            }
        });
    }
}