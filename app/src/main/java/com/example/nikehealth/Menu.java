package com.example.nikehealth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.datosclase;
import java.math.BigDecimal;

public class Menu extends AppCompatActivity {

    datosclase dat = new datosclase();
    alimentacionclase alim = new alimentacionclase();
    int contador,contador2,contador3,contador4;
    TextView resHabitos, resAlimentos, resSalud;
    Button resDatos;
    TextView titulo, inicio;
    LinearLayout ly;
    int desicion = 0;
    int desicion2 = 0;
    int desicion22 = 0;
    int desicion3 = 0;
    boolean insuficiente,normal,sobrepeso,obesidad;
    boolean ingestanormal;
    boolean aguanormal;
    boolean entrecomidasnormal;
    String agua = null;
    String ingesta = null;
    String entrecomidas =  null;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
        dat = (datosclase) getIntent().getSerializableExtra("datos");
        alim = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
        titulo = findViewById(R.id.TITULO);
        inicio = findViewById(R.id.iniciodiagnostico);
        resDatos = findViewById(R.id.faltadatos);
        resHabitos = findViewById(R.id.faltahabitos);
        resAlimentos = findViewById(R.id.faltaalimentos);
        resSalud = findViewById(R.id.faltasalud);
        ly = findViewById(R.id.LAYOUTUSADO);

            if (dat != null) {
                contador = (int) getIntent().getSerializableExtra("completado");

                if (contador == 1) {
                    inicio.setText("Si sus registros se muestran en color NARANJA o ROJO puede dar clic en ellos para ver mas" +
                            " información de su advertencia");
                    resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                    int x = 2; // poner punto despues de x digito
                    BigDecimal unscaled = new BigDecimal(dat.getEstatura());
                    BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);
                    float imc = (float) ((dat.getPeso()) / (Math.pow(scaled.floatValue(), 2)));
                    String resultadoIMC = null;
                    String genero  = null;
                    if (imc < 18.5) {
                        // peso insuficiente
                        resultadoIMC = "Su IMC es : " + imc + ", su peso es insuficiente";
                        resDatos.setClickable(true);
                        insuficiente = true;
                        resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));

                    }
                    if (imc >= 18.5 && imc <= 24.9) {
                        //peso normal o saludable
                        resDatos.setClickable(true);
                        resultadoIMC = "Su IMC es : " + imc + ", su peso esta normalmente saludable!";
                        normal = true;
                    }
                    if (imc >= 25.0 && imc <= 29.9) {
                        //sobrepeso
                        resDatos.setClickable(true);
                        resultadoIMC = "Su IMC es : " + imc + ", usted sufre de sobrepeso";
                        resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                        sobrepeso = true;
                    }
                    if (imc >= 30) {
                        //obesidad
                        resDatos.setClickable(true);
                        obesidad = true;
                        resultadoIMC = "Su IMC es : " + imc + ", usted sufre de obesidad";
                        resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (dat.getGenero() == 1) {
                        genero = "Género: Hombre";
                    }
                    if (dat.getGenero() == 2) {
                        genero = "Género: Mujer";
                    }

                    resDatos.setText("Nombre: " + dat.getNombre() + "\n\n" + "Edad: " + dat.getEdad() + "\n\n" + genero +
                            "\n" + "Peso: " + dat.getPeso() + "kg" + "\n\n" + "Estatura: " + dat.getEstatura() + "cm" + "\n\n" + resultadoIMC);
                }
        }
        if (alim != null) {
            contador2 = (int) getIntent().getSerializableExtra("completado2");
            if (contador2 == 1) {
                resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                float caloriastotales = 0;
                if (alim.getOpcionLitrosAgua() == 1) {
                    agua = "Consumo de agua al día: 1-2L";
                    aguanormal = false;
                }
                if (alim.getOpcionLitrosAgua() == 2) {
                    aguanormal = true;
                    agua = "Consumo de agua al día: 2-3L";
                }
                if (alim.getOpcionLitrosAgua() == 3) {
                    aguanormal = true;
                    aguanormal = false;
                    agua = "Consumo de agua al día: +3L";
                }
                if (dat.getEdad()>=14 && alim.getOpcionLitrosAgua() == 1) {
                    aguanormal = false;
                    resAlimentos.setClickable(true);
                    resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    agua = "Consumo de agua al día: 1-2L, para tu edad, deberias consumir mas agua!";
                }
                if(alim.getOpcionLitrosAgua() == 3) {
                    agua = "Consumo de agua al día: 1-2L, evita tomar mas de 3L de agua al día, pues puede ser dañino";
                }
                caloriastotales = alim.getDesayunoCalorias()+alim.getComidaCalorias()+alim.getCenaCalorias();

                if(dat.getGenero() == 1 && caloriastotales >=2000 && caloriastotales <=2500) {
                    resAlimentos.setClickable(true);
                    ingestanormal = true;
                    ingesta = "Su ingesta de calorías es saludable!, su total es : " +caloriastotales;
                }
                if(caloriastotales <1590) {
                    ingestanormal = false;
                    resAlimentos.setClickable(true);
                    resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    ingesta = "Su ingesta de calorías es muy baja!, su total es : " +caloriastotales;
                }
                if(caloriastotales >2600) {
                    ingestanormal = false;
                    resAlimentos.setClickable(true);
                    resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    ingesta = "Su ingesta de calorías es muy alta!, su total es : " +caloriastotales;
                }
                if(dat.getGenero() == 2 && caloriastotales >=1590 && caloriastotales <=2000) {
                    ingestanormal = true;
                    resAlimentos.setClickable(true);
                    ingesta = "Su ingesta de calorías es saludable!, su total es : " +caloriastotales;
                }

                if (alim.getComidas() <=3) {
                    entrecomidasnormal = true;
                    resAlimentos.setClickable(true);
                    entrecomidas = "Veces que come entre comidas: "+alim.getComidas();
                }
                if (alim.getComidas() >3) {
                    entrecomidasnormal = false;
                    resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    resAlimentos.setClickable(true);
                    entrecomidas = "Veces que come entre comidas: "+alim.getComidas() +", come bastante entre comidas, lo cual no es recomendable!";
                }

                resAlimentos.setText(entrecomidas+"\n\n"+
                        "Calorías por desayuno: "+alim.getDesayunoCalorias()+"\n\n"+
                        "Calorías por comida: "+alim.getComidaCalorias()+"\n\n"+
                        "Calorías por cena: "+alim.getCenaCalorias()+"\n\n"+agua + "\n\n"+
                        ingesta);
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

                dat = (datosclase) getIntent().getSerializableExtra("datos");
                Intent alimentacion = new Intent(getApplicationContext(), Alimentacion.class);
                alimentacion.putExtra("datos",dat);
                startActivity(alimentacion);
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
    public void VistaAlimentacion(View view) {

        if(ingestanormal == true) {
            desicion2 = 1;
        } else {
            desicion2 = 2;
        }
        if (aguanormal == true) {
            desicion22 = 1;
        }
        if (aguanormal == false) {
            desicion22 = 2;
        }
        if (entrecomidasnormal == true) {
            desicion3 = 1;
        }
        if (entrecomidasnormal == false) {
            desicion3 = 2;
        }
        Intent intent = new Intent(this, ResultadosAlimentacion.class);
        intent.putExtra("alimentacion",desicion2);
        intent.putExtra("agua",desicion22);
        intent.putExtra("entrecomidas",desicion3);
        startActivity(intent);

    }
    public void VistaPeso(View view) {

        if(insuficiente == true) {
            desicion = 1;
        }
        if(normal == true) {
            desicion = 2;
        }
        if(sobrepeso == true) {
            desicion = 3;
        }
        if(obesidad == true) {
            desicion = 4;
        }
        Intent intent = new Intent(this, Resultados.class);
        intent.putExtra("peso",desicion);
        startActivity(intent);

    }
}