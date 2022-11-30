package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.List;

public class GuardarIMC extends AppCompatActivity {

    Button guardar;
    datosclase dat = new datosclase();
    datosIMC di = new datosIMC();
    cargarIMC ci = new cargarIMC(null);
    String resultadoIMC = null;
    String genero  = null;
    ArrayList<String> ListDatos;
    RecyclerView re;
    EditText id;

    private ArrayList<Usuario> arrUsuario = new ArrayList<Usuario>(10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_imc);

        guardar = findViewById(R.id.GUARDAR);
        re = findViewById(R.id.RECYCLER);
        re.setLayoutManager(new LinearLayoutManager(this));
        id = findViewById(R.id.ID);
        arrUsuario = (ArrayList<Usuario>) getIntent().getSerializableExtra("arreglo");
        ListDatos= new ArrayList<String>();
        dat = (datosclase) getIntent().getSerializableExtra("datos");


    }
    public void GuardarIMC(View view){
        if(arrUsuario== null) {
            Toast.makeText(this,"PRIMERO REGISTRE SUS DATOS PARA GUARDAR EL IMC!", Toast.LENGTH_SHORT).show();
        } else {
            try
            {
                //Objeto que asocia al archivo especificado para escritura
                OutputStreamWriter archivoInterno = new OutputStreamWriter(openFileOutput("IMC.txt", Activity.MODE_PRIVATE));
                archivoInterno.append(ci.getDatosIMC());
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
            arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
            intent.putExtra("arreglo",arrUsuario);
            startActivity(intent);
            //Limpiar el componente de texto

        }

    }
    public void regresarimc(View view) {
        Intent intent = new Intent(this, Menu.class);
        arrUsuario = (ArrayList<Usuario>)getIntent().getSerializableExtra("arreglo");
        intent.putExtra("arreglo",arrUsuario);
        startActivity(intent);
    }
    public void Buscar (View view) {
        String habitos = null;
        String dia = null;
        String siestas = null;
        String sueño = null;
        String horadormir = null;
        String ocio = null;

        if (arrUsuario == null) {
            Toast.makeText(this, "¡Registre usuarios primero!", Toast.LENGTH_LONG).show();
        } else {
            arrUsuario = (ArrayList<Usuario>) getIntent().getSerializableExtra("arreglo");
            boolean encontrado = false;
            int y = -1;
            if (id.getText().toString().isEmpty()) {
                Toast.makeText(this, "¡No se ha introducido nada en los campo de código , no se puede buscar nada!", Toast.LENGTH_LONG).show();
                id.setError("Rellene el ID");
                id.setFocusable(true);
            } else {

                for (int i = 0; i < arrUsuario.size(); i++) {

                    if (Integer.parseInt(id.getText().toString()) == (arrUsuario.get(i).getId())) {
                        y = i;
                        encontrado = true;
                        guardar.setText("Se guardará el ID: "+arrUsuario.get(i).getId());
                        int x = 2; // poner punto despues de x digito
                        BigDecimal unscaled = new BigDecimal(arrUsuario.get(y).getEstatura());
                        BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);
                        float imc = (float) ((arrUsuario.get(y).getPeso()) / (Math.pow(scaled.floatValue(), 2)));

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


                        if (arrUsuario.get(y).getGenero() == 1) {
                            genero = "Género: Hombre";
                        }
                        if (arrUsuario.get(y).getGenero() == 2) {
                            genero = "Género: Mujer";
                        }


                        ci.setImc(imc);
                        ci.setNombre(arrUsuario.get(y).getNombre());
                        ci.setDatosIMC("Nombre: " + arrUsuario.get(y).getNombre() + "." + "\n\n" + "Edad: " + arrUsuario.get(y).getEdad() + "." + "\n\n" + genero + "." +
                                "\n\n" + "Peso: " + arrUsuario.get(y).getPeso() + "kg" + "." + "\n\n" + "Estatura: " + arrUsuario.get(y).getEstatura() + "cm" + "." + "\n\n" + resultadoIMC + ".");

                        ListDatos.add("ID: "+arrUsuario.get(y).getId() + "\n\n" +"Nombre: " + arrUsuario.get(y).getNombre() + "." + "\n\n" + "Edad: " + arrUsuario.get(y).getEdad() + "." + "\n\n" + genero + "." +
                                "\n\n" + "Peso: " + arrUsuario.get(y).getPeso() + "kg" + "." + "\n\n" + "Estatura: " + arrUsuario.get(y).getEstatura() + "cm" + "." + "\n\n" + resultadoIMC + "." + "\n\n");
                        adaptadorimc adaptadorimc = new adaptadorimc(ListDatos);
                        re.setAdapter(adaptadorimc);


                    }

                }
                if (encontrado == false) {
                    Toast.makeText(this, "¡No se encontró ningun registro de usuario que coincida con ese ID!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Se encontró a " + arrUsuario.get(y).getNombre(), Toast.LENGTH_SHORT).show();
                }
            }


        }
    }

}