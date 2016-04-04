package com.juliocgutierrez.barranca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void ondemo(View view) {
        Intent i=new Intent(MenuActivity.this, InfoActivity.class);
        startActivity(i);
    }

    public void onpubli(View view){
        Intent i=new Intent(MenuActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void onhoteles(View view){
        Intent i=new Intent(MenuActivity.this, HotelesActivity.class);
        startActivity(i);
    }

    public void onbares(View view){
        Intent i=new Intent(MenuActivity.this, BaresActivity.class);
        startActivity(i);
    }

    public void onsitios(View view){
        Intent i=new Intent(MenuActivity.this,SitiosActivity.class);
        startActivity(i);
    }

}
