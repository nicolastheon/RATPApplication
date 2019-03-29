package com.app.compagnietropes.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button metro;
    private Button rer;
    public static final String EXTRA_MESSAGE = "transport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metro = (Button) findViewById(R.id.metro);
        rer = (Button) findViewById(R.id.rer);

        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LinesActivity.class);
                intent.putExtra(EXTRA_MESSAGE,new String("metros"));
                startActivity(intent);

            }
        });

        rer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LinesActivity.class);
                intent.putExtra(EXTRA_MESSAGE,new String("rers"));
                startActivity(intent);

            }
        });
    }
}
