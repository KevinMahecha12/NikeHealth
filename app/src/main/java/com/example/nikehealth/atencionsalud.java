package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.nikehealth.clases.Usuario;
import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.atencionsaludclase;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.habitosclase;

import java.util.ArrayList;


public class atencionsalud extends AppCompatActivity {

    CheckBox consultamedico,tomamedicamentos,problemasemocionales,padecimientoestres;

    datosclase d = new datosclase();
    alimentacionclase a = new alimentacionclase();
    habitosclase  h = new habitosclase();
    atencionsaludclase as = new atencionsaludclase();
    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atencionsalud);

        consultamedico = findViewById(R.id.MEDICO);
        tomamedicamentos = findViewById(R.id.MEDICINA);
        problemasemocionales = findViewById(R.id.EMOCIONAL);
        padecimientoestres = findViewById(R.id.ESTRES);

    }

    public void registraratensionsalud(View view) {

        if (consultamedico.isChecked() == false && tomamedicamentos.isChecked() == false &&
                problemasemocionales.isChecked() == false && padecimientoestres.isChecked() == false) {
            finish();
        } else {

            if (consultamedico.isChecked()==true) {
                as.setConsultamedico(true);
            }
            if (tomamedicamentos.isChecked()==true) {
                as.setTomamedicamentos(true);
            }
            if (problemasemocionales.isChecked()==true) {
                as.setProblemasemocionales(true);
            }
            if (padecimientoestres.isChecked()==true) {
                as.setPadecimientosestres(true);
            }


            Intent intent = new Intent(this, Menu.class);
            arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
            intent.putExtra("arreglo",arrUsuario);
            intent.putExtra("atencion",as);
            intent.putExtra("completado4",1);
            startActivity(intent);

            d = (datosclase) getIntent().getSerializableExtra("datos");
            a = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
            h = (habitosclase) getIntent().getSerializableExtra("habitos");



            if (d != null) {
                intent.putExtra("datos",d);
                intent.putExtra("completado",1);
                startActivity(intent);
            }

            if (a != null) {
                intent.putExtra("alimentacion",a);
                intent.putExtra("completado2",1);

                startActivity(intent);
            }

            if (h != null) {
                intent.putExtra("habitos",h);
                intent.putExtra("completado3",1);

                startActivity(intent);
            }




        }

    }
    public void regresar(View view){
        finish();
    }
}