package com.motek.contentprovidersexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.motek.contentprovidersexample.R;

public class MainActivity extends AppCompatActivity {
    private EditText keyEditText;
    private EditText valueEditText;
    private Button addButton;
    private Button retrieveButton;

    public void onAddButtonClicked(View v) {

    }

    public void onRetrieveButtonClicked(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyEditText = findViewById(R.id.etKey);
        valueEditText = findViewById(R.id.etValue);
        addButton = findViewById(R.id.btnAdd);
        retrieveButton = findViewById(R.id.btnAdd);
    }
}
