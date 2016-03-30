package com.juliocgutierrez.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText epExpo, epPrac,epProy;
    Button bGuardar,bborrarp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        epExpo = (EditText) findViewById(R.id.epExpo);
        epPrac = (EditText) findViewById(R.id.epPrac);
        epProy = (EditText) findViewById(R.id.epProy);
        bGuardar = (Button) findViewById(R.id.bGuardar);
        bborrarp= (Button) findViewById(R.id.bborrarp);
        Bundle extras = getIntent().getExtras();

        epExpo.setText(String.valueOf(extras.getInt("pExpo")));
        epPrac.setText(String.valueOf(extras.getInt("pPrac")));
        epProy.setText(String.valueOf(extras.getInt("pProy")));

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double suma;
                if (!epExpo.getText().toString().isEmpty() && !epPrac.getText().toString().isEmpty() && !epProy.getText().toString().isEmpty()) {
                    suma = Double.parseDouble(epProy.getText().toString()) + Double.parseDouble(epPrac.getText().toString()) + Double.parseDouble(epExpo.getText().toString());

                    if (suma == 100) {
                        Intent intent = new Intent();
                        intent.putExtra("npExp", epExpo.getText().toString());
                        intent.putExtra("npPrac", epPrac.getText().toString());
                        intent.putExtra("npProy", epProy.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(SettingsActivity.this, "La suma debe ser 100", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SettingsActivity.this, "Faltan porcentajes", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bborrarp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                epExpo.getText().clear();
                epPrac.getText().clear();
                epProy.getText().clear();

            }
        });

    }
}
