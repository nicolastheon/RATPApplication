package com.app.compagnietropes.ratp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.compagnietropes.ratp.Models.APIServices;

public class HorraireActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horraire);
        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        final String line = intent.getStringExtra(LinesActivity.EXTRA_MESSAGE_LINE);
        final String transport = intent.getStringExtra(LinesActivity.EXTRA_MESSAGE_TRANSPORT);
        final String station = intent.getStringExtra(StationsActivity.EXTRA_MESSAGE_STATION);

        RequestAPI(line,transport,station);


    }
    private void RequestAPI(String line,String transport,String station){
        APIServices apiServices = new APIServices();
        String horraires = apiServices.getHorraireFromStation(line,transport,station);
        textView.setText(horraires);
    }
}
