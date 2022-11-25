package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Resultados extends AppCompatActivity {
    int contador = 0;
    TextView res;
    LottieAnimationView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        res  = findViewById(R.id.Resultados);
        l = findViewById(R.id.animacion);

        l.animate().setDuration(2700).setStartDelay(2900);
        contador  = (int) getIntent().getSerializableExtra("peso");

        if (contador == 1) {
            l.setAnimation(R.raw.peso);
            res.setText("El bajo peso (BP) se puede definir como un peso insuficiente en el paciente, el cual se encuentra por debajo de los valores de referencia del peso correcto entre un 15-20%.  \n" +
                    "\n" +
                    "El BP o peso insuficiente es un estado físico al que no se le presta especial atención relativa, en contraposición a su enfermedad opuesta, el sobrepeso u obesidad. La realidad es que el BP, al igual que el exceso de peso lleva comorbilidades asociadas incluso llegando a causar la muerte en estados de desnutrición severos.");
        }
        if (contador == 2) {
            l.setAnimation(R.raw.peso);
            res.setText("Se considera un peso saludable  aquel que nos permite mantenernos en un buen estado de salud y calidad de vida.  También se entiende como  los valores de peso, dentro de los cuales, no existe riesgo para la salud de la persona.  \n" +
                    " \n" +
                    "Para saber si estás en un peso saludable, existen algunos métodos confiables. Uno es la determinación de tu Índice de masa corporal (IMC), que describe la relación entre peso y estatura. Para calcular el  IMC se necesita conocer el peso y la estatura y se aplica una  sencilla fórmula matemática. Este índice permite una mejor estimación de la grasa corporal y no solamente del peso en kilogramos.");
        }
        if (contador == 3) {
            l.setAnimation(R.raw.peso);
            res.setText("El sobrepeso y la obesidad se definen como una acumulación anormal o excesiva de grasa que puede ser perjudicial para la salud."+"\n"+"El índice de masa corporal (IMC) es un indicador simple de la relación entre el peso y la talla que se utiliza frecuentemente para identificar el sobrepeso y la obesidad en los adultos. Se calcula dividiendo el peso de una persona en kilos por el cuadrado de su talla en metros (kg/m2).");
        }
        if (contador == 4) {
            l.setAnimation(R.raw.peso);
            res.setText("Existen tres tipos de obesidad:\n" +
                    "\n" +
                    "Clase 1: IMC de 30 a menos de 35.\n" +
                    "Clase 2: IMC de 35 a menos de 40.\n" +
                    "Clase 3: IMC de 40 o superior. La Clase 3 se considera \"obesidad grave.\"\n" + "\n"+
                    "El riesgo de muchos problemas de salud es mayor para los adultos que tienen grasa corporal en exceso y que encajan dentro de los grupos con sobrepeso.\n" +
                    "\n" +
                    "CAMBIAR EL ESTILO DE VIDA\n" +
                    "\n" +
                    "Un estilo de vida activo y mucho ejercicio, junto con una alimentación saludable, es la forma más segura de bajar de peso. La pérdida de peso incluso moderada puede mejorar su salud. Obtenga apoyo de familiares y amigos.\n" +
                    "\n" +
                    "Su objetivo principal debe ser aprender nuevas formas de comer saludable e incorporarlas a su rutina diaria.\n" +
                    "\n" +
                    "A muchas personas les resulta difícil cambiar sus hábitos y comportamientos alimentarios. Usted puede haber practicado algunos hábitos durante tanto tiempo que ni siquiera sabe que son malsanos o los practica sin pensar. Usted necesita estar motivado para hacer cambios de estilo de vida. Convierta el cambio de comportamiento en parte de su vida a largo plazo. Sepa que se necesita tiempo para hacer y mantener un cambio en su estilo de vida.");
        }
    }
}