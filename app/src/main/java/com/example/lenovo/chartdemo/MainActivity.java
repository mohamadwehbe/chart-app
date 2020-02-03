package com.example.lenovo.chartdemo;
//creatinine(0.9-1.3 mg/dl) potassium(3.5-5.3 mmol/l) albumin(0-2 mg/dl)

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> names;
    ArrayList<report> reportArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = findViewById(R.id.barChart);
        // new object of bar entries arraylist and names arraylist
        barEntries = new ArrayList<>();
        names = new ArrayList<>();
        reportArrayList.clear();
        reportArrayList.add(new report("creatinine",1.0));
        reportArrayList.add(new report("potassium",4.0));
        reportArrayList.add(new report("albumin",0.5));
        for (int i = 0; i<reportArrayList.size(); i++){
            String test = reportArrayList.get(i).getTest();
            double quantity = reportArrayList.get(i).getQuantity();
            barEntries.add(new BarEntry(i, (float) quantity));
            names.add(test);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries,"testquantity");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description = new Description();
        description.setText("test");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        //set Axis value formatter
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(names));
        //set position of nametests
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(names.size());
        xAxis.setLabelRotationAngle(270);
        barChart.animateY(2000);
        barChart.invalidate();
    }
}
