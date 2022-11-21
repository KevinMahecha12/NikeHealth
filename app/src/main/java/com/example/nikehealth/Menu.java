package com.example.nikehealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Menu extends AppCompatActivity  {

    datosclase dat =  new datosclase();
    int contador;
    TextView resDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
        dat = (datosclase) getIntent().getSerializableExtra("datos");
        resDatos = findViewById(R.id.faltadatos);
    if (dat != null){
            contador  = (int) getIntent().getSerializableExtra("completado");
            if (contador == 1 ) {
                resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                resDatos.setText("Nombre: "+dat.getNombre()+"\n"+"Edad: "+dat.getEdad()+"\n"+"Ocupación: "+dat.getOcupacion()+
                        "\n"+"Peso: "+dat.getPeso() +"kg"+"\n"+"Estatura: "+dat.getEstatura()+"cm");
            }
        }
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
        //Se asocia el xml del menu al Activity
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //Variable para identificar la opcion
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.itmDatos:
                intent = new Intent(getApplicationContext(), Datos.class);
                startActivity(intent);
                break;

            case R.id.itmAlimentacion:
                intent = new Intent(getApplicationContext(), Alimentacion.class);
                startActivity(intent);
                break;

            case R.id.itmHabitos:
                intent = new Intent(getApplicationContext(), Habitos.class);
                startActivity(intent);
                break;

            case R.id.itmSalud:
                intent = new Intent(getApplicationContext(), Salud.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
