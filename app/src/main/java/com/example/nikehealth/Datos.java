package com.example.nikehealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.Usuario;

import java.util.ArrayList;

public class Datos extends AppCompatActivity {

    EditText nombre,edad,peso,estatura,id;
    RadioButton hombre,mujer;
    datosclase d = new datosclase();
    int genero=0;
    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        id = findViewById(R.id.ID);
        nombre = findViewById(R.id.NOMBRE);
        edad = findViewById(R.id.EDAD);
        hombre = findViewById(R.id.RBHombre);
        mujer = findViewById(R.id.RBMujer);
        peso = findViewById(R.id.PESO);
        estatura = findViewById(R.id.ESTATURA);
        hombre.setChecked(true);
    }
    public void registrardatos(View view) {

        if (nombre.getText().toString().trim().isEmpty() || edad.getText().toString().trim().isEmpty() || peso.getText().toString().trim().isEmpty() ||
                estatura.getText().toString().trim().isEmpty()) {


            if (nombre.getText().toString().trim().isEmpty()) {

                nombre.setError("Rellene el nombre para continuar");
                nombre.requestFocus();

            }
            if (edad.getText().toString().trim().isEmpty()) {

                edad.setError("Rellene el nombre para continuar");
                edad.requestFocus();

            }
            if (peso.getText().toString().trim().isEmpty()) {

                peso.setError("Rellene el nombre para continuar");
                peso.requestFocus();

            }
            if (estatura.getText().toString().trim().isEmpty()) {

                estatura.setError("Rellene el nombre para continuar");
                estatura.requestFocus();

            }
            if (id.getText().toString().trim().isEmpty()) {

                estatura.setError("Rellene el ID para continuar");
                estatura.requestFocus();

            }

        } else {

            if (hombre.isChecked()) {
               genero = 1;
            }
            if (mujer.isChecked()) {
                genero = 2;
            }
           // Toast.makeText(this, "Se registraron correctamente los datos!",Toast.LENGTH_SHORT).show();

            d.setId(Integer.parseInt(id.getText().toString()));
            d.setNombre(nombre.getText().toString());
            d.setEdad(Integer.parseInt(edad.getText().toString()));
            d.setGenero(genero);
            d.setPeso(Double.parseDouble(peso.getText().toString()));
            d.setEstatura(Double.parseDouble(estatura.getText().toString()));

            Intent intent = new Intent(this, Menu.class);
            intent.putExtra("datos",d);
            intent.putExtra("completado",1);
            intent.putExtra("id",d.getId());
            arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
            intent.putExtra("arreglo",arrUsuario);
            startActivity(intent);


        }

    }
    public void regresar(View view) {
        finish();
    }
}
