package com.example.sqlite3.Fregment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

    Button viewData;
    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    DatabaseHelper db ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_data_, container, false);
       recyclerView = view.findViewById(R.id.user_list);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       db = new DatabaseHelper(getContext());
       Cursor cursor = db.readAlldata();
       while (cursor.moveToFirst())
       {
           model obj = new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);
       }
       item_Adapter item_adapter = new item_Adapter();
       recyclerView.setAdapter(item_adapter);



//        viewData =view.findViewById(R.id.ViewDATA);
//        viewData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                db.fetchAllData();
////                db=new DatabaseHelper(getContext());
////                ArrayList<HashMap<String, String>> userList = db.GetUsers();
////                ListView lv = (ListView)view.findViewById(R.id.user_list);
////                ListAdapter adapter = new SimpleAdapter(getContext(),
////                        userList,
////                        R.layout.list_row,
////                        new String[]{"name","phone","email"},
////                        new int[]{R.id.name, R.id.phone, R.id.email});
////                lv.setAdapter(adapter);
//                Toast.makeText(getContext(), "OPEN LOGCAT in Android Studio ", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}