package com.example.sqlite3.Adapter;

import android.content.Context;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite3.R;
import com.example.sqlite3.model;

import java.util.ArrayList;

public class item_Adapter extends RecyclerView.Adapter<item_Adapter.ViewHolder> {
    Context context;
    ArrayList id,name,phone,email;

    public item_Adapter(Context context, ArrayList id, ArrayList name, ArrayList phone, ArrayList email) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public item_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(item_Adapter.ViewHolder holder, int position) {
        holder.rowId.setText(String.valueOf(id.get(position)));
        holder.rowName.setText(String.valueOf(name.get(position)));
        holder.rowPhone.setText(String.valueOf(phone.get(position)));
        holder.rowEmail.setText(String.valueOf(email.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        TextView rowId;
        TextView rowName;
        TextView rowPhone;
        TextView rowEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            rowId = itemView.findViewById(R.id.textView8);
            rowName = itemView.findViewById(R.id.textView3);
            rowPhone = itemView.findViewById(R.id.textView4);
            rowEmail = itemView.findViewById(R.id.textView5);
            context = itemView.getContext();
        }
    }
}
