package com.example.romancalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RomToInt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rom_to_int);
        ((TextView) findViewById(R.id.inTextA2)).setText("");
    }

    /**
     * Appends the button's text to the input text.
     * @param view Used for accessing the button's text
     */
    public void appendButtonValue(View view) {
        ((TextView) findViewById(R.id.inTextA2)).setText(((TextView) findViewById(R.id.inTextA2)).getText() + "" + ((TextView) findViewById(view.getId())).getText());
    }

    /**
     * Clears both the input and output text fields
     * @param view Used for accessing the text fields
     */
    public void clearTexts (View view) {
        ((TextView) findViewById(R.id.inTextA2)).setText("");
        ((TextView) findViewById(R.id.outTextA2)).setText("");
    }

}
