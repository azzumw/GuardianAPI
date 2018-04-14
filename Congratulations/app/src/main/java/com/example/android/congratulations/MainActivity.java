package com.example.android.congratulations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.congratulations.MESSAGE";
    public static final String EXTRA_SENDER = "com.example.congratulations.SENDER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //called when the user taps send button
    public void sendMessage(View view){
        //create Intent instance
        Intent intent = new Intent(this,DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.edit_text);
        EditText editTextFrom = (EditText) findViewById(R.id.edit_text_from);

        String message = editText.getText().toString();
        String from = editTextFrom.getText().toString();


        //explicit intent
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_SENDER,from);

        startActivity(intent);
    }
}
