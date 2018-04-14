package com.example.android.logs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.logs.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView view_1 = (TextView) findViewById(R.id.menu_item_1);
        String str = ""+view_1;
        Log.i("MainActivity.java",str);
        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs

    }
}