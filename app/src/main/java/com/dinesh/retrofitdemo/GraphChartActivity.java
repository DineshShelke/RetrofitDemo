package com.dinesh.retrofitdemo;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import static android.content.ContentValues.TAG;
import java.util.ArrayList;

public class GraphChartActivity extends AppCompatActivity implements View.OnClickListener {  //
    BarChart mBarChart;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_graph_chart);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Log.i(TAG, "onCreate: "+"Graph");

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setOnClickListener(this);

        mBarChart = findViewById(R.id.barChart);
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawValueAboveBar(true);
        mBarChart.setMaxVisibleValueCount(50);
        mBarChart.setPinchZoom(false);
        mBarChart.setDrawGridBackground(true);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 40f));
        barEntries.add(new BarEntry(2, 44f));
        barEntries.add(new BarEntry(3, 30f));
        barEntries.add(new BarEntry(4, 40f));

        ArrayList<BarEntry> barEntriesq = new ArrayList<>();
        barEntriesq.add(new BarEntry(1, 44f));
        barEntriesq.add(new BarEntry(2, 54f));
        barEntriesq.add(new BarEntry(3, 60f));
        barEntriesq.add(new BarEntry(4, 31f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Data set1");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSetq = new BarDataSet(barEntriesq, "Data set1");
        barDataSetq.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(barDataSet,barDataSetq);
        float groupSpace = 0.1f;
        float barSpace = 0.02f;
        float barWidth = 0.43f;

        mBarChart.setData(data);

        data.setBarWidth(barWidth);
        mBarChart.groupBars(1,groupSpace,barSpace);

        String[] months = new String[]{"Jan","Feb","Mar","April","May","Jun"};
        XAxis xAxis = mBarChart.getXAxis();

        xAxis.setValueFormatter(new MyXAsisValueFormatar(months));

        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar:
                finish();
                break;
        }
    }

    class MyXAsisValueFormatar implements IAxisValueFormatter {

        private String[] mValues;
        public MyXAsisValueFormatar(String[] values) {
            this.mValues=values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: "+"Graph");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+"Graph");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: "+"Graph");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: "+"Graph");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: "+"Graph");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: "+"Graph");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
