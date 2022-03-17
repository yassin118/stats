package com.example.stats;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity
{
    GraphView graph;

    TextView K , L;
    PieChart pieChart;
    private LineGraphSeries<DataPoint> mSeries;
    private double graphLastXValue = -1d;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        K = findViewById(R.id.k);
        L = findViewById(R.id.l);

        pieChart = findViewById(R.id.piechart);


        setData();

        graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(2017, 769.553),
                new DataPoint(2018, 758.590),
                new DataPoint(2019, 753.383),
                new DataPoint(2020, 735.196),
                new DataPoint(2021, 738.000),


        });
        graph.addSeries(series);



        mSeries = new LineGraphSeries<>();
        graph.addSeries(mSeries);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinY(700.000);
        graph.getViewport().setMaxY(800.000);
        graph.getViewport().setMinX(2017);
        graph.getViewport().setMaxX(2021);


        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
    }



    private void setData()
    {

        K.setText(Integer.toString(74));
        L.setText(Integer.toString(2));


        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        Integer.parseInt(K.getText().toString()),
                        Color.parseColor("#06668C")));
        pieChart.addPieSlice(
                new PieModel(
                        "C++",
                        Integer.parseInt(L.getText().toString()),
                        Color.parseColor("#C23028")));


        pieChart.startAnimation();
    }
}

