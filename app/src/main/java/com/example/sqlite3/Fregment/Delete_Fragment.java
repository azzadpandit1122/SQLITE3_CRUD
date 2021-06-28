package com.example.sqlite3.Fregment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlite3.DataBaseHelper.DatabaseHelper;
import com.example.sqlite3.R;

public class Delete_Fragment extends Fragment {
    ImageView ImageIcon;
    EditText UserID;
    Button BtnDelete;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_, container, false);
        db = new DatabaseHelper(getContext()); // init database in main
        ImageIcon = view.findViewById(R.id.imageView); // get in UI view by Id
        UserID = view.findViewById(R.id.editTextTextPersonName2);
        BtnDelete = view.findViewById(R.id.button2);
        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer DeleteRow = db.DeleteUserDetails(UserID.getText().toString());
                if (DeleteRow > 0) { //
                    Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    ImageIcon.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);

                } else {
                    Toast.makeText(getContext(), "faild", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}