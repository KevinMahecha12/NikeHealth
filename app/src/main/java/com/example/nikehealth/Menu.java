package com.example.nikehealth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.nikehealth.clases.Usuario;
import com.example.nikehealth.clases.alimentacionclase;
import com.example.nikehealth.clases.atencionsaludclase;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.habitosclase;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    datosclase dat = new datosclase();
    alimentacionclase alim = new alimentacionclase();
    habitosclase hab = new habitosclase();
    atencionsaludclase as = new atencionsaludclase();
    int x=-1;
    boolean registro,clic=false;
    int contador,contador2,contador3,contador4,contadorarray;
    TextView resHabitos, resAlimentos, resSalud;
    Button resDatos;
    TextView titulo, inicio;
    LinearLayout ly;
    EditText id;
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
    boolean consultamedico,tomamedicamentos,problemasemocionales,padecimientoestres;
    int medico=0,medicamentos=0,emocionales=0,estres=0;
    int general;
    private int tamañoarray = 10;
    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(tamañoarray);
    int ID_CAPTADO;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);

        dat = (datosclase) getIntent().getSerializableExtra("datos");
        alim = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
        hab = (habitosclase) getIntent().getSerializableExtra("habitos");
        as = (atencionsaludclase) getIntent().getSerializableExtra("atencion");

        titulo = findViewById(R.id.TITULO);
        inicio = findViewById(R.id.iniciodiagnostico);
        resDatos = findViewById(R.id.faltadatos);
        resHabitos = findViewById(R.id.faltahabitos);
        resAlimentos = findViewById(R.id.faltaalimentos);
        resSalud = findViewById(R.id.faltasalud);
        id = findViewById(R.id.ID);
        ly = findViewById(R.id.LAYOUTUSADO);

        if (dat != null) {
                contador = (int) getIntent().getSerializableExtra("completado");
                ID_CAPTADO++;
                if (contador == 1) {
                    resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                    resDatos.setText("Datos generales registrados!");
                }
        }
        if (alim != null) {
            contador2 = (int) getIntent().getSerializableExtra("completado2");
            if (contador2 == 1) {

                resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                resAlimentos.setText("Datos de alimentación registrados!");
            }
        }
        if (hab != null) {
            contador3 = (int) getIntent().getSerializableExtra("completado3");
            if (contador3 == 1) {
                resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                resHabitos.setText("Datos de hábitos registrados!");
                general++;
                titulo.setText("Su diagnóstico ");
                inicio.setText("Si sus registros se muestran en color NARANJA o ROJO puede dar clic en ellos para ver mas" + " información de su advertencia.");
                x++;

                if (x<tamañoarray) {

                    arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                    arrUsuario.add(x, new  Usuario(dat.getId(),dat.getNombre(),dat.getEdad(),dat.getGenero(),dat.getPeso(),dat.getEstatura(),alim.getComidas(),alim.getDesayunoCalorias(),
                            alim.getComidaCalorias(),alim.getCenaCalorias(),alim.getOpcionLitrosAgua(),hab.getDiaSemana(),hab.getHoraDormir(),hab.getTiempoSueño(),
                            hab.getOcio(),hab.getSalud(),hab.getTrabajo(),hab.getTiempoOcio(),hab.getTiempoSiesta())
                    );
                    registro = true;
                }
                if (x == tamañoarray) {
                    Toast.makeText(this,"¡Se llego al limite los diagnosticos registrados permitidos por registrar!",Toast.LENGTH_LONG).show();
                }

            }
        }

        if (as != null) {
            contador4 = (int) getIntent().getSerializableExtra("completado4");
            if (contador4 == 1) {
                resSalud.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));


                String consulta = null,medicamentos=null,emocionalmente=null,estres=null;

                if (as.isConsultamedico() == true) {
                    resSalud.setClickable(true);
                    consultamedico = true;
                   consulta= "Usted SI ha consultado al médico en los ultimos meses/semanas/días.";
                } else {
                    resSalud.setClickable(true);
                    consultamedico = false;
                    consulta= "Usted NO ha consultado al médico en los ultimos meses/semanas/días.";
                }
                if(as.isTomamedicamentos() == true) {
                    resSalud.setClickable(true);
                    tomamedicamentos = true;
                    medicamentos = "Usted SI ha estado tomando medicamentos.";
                }else {
                    resSalud.setClickable(true);
                    tomamedicamentos = false;
                    medicamentos = "Usted NO ha estado tomando medicamentos.";
                }
                if(as.isProblemasemocionales() == true) {
                    resSalud.setClickable(true);
                    problemasemocionales = true;
                    resSalud.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    emocionalmente = "Usted SI ha tenido problemas que le pueden estar afectando emocionalmente actualmente.";
                } else {
                    resSalud.setClickable(true);
                    problemasemocionales = false;
                    emocionalmente = "Usted NO ha tenido problemas que le pueden estar afectando emocionalmente actualmente.";
                }
                if(as.isPadecimientosestres() == true) {
                    resSalud.setClickable(true);
                    padecimientoestres = true;
                    resSalud.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    estres = "Usted SI considera que ha tenido muchas situaciones de estrés a menudo";
                } else {
                    resSalud.setClickable(true);
                    padecimientoestres = false;
                    estres = "Usted NO considera que ha tenido muchas situaciones de estrés a menudo";
                }

                resSalud.setText("Usted considera que presenta los siguientes apartados que le pueden afectar a su vida diria: "+"\n\n" +
                        consulta+"\n\n"+medicamentos+"\n\n"+emocionalmente+"\n\n"+estres);
            }
        }

    }
public void Buscar (View view) {
    String habitos = null;
    String dia = null;
    String siestas = null;
    String sueño = null;
    String horadormir = null;
    String ocio = null;

    if(arrUsuario.isEmpty()) {
        Toast.makeText(this, "¡Registre usuarios primero!", Toast.LENGTH_LONG).show();
    } else {
        arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");

        boolean encontrado = false;
        int y = -1;
        if (id.getText().toString().trim().isEmpty()) {
            id.setError("Introduzca ID para continuar!");
            id.setFocusable(true);
        } else {


            for (int i = 0; i < arrUsuario.size(); i++) {

                if (Integer.parseInt(id.getText().toString()) == (arrUsuario.get(i).getId())) {
                    y = i;
                    encontrado = true;
                    resDatos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                    resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                    resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.vineta));
                    int x = 2; // poner punto despues de x digito
                    BigDecimal unscaled = new BigDecimal(arrUsuario.get(y).getEstatura());
                    BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);
                    float imc = (float) ((arrUsuario.get(y).getPeso()) / (Math.pow(scaled.floatValue(), 2)));
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
                    if (arrUsuario.get(y).getGenero() == 1) {
                        genero = "Género: Hombre";
                    }
                    if (arrUsuario.get(y).getGenero() == 2) {
                        genero = "Género: Mujer";
                    }

                    resDatos.setText("Nombre: " +arrUsuario.get(y).getNombre() +"."+"\n\n" + "Edad: " + arrUsuario.get(y).getEdad() +"."+ "\n\n" + genero +"."+
                            "\n\n" + "Peso: " + arrUsuario.get(y).getPeso() + "kg" +"."+ "\n\n" + "Estatura: " + arrUsuario.get(y).getEstatura() + "cm"+"."+ "\n\n" + resultadoIMC+".");

                    float caloriastotales = 0;
                    if (arrUsuario.get(y).getOpcionLitrosAgua() == 1) {
                        agua = "Consumo de agua al día: 1-2L";
                        aguanormal = false;
                    }
                    if (arrUsuario.get(y).getOpcionLitrosAgua() == 2) {
                        aguanormal = true;
                        agua = "Consumo de agua al día: 2-3L";
                    }
                    if (arrUsuario.get(y).getOpcionLitrosAgua() == 3) {
                        aguanormal = true;
                        agua = "Consumo de agua al día: +3L";
                    }
                    if (arrUsuario.get(y).getEdad()>=14 && arrUsuario.get(y).getOpcionLitrosAgua() == 1) {
                        aguanormal = false;
                        resAlimentos.setClickable(true);
                        resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                        agua = "Consumo de agua al día: 1-2L, para tu edad, deberias consumir mas agua!";
                    }
                    if(arrUsuario.get(y).getOpcionLitrosAgua() == 3) {
                        agua = "Consumo de agua al día: 1-2L, evita tomar mas de 3L de agua al día, pues puede ser dañino";
                    }
                    caloriastotales = arrUsuario.get(y).getDesayunoCalorias()+arrUsuario.get(y).getComidaCalorias()+arrUsuario.get(y).getCenaCalorias();

                    if(arrUsuario.get(y).getGenero() == 1 || arrUsuario.get(y).getGenero() == 2  && caloriastotales >=2000 && caloriastotales <=2500) {
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
                    if(arrUsuario.get(y).getGenero() == 2 && caloriastotales >=1590 && caloriastotales <=2000) {
                        ingestanormal = true;
                        resAlimentos.setClickable(true);
                        ingesta = "Su ingesta de calorías es saludable!, su total es : " +caloriastotales;
                    }

                    if (arrUsuario.get(y).getComidas() <=3) {
                        entrecomidasnormal = true;
                        resAlimentos.setClickable(true);
                        entrecomidas = "Veces que come entre comidas: "+arrUsuario.get(y).getComidas();
                    }
                    if (arrUsuario.get(y).getComidas() >3) {
                        entrecomidasnormal = false;
                        resAlimentos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                        resAlimentos.setClickable(true);
                        entrecomidas = "Veces que come entre comidas: "+arrUsuario.get(y).getComidas() +", come bastante entre comidas, lo cual no es recomendable!";
                    }
                    resAlimentos.setText(entrecomidas+"."+"\n\n"+
                            "Calorías por desayuno: "+arrUsuario.get(y).getDesayunoCalorias()+"."+"\n\n"+
                            "Calorías por comida: "+arrUsuario.get(y).getComidaCalorias()+"."+"\n\n"+
                            "Calorías por cena: "+arrUsuario.get(y).getCenaCalorias()+"."+"\n\n"+agua +"."+"\n\n"+
                            ingesta+".");

                    if (arrUsuario.get(y).getTiempoSiesta() == 0 && arrUsuario.get(y).getTiempoOcio() >= 8) {
                        resHabitos.setClickable(true);

                        TIENESIESTAS = 2;
                        TIENEOCIO = 1;
                        tienesiestas = false;
                        tieneocio = true;
                        siestas = "Usted no suele tener siestas y tiene mucho tiempo de ocio, lo cual puede afectar a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getTiempoSiesta() == 0) {
                        resHabitos.setClickable(true);

                        TIENESIESTAS = 2;
                        tienesiestas = false;
                        siestas = "Usted no suele tener siestas, considere tener un mínimo de 30 minutos si tiene mucho trabajo!";
                    }
                    if (arrUsuario.get(y).getTiempoSiesta() >= 1) {
                        resHabitos.setClickable(true);
                        tienesiestas = true;
                        TIENESIESTAS = 1;

                        siestas = "Usted suele tomar siestas de: " + arrUsuario.get(y).getTiempoSiesta() + "HR(S) , si trabaja mucho, considere mantener este tiempo para descanar!";
                    }
                    if (arrUsuario.get(y).getTiempoSueño() <= 7) {
                        resHabitos.setClickable(true);
                        duermebien = false;
                        DURMIOBIEN = 2;

                        sueño = "Usted suele dormir : " + arrUsuario.get(y).getTiempoSueño() + " HR(S), lo cual es poco, considere dormir más!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getTiempoSueño() >= 8) {
                        resHabitos.setClickable(true);
                        duermebien = true;
                        DURMIOBIEN = 1;

                        sueño = "Usted suele dormir : " + arrUsuario.get(y).getTiempoSueño() + " HR(S), lo cual es considerado lo suficiente para tener buen descanso!";
                    }

                    if (arrUsuario.get(y).getHoraDormir() >= 11) {
                        resHabitos.setClickable(true);
                        seacuestatemprano = false;
                        SEACUESTATEMPRANO = 2;

                        horadormir = "Usted suele dormirse a las : " + arrUsuario.get(y).getHoraDormir() + ", lo cual es bastante tarde y no recomendable!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getHoraDormir() < 11) {
                        resHabitos.setClickable(true);

                        SEACUESTATEMPRANO = 1;
                        seacuestatemprano = true;
                        horadormir = "Usted suele dormirse a las : " + arrUsuario.get(y).getHoraDormir() + ", lo cual es temprano y saludable!";
                    }


                    if (arrUsuario.get(y).getDiaSemana() == 1) {
                        resHabitos.setClickable(true);

                        dia = "Dias en los que suele realizar las actividades registradas: Lunes a Viernes";
                    }
                    if (arrUsuario.get(y).getDiaSemana() == 2) {
                        resHabitos.setClickable(true);

                        dia = "Dias en los que suele realizar las actividades registradas: Sabado a Domingo";
                    }

                    if (arrUsuario.get(y).getOcio() == 1 && arrUsuario.get(y).getSalud() == 1 && arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);

                        EQUILIBRIO = 1;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio,Salud y Trabajo ó Esutudio";
                    }
                    if (arrUsuario.get(y).getOcio() == 1 && arrUsuario.get(y).getSalud() == 0 && arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);
                        tienesalud = false;
                        PROBLEMASALUD = 1;
                        tienesalud = false;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio y Trabajo " + "\n" + " Nota: intente dedicarle tiempo a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getOcio() == 1 ) {
                        resHabitos.setClickable(true);
                        tienesalud = false;
                        PROBLEMASALUD = 1;
                        tienesalud = false;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio  " + "\n" + " Nota: intente dedicarle tiempo a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);
                        tienesalud = false;
                        PROBLEMASALUD = 1;
                        tienesalud = false;

                        habitos = "Sus hábitos en sus actividades destacan en : Trabajo  " + "\n" + " Nota: intente dedicarle tiempo a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getSalud() == 1 ) {
                        resHabitos.setClickable(true);
                        tienesalud = false;
                        PROBLEMASALUD = 2;
                        tienesalud = true;

                        habitos = "Sus hábitos en sus actividades destacan en : Salud  ";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getOcio() == 1 && arrUsuario.get(y).getSalud() == 0 && arrUsuario.get(y).getTrabajo() == 0) {
                        resHabitos.setClickable(true);

                        tienesalud = false;
                        PROBLEMASALUD = 1;
                        tienesalud = false;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio " + "\n" + " Nota: intente dedicarle tiempo a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getOcio() == 1 && arrUsuario.get(y).getSalud() == 1 && arrUsuario.get(y).getTrabajo() == 0) {
                        resHabitos.setClickable(true);

                        EQUILIBRIO = 1;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio y Salud";
                    }
                    if (arrUsuario.get(y).getOcio() == 0 && arrUsuario.get(y).getSalud() == 1 && arrUsuario.get(y).getTrabajo() == 0) {
                        resHabitos.setClickable(true);

                        EQUILIBRIO = 1;

                        habitos = "Sus hábitos en sus actividades destacan en : Salud";
                    }
                    if (arrUsuario.get(y).getOcio() == 0 && arrUsuario.get(y).getSalud() == 0 && arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);

                        PROBLEMAOCIO = 1;

                        habitos = "Sus hábitos en sus actividades destacan en : Trabajo ó Estudio " + "\n" + " Nota: intente también darse tiempo a usted mismo";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getOcio() == 1 && arrUsuario.get(y).getSalud() == 0 && arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);
                        tieneocio=true;
                        PROBLEMASALUD = 1;
                        tienesalud = false;

                        habitos = "Sus hábitos en sus actividades destacan en : Ocio y Trabajo ó Estudio" + "\n" + " Nota: intente dedicarle tiempo a su salud!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getOcio() == 0 && arrUsuario.get(y).getSalud() == 1 && arrUsuario.get(y).getTrabajo() == 1) {
                        resHabitos.setClickable(true);

                        EQUILIBRIO = 1;

                        habitos = "Sus hábitos en sus actividades destacan en : Salud y Trabajo ó Estudio";
                    }
                    if (arrUsuario.get(y).getTiempoOcio() > 3) {
                        resHabitos.setClickable(true);

                        PROBLEMAOCIO = 1;

                        ocio = "Su tiempo de ocio : " + arrUsuario.get(y).getTiempoOcio() + " HR(S) es considerado alto, considere bajarlo y usar ese tiempo en su salud, estudio o trabajo!";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }
                    if (arrUsuario.get(y).getTiempoOcio() > 0 && arrUsuario.get(y).getTiempoOcio() < 3) {
                        resHabitos.setClickable(true);

                        PROBLEMAOCIO = 2;
                        tieneocio = true;

                        ocio = "Su tiempo de ocio : " + arrUsuario.get(y).getTiempoOcio() + " HR(S) es considerado bajo, lo cual no le afecta directamente";
                    }
                    if (arrUsuario.get(y).getTiempoOcio() == 0) {
                        resHabitos.setClickable(true);

                        tieneocio = false;

                        ocio = "Su tiempo de ocio es 0, Considere tener un poco de tiempo para usted mismo y divertirse no todo es el trabajo o el estudio";
                        resHabitos.setBackground(ContextCompat.getDrawable(this, R.drawable.opcional));
                    }

                    resHabitos.setText(dia + "." + "\n\n" + horadormir + "." + "\n\n" + sueño + "." + "\n\n" + habitos + "." + "\n\n" + ocio + "." + "\n\n" + siestas + ".");
                }
            }

            if (encontrado == false) {
                Toast.makeText(this, "¡No se encontró ningun registro de usuario que coincida con ese ID!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Se cargarón datos del usuario: " + arrUsuario.get(y).getNombre() + ", con ID: "+ arrUsuario.get(y).getId(), Toast.LENGTH_LONG).show();
            }
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

                if(arrUsuario!=null && arrUsuario.isEmpty()== false) {
                    arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");

                }
                intent = new Intent(getApplicationContext(), Datos.class);
                    intent.putExtra("arreglo",arrUsuario);
                startActivity(intent);
                break;

            case R.id.itmAlimentacion:
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                dat = (datosclase) getIntent().getSerializableExtra("datos");
                Intent alimentacion = new Intent(getApplicationContext(), Alimentacion.class);
                alimentacion.putExtra("datos",dat);
                alimentacion.putExtra("arreglo",arrUsuario);
                startActivity(alimentacion);
                break;

            case R.id.itmHabitos:
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                dat = (datosclase) getIntent().getSerializableExtra("datos");
                alim = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
                Intent habitos = new Intent(getApplicationContext(), Habitos.class);
                habitos.putExtra("datos",dat);
                habitos.putExtra("alimentacion",alim);
                habitos.putExtra("arreglo",arrUsuario);
                startActivity(habitos);
                break;

            case R.id.itmSalud:
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                dat = (datosclase) getIntent().getSerializableExtra("datos");
                alim = (alimentacionclase) getIntent().getSerializableExtra("alimentacion");
                hab = (habitosclase ) getIntent().getSerializableExtra("habitos");
                Intent atencionsalud = new Intent(getApplicationContext(), atencionsalud.class);
                atencionsalud.putExtra("datos",dat);
                atencionsalud.putExtra("alimentacion",alim);
                atencionsalud.putExtra("habitos",hab);
                atencionsalud.putExtra("arreglo",arrUsuario);
                startActivity(atencionsalud);
                break;
            case R.id.itmGuardarIMC:
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                dat = (datosclase) getIntent().getSerializableExtra("datos");
                Intent guardar = new Intent(getApplicationContext(), GuardarIMC.class);
                guardar.putExtra("datos",dat);
                guardar.putExtra("arreglo",arrUsuario);
                startActivity(guardar);
                break;

            case R.id.itmCargarIMC:
                arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
                intent = new Intent(getApplicationContext(), CargarIMC.class);
                intent.putExtra("arreglo",arrUsuario);
                startActivity(intent);
                break;
            case R.id.itmCerrarSesion:
                cerrarSesion();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void Vistaatencionsaludclase(View view) {

        if(consultamedico == true) {
            medico = 1;
        } else {
            medico = 2;
        }
        if(tomamedicamentos == true) {
            medicamentos = 1;
        } else {
            medicamentos = 2;
        }
        if(problemasemocionales == true) {
            emocionales = 1;
        } else{
            emocionales = 2;
        }
        if(padecimientoestres == true) {
            estres = 1;
        } else {
            estres = 2;
        }

        Intent intent = new Intent(this, ResultadosSalud.class);
        intent.putExtra("medico",medico);
        intent.putExtra("medicamentos",medicamentos);
        intent.putExtra("emocionales",emocionales);
        intent.putExtra("estres",estres);
        startActivity(intent);


    }
    public void cerrarSesion()
    {
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent layout = new Intent(this, ActivityLogin.class);
        layout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(layout);
        finish();
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