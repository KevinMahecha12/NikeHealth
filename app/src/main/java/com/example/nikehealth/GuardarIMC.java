package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikehealth.clases.Usuario;
import com.example.nikehealth.clases.cargarIMC;
import com.example.nikehealth.clases.datosIMC;
import com.example.nikehealth.clases.datosclase;
import com.example.nikehealth.clases.Usuario;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

public class GuardarIMC extends AppCompatActivity {

    TextView imcserial;
    datosclase dat = new datosclase();
    datosIMC di = new datosIMC();
    cargarIMC ci = new cargarIMC(null);
    String resultadoIMC = null;
    String genero  = null;
    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_imc);
        imcserial = findViewById(R.id.IMC);

        dat = (datosclase) getIntent().getSerializableExtra("datos");
        if(dat== null) {
            imcserial.setText("Registre sus datos primero para poder guardar el IMC");
        } else {

            int x = 2; // poner punto despues de x digito
            BigDecimal unscaled = new BigDecimal(dat.getEstatura());
            BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);
            float imc = (float) ((dat.getPeso()) / (Math.pow(scaled.floatValue(), 2)));

            if (imc < 18.5) {
                // peso insuficiente
                resultadoIMC = "Su IMC es : " + imc + ", su peso es insuficiente";

            }
            if (imc >= 18.5 && imc <= 24.9) {
                //peso normal o saludable
                resultadoIMC = "Su IMC es : " + imc + ", su peso esta normalmente saludable!";
            }
            if (imc >= 25.0 && imc <= 29.9) {
                //sobrepeso
                resultadoIMC = "Su IMC es : " + imc + ", usted sufre de sobrepeso";
            }
            if (imc >= 30) {
                //obesidad
                resultadoIMC = "Su IMC es : " + imc + ", usted sufre de obesidad";
            }


            if (dat.getGenero() == 1) {
                genero = "Género: Hombre";
            }
            if (dat.getGenero() == 2) {
                genero = "Género: Mujer";
            }


            imcserial.setText("Nombre: " + dat.getNombre() +"."+"\n\n" + "Edad: " + dat.getEdad() +"."+ "\n\n" + genero +"."+
                    "\n\n" + "Peso: " + dat.getPeso() + "kg" +"."+ "\n\n" + "Estatura: " + dat.getEstatura() + "cm"+"."+ "\n\n" + resultadoIMC+".");
            ci.setImc(imc);
            ci.setNombre(dat.getNombre());
            ci.setDatosIMC("Nombre: " + ci.getNombre() +"."+"\n\n" + "Edad: " + dat.getEdad() +"."+ "\n\n" + genero +"."+
                    "\n\n" + "Peso: " + dat.getPeso() + "kg" +"."+ "\n\n" + "Estatura: " + dat.getEstatura() + "cm"+"."+ "\n\n" + resultadoIMC+".");
        }
    }
    public void GuardarIMC(View view){
        if(dat== null) {
            Toast.makeText(this,"PRIMERO REGISTRE SUS DATOS PARA GUARDAR EL IMC!", Toast.LENGTH_SHORT).show();
        } else {
            try
            {
                //Objeto que asocia al archivo especificado para escritura
                OutputStreamWriter archivoInterno = new OutputStreamWriter(openFileOutput("IMC.txt", Activity.MODE_PRIVATE));
                archivoInterno.write(ci.getDatosIMC());
                archivoInterno.flush();
                archivoInterno.close();
            }

            catch (IOException e)
            {
                Toast.makeText(this,"Error al escribir en el archivo", Toast.LENGTH_SHORT).show();
            }
            //Modificacion de informacion almacenada
            Intent intent;
            intent = new Intent(getApplicationContext(), Menu.class);
            Toast.makeText(this,"IMC guardado correctamente!", Toast.LENGTH_SHORT).show();
            //Limpiar el componente de texto
            if(arrUsuario!=null) {
                intent.putExtra("arreglo",arrUsuario);

                startActivity(intent);
            }
        }

    }
    public void regresarimc(View view) {
        finish();
    }
}