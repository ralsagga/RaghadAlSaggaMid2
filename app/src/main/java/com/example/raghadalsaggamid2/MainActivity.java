package com.example.raghadalsaggamid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView reservation;
    Button bAct2;
    String weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=riyadh&appid=ec00986f68ad6ce7f6c39e980fffaa46&units=metric";
    ImageView weatherBackground;
    // Textview to show temperature and description
    TextView Temperature, Description, Humidity, Pressure,Sunrise,Sunset;
    Spinner spinner;
    Button button2;
    JSONObject jsonObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservation=(TextView) findViewById(R.id.txtReservation);
        Button button=(Button) findViewById(R.id.bttnDate);
        bAct2=findViewById(R.id.Activity2);

        Temperature = (TextView) findViewById(R.id.temperature);

        Humidity = (TextView) findViewById(R.id.humidity);

        Sunrise = (TextView) findViewById(R.id.sunrise);
        Sunset = (TextView) findViewById(R.id.sunset);
        weatherBackground = (ImageView) findViewById(R.id.weatherbackground);

        button = (Button)findViewById(R.id.button);
        spinner = (Spinner)findViewById(R.id.spinner);

       
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        bAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

    }
    Calendar c=Calendar.getInstance();
    DateFormat fmtDate=DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            reservation.setText("Your reservation is set for "+fmtDate.format(c.getTime()));
        }};


    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }





}