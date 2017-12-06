package com.example.yiaoping.fitnessapp;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.aware.Characteristics;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.yiaoping.fitnessapp.R.id.editText5;

public class inputActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText weight;
    EditText reps;

    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Exercise, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
        switch(position){
            case 0:

                break;

            case 1:

                break;

            case 2:

                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void saveButton(View view){
        weight = (EditText)findViewById(R.id.editText5);
        reps = (EditText)findViewById(R.id.editText6);
        weight.setText("");
        reps.setText("");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, R.string.saved_data, duration);
        toast.show();
    }
}
