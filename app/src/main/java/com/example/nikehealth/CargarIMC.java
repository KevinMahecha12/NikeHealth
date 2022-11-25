package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikehealth.clases.datosclase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CargarIMC extends AppCompatActivity {

    TextView imccargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_imc);
        imccargar = findViewById(R.id.IMCcargar);

    }

    public void abrirArchivo(View v)
    {

        //Obtener la lista de los archivos internos de la aplicacion
        String archivos[] = fileList();
        //Validar la existencia del archivo interno
        if(existeArchivo(archivos, "IMC.txt"))
        {

            try
            {
                //Objeto que asocia al archivo especificado, para lectura
                InputStreamReader archivoInterno = new InputStreamReader(openFileInput("IMC.txt"));
                imccargar.setVisibility(View.VISIBLE);
                //Objeto que relaciona el archivo
                BufferedReader leerArchivo = new BufferedReader(archivoInterno);

                //Lectura del archivo y colocar en una variable de tipo cadena
                String Linea = leerArchivo.readLine();

                //Variable que guardará la informacion leida desde el archivo
                String textoLeido = "";

                //Ciclo para leer el contenido del archivo
                while(Linea != null)
                {
                    textoLeido += Linea + '\n';
                    Linea = leerArchivo.readLine();
                }

                //Cerrar el flujo del archivo
                leerArchivo.close();
                //Cerrar el archivo
                archivoInterno.close();

                //Se coloca() la informacion del archivo en el componente Multiline text
                imccargar.setText(textoLeido);
            }
            catch (IOException e)
            {
                Toast.makeText(getApplicationContext(),"No hay IMC registrados!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"No hay IMC registrados!",Toast.LENGTH_SHORT).show();
        }
    }//AbrirArchivo
    private boolean existeArchivo(String[] archivos, String s)
    {
        //Recorrido de la lista de nombres archivos internos de la aplicacion
        for (int i= 0; i < archivos.length; i++)
        {
            //Se busca el archivo especificado
            if (s.equals(archivos[i])) ;
            //En caso de existir, termina el ciclo y retorna verdadero
            return true;
        }
        //En caso de nbo existir un rewcorrido el archivo de archivos, retorna falso
        return false;
    }
    public void regresarimc(View view) {
        finish();
    }
}