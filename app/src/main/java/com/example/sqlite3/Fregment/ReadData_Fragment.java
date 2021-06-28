package com.example.sqlite3.Fregment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite3.DataBaseHelper.DatabaseHelper;
import com.example.sqlite3.R;

public class ReadData_Fragment extends Fragment {

    Button viewData;
    DatabaseHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_data_, container, false);
        db=new DatabaseHelper(getContext());
        viewData =view.findViewById(R.id.ViewDATA);
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.fetchAllData();
                Toast.makeText(getContext(), "OPEN LOGCAT in Android Studio ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}