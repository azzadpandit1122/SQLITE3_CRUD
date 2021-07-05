package com.example.sqlite3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class UsreChargeCollection_Fragment extends Fragment {

    LineChart chart;
    private int mfillColor = Color.rgb(150, 181, 229);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usre_charge_collection_, container, false);
        chart = view.findViewById(R.id.chart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data set 1");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(), "Data set 2");
        LineDataSet lineDataSet3 = new LineDataSet(dataValues3(), "Data set 3");
        LineDataSet lineDataSet4 = new LineDataSet(dataValues4(), "Data set 4");

        chart.setBackgroundColor(Color.WHITE);
        chart.setGridBackgroundColor(Color.CYAN);
        chart.setDrawGridBackground(true);
        chart.setDrawBorders(true);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        Legend l = chart.getLegend();
        l.setEnabled(false);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        dataSets.add(lineDataSet4);
        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();
        return view;
    }

    private List<Entry> dataValues4() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 23));
        dataVals.add(new Entry(1, 10));
        dataVals.add(new Entry(2, 33));
        dataVals.add(new Entry(3, 66));
        dataVals.add(new Entry(4, 99));
        dataVals.add(new Entry(5, 33));
        dataVals.add(new Entry(6, 99));
        dataVals.add(new Entry(7, 22));
        dataVals.add(new Entry(8, 33));
        dataVals.add(new Entry(9, 56));
        dataVals.add(new Entry(10, 67));
        return dataVals;
    }

    private List<Entry> dataValues3() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 5));
        dataVals.add(new Entry(1, 75));
        dataVals.add(new Entry(2, 56));
        dataVals.add(new Entry(3, 46));
        dataVals.add(new Entry(4, 23));
        dataVals.add(new Entry(5, 78));
        dataVals.add(new Entry(6, 32));
        dataVals.add(new Entry(7, 2));
        dataVals.add(new Entry(8, 9));
        dataVals.add(new Entry(9, 0));
        dataVals.add(new Entry(10, 10));
        return dataVals;
    }

    private List<Entry> dataValues2() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10));
        dataVals.add(new Entry(1, 70));
        dataVals.add(new Entry(2, 60));
        dataVals.add(new Entry(3, 40));
        dataVals.add(new Entry(4, 70));
        dataVals.add(new Entry(5, 50));
        dataVals.add(new Entry(6, 90));
        dataVals.add(new Entry(7, 40));
        dataVals.add(new Entry(8, 20));
        dataVals.add(new Entry(9, 10));
        dataVals.add(new Entry(10, 30));
        return dataVals;
    }

    private List<Entry> dataValues1() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10));
        dataVals.add(new Entry(1, 20));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 40));
        dataVals.add(new Entry(4, 10));
        dataVals.add(new Entry(5, 20));
        dataVals.add(new Entry(6, 40));
        dataVals.add(new Entry(7, 60));
        dataVals.add(new Entry(8, 70));
        dataVals.add(new Entry(9, 10));
        dataVals.add(new Entry(10, 90));
        return dataVals;

    }
}