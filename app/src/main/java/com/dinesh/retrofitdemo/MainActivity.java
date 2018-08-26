package com.dinesh.retrofitdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.ContentValues.TAG;
import static android.os.Build.VERSION_CODES.O;

public class MainActivity extends AppCompatActivity {


    List<CaptainAmericaData> list;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: "+"MainActivity");

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if(Build.VERSION.SDK_INT < O){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getContact();
    }

    private void getContact() {
        ServiceHelper.getInstance().getContactData().enqueue(new Callback<CaptainAmerica>() {
            @Override
            public void onResponse(retrofit2.Call<CaptainAmerica> call, Response<CaptainAmerica> response) {
//                Log.i(TAG, "onResponse: " + response);
                list = new ArrayList<>();
                CaptainAmerica res = response.body();

                if (res != null) {
                    list = res.getContacts();
                    adapter = new RecyclerAdapter(MainActivity.this,list);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<CaptainAmerica> call, Throwable t) {
                Log.i(TAG, "onResponse: " + t);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: "+"MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+"MainActivity");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: "+"MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: "+"MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: "+"MainActivity");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: "+"MainActivity");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}