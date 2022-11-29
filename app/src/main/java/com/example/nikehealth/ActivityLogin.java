package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nikehealth.clases.Usuario;
import com.example.nikehealth.clases.usuariologin;

import java.util.ArrayList;

public class ActivityLogin extends AppCompatActivity {

    private EditText email,contraseña;
    private CheckBox guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.CORREO);
        contraseña = findViewById(R.id.CONTRASEÑA);
        guardar = findViewById(R.id.DATOS);

    }

    public void IngresarMenu(View view) {
        usuariologin usr = new usuariologin();
        usr.setCorreo(email.getText().toString());
        usr.setContraseña(contraseña.getText().toString());
        usr.setRegistrado(true);
        String nombre="kevinmahecha@outlook.com",contraseña="12345";
        String nombre1="kevinmahecha@outlook.com",contraseña1="12345";
        String nombre2="kevinmahecha@outlook.com",contraseña2="12345";

        Toast.makeText(this,"Contra : "+usr.getContraseña(),Toast.LENGTH_SHORT).show();

        if (usr.getCorreo().equals(nombre) && usr.getContraseña().equals(contraseña) || usr.getCorreo().equals(nombre1) && usr.getContraseña().equals(contraseña1)
        || usr.getCorreo().equals(nombre2) && usr.getContraseña().equals(contraseña2)) {
            if(guardar.isChecked()) {
                guardarPreferenccias(usr);
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

            Toast.makeText(this,"Bienvenido : "+usr.getCorreo(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Error, no hay usuarios con ese nombre o contraseña! ",Toast.LENGTH_SHORT).show();
        }

    }
    public void guardarPreferenccias(usuariologin u) {
        SharedPreferences preferences = this.getSharedPreferences("User.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("usuario",u.getCorreo());
        editor.putString("contraseña",u.getContraseña());
        editor.putBoolean("Registrada",u.getRegistrado());
        editor.apply();

    }
    public void SalirMneu(View view){
        finish();
    }
}