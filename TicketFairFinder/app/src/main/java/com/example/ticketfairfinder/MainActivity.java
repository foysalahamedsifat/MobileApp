package com.example.ticketfairfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] destination = { "Rajshahi", "Khulna", "Sylhet", "Rangpur", "Barishal", "Chattrogram", "Mymensingh"};
    String[] discription = {
            " Rajshahi Express : 10:30 Fair: 200 TK \n " +
                    "Prantik Rail : 11:30 Fair: 300 TK  \n " +
                    "Jantrik Rail : 11:30 Fair: 350 TK ",
            " Khulna Express : 10:30 Fair: 200 TK \n " +
                    "Prantik Express : 11:30 Fair: 400 TK  \n " +
                    "Jantrik Express : 11:30 Fair: 650 TK ",
            " Sylhet Express : 10:30 Fair: 241 TK \n " +
                    "Prantik Rail : 11:30 Fair: 258 TK  \n " +
                    "Jantrik Rail : 11:30 Fair: 456 TK ",
            " Rangpur Express : 10:30 Fair: 460 TK \n " +
                    "Prantik Rail : 11:30 Fair: 150 TK  \n " +
                    "Jantrik Rail : 11:30 Fair: 579 TK ",
            " Chattrogram  Express: 10:30 Fair: 360 TK \n " +
                    "Prantik Rail : 11:30 Fair: 379 TK  \n " +
                    "Jantrik Rail : 11:30 Fair: 300 TK ",

    };

    AppCompatSpinner spinner;
    MaterialButton btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setSpinner();

        handleClickEvent();

    }

    public void initView() {
        spinner = findViewById(R.id.spMainArray);
        btnView = findViewById(R.id.btnView);
    }

    public void setSpinner() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destination);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void handleClickEvent() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinner.getSelectedItemPosition();
                //tvResults.setText(districts[position]);
                Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                myIntent.putExtra("destination", destination[position]);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}