package com.example.raghadalsaggamid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addbttn=(Button)findViewById(R.id.bttnAdd);
        EditText id=(EditText)findViewById(R.id.editTextID);
        EditText name=(EditText)findViewById(R.id.editTextName);
        EditText surname=(EditText)findViewById(R.id.editTextsurname);
        EditText NationalID=(EditText)findViewById(R.id.editTextNationalID);

        Button bAct1=(Button)findViewById(R.id.button);
        Button bAct3=(Button)findViewById(R.id.button2);

        final DatabaseHelper MyDB = new DatabaseHelper(this);

        addbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String id_val = id.getText().toString();
                    String name_val = name.getText().toString();
                    String email_val = surname.getText().toString();
                    String phone_val = NationalID.getText().toString();

                    MyDB.addData(id_val, name_val, email_val, phone_val);
                    Log.d("Raghad","after adding value");

                    Toast.makeText(MainActivity2.this, "Successful Add", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    count=1;
                    Toast.makeText(MainActivity2.this,"Unsuccessful Add please insert all necessary data",Toast.LENGTH_LONG).show();
                }
            }

        });

        bAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });


        bAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
    }
}