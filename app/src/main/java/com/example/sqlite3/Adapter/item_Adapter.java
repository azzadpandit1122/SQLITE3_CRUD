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

import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite3.R;
import com.example.sqlite3.model;

import java.util.ArrayList;

public class item_Adapter extends RecyclerView.Adapter<item_Adapter.ViewHolder> {
    //Context context;
    ArrayList<model> dataholder;

//    public item_Adapter(Context context, ArrayList<itemModel> arrayList) {
//        this.context = context;
//        this.arrayList = arrayList;
//    }

    @Override
    public item_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(item_Adapter.ViewHolder holder, int position) {
        holder.rowName.setText(dataholder.get(position).getName());
        holder.rowContact.setText(dataholder.get(position).getContact());
        holder.rowEmail.setText(dataholder.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        TextView rowName;
        TextView rowContact;
        TextView rowEmail;
        ImageButton delete;

        public ViewHolder(View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView3);
            rowContact = itemView.findViewById(R.id.textView4);
            rowEmail = itemView.findViewById(R.id.textView5);
            context = itemView.getContext();
        }
    }
}
