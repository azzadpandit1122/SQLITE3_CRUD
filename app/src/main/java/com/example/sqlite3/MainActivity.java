package com.example.sqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlite3.Fregment.Dashboard_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, new Dashboard_Fragment()).commit();
    }
}