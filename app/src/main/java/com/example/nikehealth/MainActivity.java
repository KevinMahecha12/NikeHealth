package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.nikehealth.clases.usuariologin;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    //Objeto para asociar componentes Multiline text

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
        usuariologin usr = new usuariologin();

        TimerTask tarea = new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent;
                if (nuevoUsuario())
                {
                    intent = new Intent(getApplicationContext(), Menu.class);
                } else
                {
                    intent = new Intent(getApplicationContext(), ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);




    }

    private boolean nuevoUsuario()
    {
        SharedPreferences preferences = this.getSharedPreferences("User.dat", MODE_PRIVATE);
        return preferences.getBoolean("Registrada", false);
    }
}