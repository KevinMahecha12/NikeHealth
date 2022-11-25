package com.example.nikehealth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.habitosclase;

import java.math.BigDecimal;

public class Menu extends AppCompatActivity {

    datosclase dat = new datosclase();
    alimentacionclase alim = new alimentacionclase();
    habitosclase hab = new habitosclase();

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
    int DURMIOBIEN=0,TIENESIESTAS=0,SEACUESTATEMPRANO=0,TIENEOCIO=0,EQUILIBRIO=0,PROBLEMASALUD=0,PROBLEMAOCIO=0;
    boolean duermebien,tienesiestas,seacuestatemprano,tieneocio,tienesalud;
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
        hab = (habitosclase) getIntent().getSerializableExtra("habitos");

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
                    titulo.setText("Su diagnóstico ");
                    inicio.setText("Si sus registros se muestran en color NARANJA o ROJO puede dar clic en ellos para ver mas" +
                            " información de su advertencia.");
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

                    resDatos.setText("Nombre: " + dat.getNombre() +"."+"\n\n" + "Edad: " + dat.getEdad() +"."+ "\n\n" + genero +"."+
                            "\n\n" + "Peso: " + dat.getPeso() + "kg" +"."+ "\n\n" + "Estatura: " + dat.getEstatura() + "cm"+"."+ "\n\n" + resultadoIMC+".");
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

                resAlimentos.setText(entrecomidas+"."+"\n\n"+
                        "Calorías por desayuno: "+alim.getDesayunoCalorias()+"."+"\n\n"+
                        "Calorías por comida: "+alim.getComidaCalorias()+"."+"\n\n"+
                        "Calorías por cena: "+alim.getCenaCalorias()+"."+"\n\n"+agua +"."+"\n\n"+
                        ingesta+".");
            }
        }
        String habitos = null;
        if (hab != null) {
            contador3 = (int) getIntent().getSerializableExtra("completado3");
            if (contador3 == 1) {
                resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                String dia = null;
                String siestas = null;
                String sueño = null;
                String horadormir = null;
                String ocio = null;

                if(hab.getTiempoSiesta()==0 && hab.getTiempoOcio() >=8) {
                    resHabitos.setClickable(true);

                    TIENESIESTAS = 2;
                    TIENEOCIO = 1;
                    tienesiestas = false;
                    tieneocio = true;
                    siestas ="Usted no suele tener siestas y tiene mucho tiempo de ocio, lo cual puede afectar a su salud!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if(hab.getTiempoSiesta() == 0) {
                    resHabitos.setClickable(true);

                    TIENESIESTAS = 2;
                    tienesiestas = false;
                    siestas ="Usted no suele tener siestas, considere tener un mínimo de 30 minutos si tiene mucho trabajo!";
                }
                if(hab.getTiempoSiesta() >= 1) {
                    resHabitos.setClickable(true);
                    tienesiestas = true;
                    TIENESIESTAS = 1;

                    siestas ="Usted suele tomar siestas de: "+hab.getTiempoSiesta()+"HR(S) , si trabaja mucho, considere mantener este tiempo para descanar!";
                }
                if(hab.getTiempoSueño() <= 7 ) {
                    resHabitos.setClickable(true);
                    duermebien = false;
                    DURMIOBIEN = 2;

                    sueño = "Usted suele dormir : "+hab.getTiempoSueño()+" HR(S), lo cual es poco, considere dormir más!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if(hab.getTiempoSueño() >= 8 ) {
                    resHabitos.setClickable(true);
                    duermebien = true;
                    DURMIOBIEN = 1;

                    sueño = "Usted suele dormir : "+hab.getTiempoSueño()+" HR(S), lo cual es considerado lo suficiente para tener buen descanso!";
                }

                if(hab.getHoraDormir() >= 11) {
                    resHabitos.setClickable(true);
                    seacuestatemprano = false;
                    SEACUESTATEMPRANO = 2;

                    horadormir = "Usted suele dormirse a las : "+hab.getHoraDormir()+", lo cual es bastante tarde y no recomendable!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if(hab.getHoraDormir() < 11) {
                    resHabitos.setClickable(true);

                    SEACUESTATEMPRANO = 1;
                    seacuestatemprano = true;
                    horadormir = "Usted suele dormirse a las : "+hab.getHoraDormir()+", lo cual es temprano y saludable!";
                }


                if (hab.getDiaSemana() == 1) {
                    resHabitos.setClickable(true);

                    dia = "Dias en los que suele realizar las actividades registradas: Lunes a Viernes";
                }
                if (hab.getDiaSemana() == 2) {
                    resHabitos.setClickable(true);

                    dia = "Dias en los que suele realizar las actividades registradas: Sabado a Domingo";
                }

                if (hab.getOcio()==1 && hab.getSalud() == 1 && hab.getTrabajo() == 1) {
                    resHabitos.setClickable(true);

                    EQUILIBRIO = 1;

                    habitos = "Sus hábitos en sus actividades destacan en : Ocio,Salud y Trabajo ó Esutudio";
                }
                if (hab.getOcio()==1 && hab.getSalud() == 0 && hab.getTrabajo() == 0) {
                    resHabitos.setClickable(true);

                    tienesalud = false;
                    PROBLEMASALUD = 1;
                    tienesalud = false;

                    habitos = "Sus hábitos en sus actividades destacan en : Ocio "+"\n"+" Nota: intente dedicarle tiempo a su salud!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if (hab.getOcio()==1 && hab.getSalud() == 1 && hab.getTrabajo() == 0) {
                    resHabitos.setClickable(true);

                    EQUILIBRIO = 1;

                    habitos = "Sus hábitos en sus actividades destacan en : Ocio y Salud";
                }
                if (hab.getOcio()==0 && hab.getSalud() == 1 && hab.getTrabajo() == 0) {
                    resHabitos.setClickable(true);

                    EQUILIBRIO = 1;

                    habitos = "Sus hábitos en sus actividades destacan en : Salud";
                }
                if (hab.getOcio()==0 && hab.getSalud() == 0 && hab.getTrabajo() == 1) {
                    resHabitos.setClickable(true);

                    PROBLEMAOCIO = 1;

                    habitos = "Sus hábitos en sus actividades destacan en : Trabajo ó Estudio "+"\n"+" Nota: intente también darse tiempo a usted mismo";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if (hab.getOcio()==1 && hab.getSalud() == 0 && hab.getTrabajo() == 1) {
                    resHabitos.setClickable(true);

                    PROBLEMASALUD = 1;
                    tienesalud = true;

                    habitos = "Sus hábitos en sus actividades destacan en : Ocio y Trabajo ó Estudio"+"\n"+" Nota: intente dedicarle tiempo a su salud!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if (hab.getOcio()==0 && hab.getSalud() == 1 && hab.getTrabajo() == 1) {
                    resHabitos.setClickable(true);

                    EQUILIBRIO = 1;

                    habitos = "Sus hábitos en sus actividades destacan en : Salud y Trabajo ó Estudio";
                }
                if(hab.getTiempoOcio()>3) {
                    resHabitos.setClickable(true);

                    PROBLEMAOCIO = 1;

                    ocio = "Su tiempo de ocio : "+hab.getTiempoOcio()+" HR(S) es considerado alto, considere bajarlo y usar ese tiempo en su salud, estudio o trabajo!";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }
                if(hab.getTiempoOcio()>0 && hab.getTiempoOcio()<3) {
                    resHabitos.setClickable(true);

                    PROBLEMAOCIO = 2;
                    tieneocio = true;

                    ocio = "Su tiempo de ocio : "+hab.getTiempoOcio()+" HR(S) es considerado bajo, lo cual no le afecta directamente";
                }
                if(hab.getTiempoOcio()==0) {
                    resHabitos.setClickable(true);

                    tieneocio = false;

                    ocio = "Su tiempo de ocio es 0, Considere tener un poco de tiempo para usted mismo y divertirse no todo es el trabajo o el estudio";
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                }

            resHabitos.setText(dia+"."+"\n\n"+horadormir+"."+"\n\n"+ sueño+"."+ "\n\n" + habitos+"."+"\n\n" +ocio+"."+"\n\n"+siestas+".");

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

                dat = (datosclase) getIntent().getSerializableExtra("datos");
                alim = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
                Intent habitos = new Intent(getApplicationContext(), Habitos.class);
                habitos.putExtra("datos",dat);
                habitos.putExtra("alimentacion",alim);
                startActivity(habitos);
                break;

            case R.id.itmSalud:
                intent = new Intent(getApplicationContext(), Salud.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void VistaHabitos(View view) {

    if(duermebien == true){
        DURMIOBIEN = 1;
    } else {
        DURMIOBIEN = 2;
    }
    if(tienesiestas == true) {
        TIENESIESTAS = 1;
    }else {
        TIENESIESTAS = 2;
    }
    if (seacuestatemprano == true) {
        SEACUESTATEMPRANO = 1;
    }else {
        SEACUESTATEMPRANO = 2;
    }
    if(tieneocio == true) {
        TIENEOCIO  = 1;
    } else {
        TIENEOCIO = 2;
    }

        Intent intent = new Intent(this, ResultadosHabitos.class);
        intent.putExtra("duermebien",DURMIOBIEN);
        intent.putExtra("tienesiesta",TIENESIESTAS);
        intent.putExtra("temprano",SEACUESTATEMPRANO);
        intent.putExtra("ocio",TIENEOCIO);
        intent.putExtra("problemaocio",PROBLEMAOCIO);
        startActivity(intent);


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