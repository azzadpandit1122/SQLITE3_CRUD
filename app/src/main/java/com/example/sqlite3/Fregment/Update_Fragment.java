package com.example.sqlite3.Fregment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite3.DataBaseHelper.DatabaseHelper;
import com.example.sqlite3.R;

public class Update_Fragment extends Fragment {

    EditText id, Name, Phone;
    Button update;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_, container, false);

        db = new DatabaseHelper(getContext());

        id = view.findViewById(R.id.id);
        Name = view.findViewById(R.id.Name);
        Phone = view.findViewById(R.id.Phone);
        update = view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheckUpdate = db.UpdateData(id.getText().toString(), Name.getText().toString(), Phone.getText().toString());
                if (isCheckUpdate == true) {
                    Toast.makeText(getContext(), "Update Successfull ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Faild  Update", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
}