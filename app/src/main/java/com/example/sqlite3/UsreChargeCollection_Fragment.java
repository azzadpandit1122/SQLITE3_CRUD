package com.example.sqlite3;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class UsreChargeCollection_Fragment extends Fragment {

    LineChart chart;
    EditText edittext;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usre_charge_collection_, container, false);
        chart = view.findViewById(R.id.chart);
        edittext=view.findViewById(R.id.Birthday);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data set 1");
        lineDataSet1.setColor(Color.RED);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setLineWidth(2);
        lineDataSet1.setFillAlpha(255);
        lineDataSet1.setFillColor(Color.BLACK);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaximum(100);
        leftAxis.setAxisMinimum(0);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawGridLines(false);


        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(), "Data set 2");
        lineDataSet2.setColor(Color.GREEN);

        LineDataSet lineDataSet3 = new LineDataSet(dataValues3(), "Data set 3");
        lineDataSet3.setColor(Color.BLUE);

        LineDataSet lineDataSet4 = new LineDataSet(dataValues4(), "Data set 4");
        lineDataSet4.setColor(Color.GRAY);

        chart.setBackgroundColor(Color.WHITE);
       // chart.setGridBackgroundColor(Color.CYAN);
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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    private List<Entry> dataValues4() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 23));
        dataVals.add(new Entry(1, 10));
        dataVals.add(new Entry(2, 33));
        dataVals.add(new Entry(3, 66));
        dataVals.add(new Entry(4, 60));

        return dataVals;
    }

    private List<Entry> dataValues3() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 5));
        dataVals.add(new Entry(1, 75));
        dataVals.add(new Entry(2, 56));
        dataVals.add(new Entry(3, 46));
        dataVals.add(new Entry(4, 23));

        return dataVals;
    }

    private List<Entry> dataValues2() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10));
        dataVals.add(new Entry(1, 70));
        dataVals.add(new Entry(2, 60));
        dataVals.add(new Entry(3, 40));
        dataVals.add(new Entry(4, 70));
        return dataVals;
    }

    private List<Entry> dataValues1() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10));
        dataVals.add(new Entry(1, 20));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 40));
        dataVals.add(new Entry(4, 10));
        return dataVals;

    }
}