package com.example.android.congratulations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent= getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_SENDER);

        //
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        TextView textViewFromName = (TextView) findViewById(R.id.from_name);
        textViewFromName.append(message2);
    }
}
