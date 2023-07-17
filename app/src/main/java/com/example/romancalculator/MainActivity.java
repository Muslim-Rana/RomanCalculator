package com.example.romancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //comment test for github commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.TextView1)).setText("");
    }

    /**
     * Appends the button's text to the input text.
     * @param view Used for accessing the button's text
     */
    public void appendButtonValue(View view) {
        ((TextView) findViewById(R.id.TextView1)).setText(((TextView) findViewById(R.id.TextView1)).getText() + "" + ((TextView) findViewById(view.getId())).getText());
    }
}