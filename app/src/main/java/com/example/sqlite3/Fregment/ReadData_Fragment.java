package com.example.sqlite3.Fregment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite3.Adapter.item_Adapter;
import com.example.sqlite3.DataBaseHelper.DatabaseHelper;
import com.example.sqlite3.R;
import com.example.sqlite3.model;

import java.util.ArrayList;


public class ReadData_Fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> id, name, phone, email;
    DatabaseHelper db;
    item_Adapter item_adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_data_, container, false);
        recyclerView = view.findViewById(R.id.user_list);
        db = new DatabaseHelper(getContext());
        id = new ArrayList<>();
        name = new ArrayList<>();
        phone = new ArrayList<>();
        email = new ArrayList<>();
        storeDataInArray();
        item_adapter = new item_Adapter(getContext(), id, name, phone, email);
        recyclerView.setAdapter(item_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    private void storeDataInArray() {
        Cursor cursor = db.readAlldata();
        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                phone.add(cursor.getString(2));
                email.add(cursor.getString(3));
            }
        }
    }

}