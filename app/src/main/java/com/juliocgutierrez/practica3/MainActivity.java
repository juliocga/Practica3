package com.juliocgutierrez.practica3;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eExpo, ePrac, eProy;
    TextView eNota,texpo,tprac,tproy;
    double pexpo,ppract,pproyec;
    Button bCalc,bborrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText) findViewById(R.id.eExpo);
        ePrac = (EditText) findViewById(R.id.ePrac);
        eProy = (EditText) findViewById(R.id.eProy);
        eNota = (TextView) findViewById(R.id.eNotaF);
        texpo=(TextView)findViewById(R.id.pExpo);
        tprac=(TextView)findViewById(R.id.pPrac);
        tproy=(TextView)findViewById(R.id.pProy);
        bCalc = (Button) findViewById(R.id.bCalcular);
        bborrar= (Button) findViewById(R.id.bborrar);

        texpo.setHint(String.valueOf(pexpo+"%"));
        tprac.setHint(String.valueOf(ppract+"%"));
        tproy.setHint(String.valueOf(pproyec+"%"));
        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota,practica,proyecto,exposicion;

                if(!eExpo.getText().toString().isEmpty() && !ePrac.getText().toString().isEmpty() && !eProy.getText().toString().isEmpty() ) {
                    exposicion=Double.parseDouble(eExpo.getText().toString());
                    practica=Double.parseDouble(ePrac.getText().toString());
                    proyecto=Double.parseDouble(eProy.getText().toString());
                    if(exposicion>=0 && exposicion<=5 && practica>=0 && practica<=5 && proyecto>=0 && proyecto<=5 ) {
                        nota = exposicion *( pexpo / 100) + practica * (ppract / 100) +  proyecto *( pproyec / 100);

                        eNota.setText(String.format("%.1f", nota));
                    }else{
                        Toast.makeText(MainActivity.this, "Error, rango de notas 0-5",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Faltan notas",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bborrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                eExpo.getText().clear();
                ePrac.getText().clear();
                eProy.getText().clear();
                eNota.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mConfigurar) {
            //Toast.makeText(this, "Presionó configurar", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("pExpo",15);
            intent.putExtra("pPrac",50);
            intent.putExtra("pProy",35);
            startActivityForResult(intent, 1234);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String exp, pra, pro;
        if (requestCode == 1234 && resultCode == RESULT_OK){
            exp = data.getExtras().getString("npExp");
            pra = data.getExtras().getString("npPrac");
            pro = data.getExtras().getString("npProy");

            pexpo=Double.parseDouble(exp);
            ppract=Double.parseDouble(pra);
            pproyec=Double.parseDouble(pro);
            texpo.setHint(String.valueOf(pexpo+"%"));
            tprac.setHint(String.valueOf(ppract+"%"));
            tproy.setHint(String.valueOf(pproyec+"%"));

        }








    }
}
