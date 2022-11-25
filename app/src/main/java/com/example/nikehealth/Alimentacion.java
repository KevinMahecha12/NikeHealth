package com.example.nikehealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.datosclase;

public class Alimentacion extends AppCompatActivity {

    Spinner comidas;
    EditText desayuno,comida,cena;
    RadioButton uno,dos,tres;
    RadioGroup rg;
    private Integer[] arrcomidas = {1,2,3,4,5,6};
    datosclase d = new datosclase();
    alimentacionclase a = new alimentacionclase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);

        comidas = findViewById(R.id.COMIDAS_DIARIAS);
        desayuno = findViewById(R.id.DESAYUNO);
        comida = findViewById(R.id.COMIDA);
        cena = findViewById(R.id.CENA);

        uno = findViewById(R.id.RG1litros);
        dos = findViewById(R.id.RG2litros);
        tres = findViewById(R.id.RG3litros);
        rg = findViewById(R.id.RADIOGRUPO);

        uno.setChecked(true);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.spinner, arrcomidas);
        comidas.setAdapter(adapter);

    }
    public void registraralimentacion(View view) {

        if (comida.getText().toString().trim().length() == 0 || desayuno.getText().toString().trim().length() == 0 || cena.getText().toString().trim().length() == 0)
        {
            if (comida.getText().toString().trim().length() == 0) {
                comida.setError("Ingrese las calorías para continuar");
                comida.requestFocus();
            }
            if (desayuno.getText().toString().trim().length() == 0) {
                desayuno.setError("Ingrese las calorías para continuar");
                desayuno.requestFocus();
            }
            if (cena.getText().toString().trim().length() == 0) {
                cena.setError("Ingrese las calorías para continuar");
                cena.requestFocus();
            }

        } else {

            a.setComidas(Integer.parseInt(comidas.getSelectedItem().toString()));
            a.setDesayunoCalorias(Integer.parseInt(desayuno.getText().toString()));
            a.setComidaCalorias(Integer.parseInt(comida.getText().toString()));
            a.setCenaCalorias(Integer.parseInt(cena.getText().toString()));

            if (uno.isChecked()) {
                a.setOpcionLitrosAgua(1);
            }
            if (dos.isChecked()) {
                a.setOpcionLitrosAgua(2);
            }
            if (tres.isChecked()) {
                a.setOpcionLitrosAgua(3);
            }
            Intent intent = new Intent(this, Menu.class);
            d = (datosclase) getIntent().getSerializableExtra("datos");
            if (d != null) {
                intent.putExtra("datos",d);
                intent.putExtra("completado",1);
                intent.putExtra("alimentacion",a);
                intent.putExtra("completado2",1);
                startActivity(intent);
            } else {
                Toast.makeText(this, "VUELVA AL MENÚ Y REGISTRE SUS DATOS",Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void regresar(View view) {
        finish();
    }
}
