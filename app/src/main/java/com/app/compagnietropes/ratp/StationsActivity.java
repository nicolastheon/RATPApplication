package com.app.compagnietropes.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.compagnietropes.ratp.Models.APIServices;

import java.util.ArrayList;
import java.util.List;

public class StationsActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> listStations;
    private ArrayAdapter<String> adapter;
    public static final String EXTRA_MESSAGE_LINE = "lines";
    public static final String EXTRA_MESSAGE_TRANSPORT = "transport";
    public static final String EXTRA_MESSAGE_STATION = "station";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);
        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        final String line = intent.getStringExtra(LinesActivity.EXTRA_MESSAGE_LINE);
        final String transport = intent.getStringExtra(LinesActivity.EXTRA_MESSAGE_TRANSPORT);
        System.out.println("LINE : " + line + " TRANSPORT : " + transport);

        requestAPI(line,transport);
        System.out.println("SIZE : " + listStations.size());
        adapter = new ArrayAdapter<String>(StationsActivity.this,android.R.layout.simple_list_item_1,listStations);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String station = (String) listView.getItemAtPosition(position);
                Intent intent1 = new Intent(StationsActivity.this,HorraireActivity.class);
                intent1.putExtra(EXTRA_MESSAGE_LINE,line);
                intent1.putExtra(EXTRA_MESSAGE_TRANSPORT,transport);
                intent1.putExtra(EXTRA_MESSAGE_STATION,station);

                startActivity(intent1);
            }
        });



    }
     private void requestAPI(String line, String transport){
         APIServices apiServices = new APIServices();
         listStations = apiServices.GetStationsFromLine(line,transport);

    }
}
