package com.juliocgutierrez.barranca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.macercade) {
            //Toast.makeText(this, "Presionó configurar", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuActivity.this, AcercaActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
