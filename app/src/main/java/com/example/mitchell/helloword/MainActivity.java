package com.example.mitchell.helloword;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String DEFAULT_TEXT = "Mitchell is awesome!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setupMainActivityButtons();
    }

    private void setupViewColor(final RelativeLayout relativeLayout) {
        final Random rand = new Random();
        final int[] rainbow = getResources().getIntArray(R.array.rainbow);

        findViewById(R.id.main_viewColor_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("setupTextColorButton", "Button clicked");
                int randIdx = rand.nextInt(rainbow.length);
                relativeLayout.setBackgroundColor(rainbow[randIdx]);
            }
        });
    }

    private void setupTextColorButton() {
        final Random rand = new Random();
        final int[] rainbow = getResources().getIntArray(R.array.rainbow);
        final TextView inputTextView = (TextView) findViewById(R.id.main_textView);

        findViewById(R.id.main_textColor_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("setupTextColorButton", "Button clicked");
                int randIdx = rand.nextInt(rainbow.length);
                inputTextView.setTextColor(rainbow[randIdx]);
            }
        });
    }

    private void setupTextStringButton(final TextView inputTextView, final EditText inputEditText) {

        findViewById(R.id.main_textString_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("setupTextStringButton", "Button clicked");
                String text = inputEditText.getText().toString();
                if(text.isEmpty()) text = DEFAULT_TEXT;
                inputTextView.setText(text);
            }
        });
    }

    private void setupResetDefaultButton(final TextView inputTextView, final RelativeLayout relativeLayout, final EditText inputEditText) {
        findViewById(R.id.main_reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("setupResetDefaultButton", "Button clicked");
                inputTextView.setText(DEFAULT_TEXT);
                inputTextView.setTextColor(Color.BLACK);
                relativeLayout.setBackgroundColor(Color.WHITE);
                inputEditText.setText("");
            }
        });
    }

    private void setupMainActivityButtons() {
        TextView inputTextView = (TextView) findViewById(R.id.main_textView);
        inputTextView.setText(DEFAULT_TEXT);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_parent_view);
        EditText editText = (EditText) findViewById(R.id.inputText);

        this.setupTextStringButton(inputTextView, editText);
        this.setupViewColor(relativeLayout);
        this.setupTextColorButton();
        this.setupResetDefaultButton(inputTextView, relativeLayout, editText);
    }
}
