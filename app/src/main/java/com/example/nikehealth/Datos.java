package com.example.nikehealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Datos extends AppCompatActivity {

    EditText nombre,edad,ocupacion,peso,estatura;
    datosclase d = new datosclase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        nombre = findViewById(R.id.NOMBRE);
        edad = findViewById(R.id.EDAD);
        ocupacion = findViewById(R.id.OCUPACION);
        peso = findViewById(R.id.PESO);
        estatura = findViewById(R.id.ESTATURA);

    }
    public void registrardatos(View view) {

        if (nombre.getText().toString().trim().isEmpty() || edad.getText().toString().trim().isEmpty() ||
        ocupacion.getText().toString().trim().isEmpty() || peso.getText().toString().trim().isEmpty() ||
                estatura.getText().toString().trim().isEmpty()) {


            if (nombre.getText().toString().trim().isEmpty()) {

                nombre.setError("Rellene el nombre para continuar");
                nombre.requestFocus();

            }
            if (edad.getText().toString().trim().isEmpty()) {

                edad.setError("Rellene el nombre para continuar");
                edad.requestFocus();

            }
            if (ocupacion.getText().toString().trim().isEmpty()) {

                ocupacion.setError("Rellene el nombre para continuar");
                ocupacion.requestFocus();

            }
            if (peso.getText().toString().trim().isEmpty()) {

                peso.setError("Rellene el nombre para continuar");
                peso.requestFocus();

            }
            if (estatura.getText().toString().trim().isEmpty()) {

                estatura.setError("Rellene el nombre para continuar");
                estatura.requestFocus();

            }

        } else {
            Toast.makeText(this, "Se registraron correctamente los datos!",Toast.LENGTH_SHORT).show();
            d.setNombre(nombre.getText().toString());
            d.setEdad(Integer.parseInt(edad.getText().toString()));
            d.setOcupacion(ocupacion.getText().toString());
            d.setPeso(Double.parseDouble(peso.getText().toString()));
            d.setEstatura(Double.parseDouble(estatura.getText().toString()));
            Intent intent = new Intent(this, Menu.class);
            intent.putExtra("datos",d);
            intent.putExtra("completado",1);
            startActivity(intent);
        }

    }
    public void regresar(View view) {
        finish();
    }
}
