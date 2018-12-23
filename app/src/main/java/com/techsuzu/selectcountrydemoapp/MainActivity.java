package com.techsuzu.selectcountrydemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.techsuzu.select_country.Country;
import com.techsuzu.select_country.Data;

public class MainActivity extends AppCompatActivity implements CountryAdapter.OnItemSelectListner, Country.Process {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvCountryList = findViewById(R.id.rvCountryList);
        rvCountryList.setLayoutManager(new LinearLayoutManager(this));
        rvCountryList.setAdapter(new CountryAdapter(Country.getData(this, this), this));
    }

    @Override
    public void itemSelect(Data data) {
        Toast.makeText(this, data.getDialingCode(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void started() {
        Log.i("Country data", "started: ");
    }

    @Override
    public void success() {
        Log.i("Country data", "success: ");
    }

    @Override
    public void failed(Exception e) {
        Log.e("Country data", "failed: ");
        e.printStackTrace();
    }
}
