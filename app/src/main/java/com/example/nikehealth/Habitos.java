package com.example.nikehealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nikehealth.clases.Usuario;
import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.habitosclase;
import com.example.nikehealth.clases.Usuario;

import java.util.ArrayList;

public class Habitos extends AppCompatActivity {

    Spinner diasemana;
    EditText horadormir,horasueño,tiempoocio,tiemposiesta;
    CheckBox trabajar,gym,deporte,caminata,estudiar,vertv,videojuegos,meditar,ocio,siesta;
    habitosclase h = new habitosclase();
    datosclase d = new datosclase();
    alimentacionclase a = new alimentacionclase();
    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(10);

    private String[] dias = {"Lunes-Viernes","Sabado-Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        diasemana = findViewById(R.id.diaSpinner);

        horadormir = findViewById(R.id.HORADORMIR);
        horasueño = findViewById(R.id.TIEMPOSUENO);
        tiempoocio = findViewById(R.id.TIEMPOOCIO);
        tiemposiesta = findViewById(R.id.TIEMPOSIESTA);

        trabajar = findViewById(R.id.trabajarCB);
        gym = findViewById(R.id.gymCB);
        deporte = findViewById(R.id.deporteCB);
        caminata = findViewById(R.id.caminataCB);
        estudiar = findViewById(R.id.estudiarCB);
        vertv = findViewById(R.id.vertvCB);
        videojuegos = findViewById(R.id.videojuegosCB);
        meditar = findViewById(R.id.meditarCB);
        ocio = findViewById(R.id.ocioCB);
        siesta = findViewById(R.id.siestaCB);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner2, dias);
        diasemana.setAdapter(adapter);




    }
    public void registrarhabitos(View view) {

        if(trabajar.isChecked()==false && gym.isChecked() == false && deporte.isChecked() == false && caminata.isChecked() == false
                && estudiar.isChecked()==false && vertv.isChecked() == false && videojuegos.isChecked() == false && meditar.isChecked() == false) {
            Toast.makeText(this, "Seleccione minimo 1 actividad que hace al día!",Toast.LENGTH_SHORT).show();
        } else {



            if(horadormir.getText().toString().trim().isEmpty() || horasueño.getText().toString().trim().isEmpty()) {

                if (horadormir.getText().toString().trim().isEmpty()) {

                    horadormir.setError("Rellene la hora para continuar");
                    horadormir.requestFocus();

                }
                if (horasueño.getText().toString().trim().isEmpty()) {

                    horasueño.setError("Rellene la hora para continuar");
                    horasueño.requestFocus();

                }

                if(vertv.isChecked()) {
                    ocio.setChecked(true);
                }
                if(videojuegos.isChecked()) {
                    ocio.setChecked(true);
                }
            }else {

                if (ocio.isChecked() == true) {
                    if (tiempoocio.getText().toString().trim().isEmpty()) {

                        tiempoocio.setError("Rellene el tiempo para continuar");
                        tiempoocio.requestFocus();

                    } else {
                        h.setTiempoOcio(Integer.parseInt(tiempoocio.getText().toString()));
                    }

                }

                if(siesta.isChecked() == true) {
                    if (Integer.parseInt(tiemposiesta.getText().toString().trim()) == 0) {

                        tiemposiesta.setError("Rellene el tiempo para continuar");
                        tiemposiesta.requestFocus();

                    } else {
                        h.setTiempoSiesta(Integer.parseInt(tiemposiesta.getText().toString()));
                    }
                }



                if(trabajar.isChecked()) {
                    h.setTrabajo(1);
                }
                if(gym.isChecked()) {
                    h.setSalud(1);
                }
                if(deporte.isChecked()) {
                    h.setSalud(1);
                }
                if(caminata.isChecked()) {
                    h.setSalud(1);
                }
                if(estudiar.isChecked()) {
                    h.setTrabajo(1);
                }
                if(vertv.isChecked()) {
                    h.setOcio(1);
                }
                if(videojuegos.isChecked()) {
                    h.setOcio(1);
                }
                if(meditar.isChecked()) {
                    h.setSalud(1);
                }

                if(diasemana.getSelectedItem().toString().equals("Lunes-Viernes")) {
                    h.setDiaSemana(1);
                }
                if(diasemana.getSelectedItem().toString().equals("Sabado-Domingo")) {
                    h.setDiaSemana(2);
                }

                h.setHoraDormir(Integer.parseInt(horadormir.getText().toString()));
                h.setTiempoSueño(Integer.parseInt(horasueño.getText().toString()));

                Intent intent = new Intent(this, Menu.class);
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");


                if (ocio.isChecked()) {

                    if ( Integer.parseInt(tiempoocio.getText().toString() )== 0) {
                        tiempoocio.setError("Rellene el tiempo de ocio!");
                        tiempoocio.setFocusable(true);
                        Toast.makeText(this, "Rellene el tiempo de ocioooooo",Toast.LENGTH_SHORT).show();
                    }

                } else  {
                    h.setOcio(0);
                }

                d = (datosclase) getIntent().getSerializableExtra("datos");
                a = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");

                if (d != null) {
                    intent.putExtra("datos",d);
                    intent.putExtra("completado",1);
                    intent.putExtra("habitos",h);
                    intent.putExtra("completado3",1);
                    intent.putExtra("arreglo",arrUsuario);
                    startActivity(intent);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "VUELVA AL MENÚ Y REGISTRE SUS DATOS",Toast.LENGTH_SHORT).show();
                }

                if (a != null) {
                    intent.putExtra("alimentacion",a);
                    intent.putExtra("completado2",1);

                    startActivity(intent);
                }







            }




   }


    }
    public void regresar(View view){
        finish();
    }
}
