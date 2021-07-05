package com.example.sqlite3.Fregment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sqlite3.R;
import com.example.sqlite3.UsreChargeCollection_Fragment;

public class Dashboard_Fragment extends Fragment {

    Button add, viewData, update, delete, userChargeCollection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_, container, false);
        add = view.findViewById(R.id.add);
        viewData = view.findViewById(R.id.view);
        update = view.findViewById(R.id.Update);
        delete = view.findViewById(R.id.delete);
        userChargeCollection = view.findViewById(R.id.UserChargeCollection);
        userChargeCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainlayout, new UsreChargeCollection_Fragment()).addToBackStack(null).commit();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainlayout, new Add_Fragment()).addToBackStack(null).addToBackStack(null).commit();
            }
        });
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainlayout, new ReadData_Fragment()).addToBackStack(null).commit();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainlayout, new Update_Fragment()).addToBackStack(null).commit();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainlayout, new Delete_Fragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}