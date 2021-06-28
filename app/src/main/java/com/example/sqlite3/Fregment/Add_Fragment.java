package com.example.sqlite3.Fregment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sqlite3.DataBaseHelper.DatabaseHelper;
import com.example.sqlite3.R;

public class Add_Fragment extends Fragment {

    DatabaseHelper db;
    EditText name, phone, email;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_, container, false);
        name = view.findViewById(R.id.editTextTextPersonName);
        phone = view.findViewById(R.id.editTextTextPersonPhone);
        email = view.findViewById(R.id.editTextTextPersonEmail);

        db = new DatabaseHelper(getContext());
        Button Ragister = view.findViewById(R.id.button);
        Ragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = db.InsertData(name.getText().toString(), phone.getText().toString(), email.getText().toString());
                if (check == true) {
                    Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "faild", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}