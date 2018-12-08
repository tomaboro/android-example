package com.motek.contentprovidersexample.activities;

import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.motek.contentprovidersexample.R;
import com.motek.contentprovidersexample.providers.MyContentProvider;

public class MainActivity extends AppCompatActivity {
    private EditText keyEditText;
    private EditText valueEditText;
    private Button addButton;
    private Button retrieveButton;

    public void onAddButtonClicked(View v) {
        ContentValues values = new ContentValues();
        values.put("key", keyEditText.getText().toString());

        values.put("value", valueEditText.getText().toString());

        Uri uri = getContentResolver().insert(
                MyContentProvider.URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onRetrieveButtonClicked(View v) {
        String URL = MyContentProvider.URL;

        Uri values = Uri.parse(URL);
        Cursor c = managedQuery(values, null, null, null, "key");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex("key")) + ": " + c.getString(c.getColumnIndex("value")),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
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
