package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ResultadosAlimentacion extends AppCompatActivity {
    int contador = 0;
    int  agua = 0;
    int entrecomidas = 0;
    TextView res;
    LottieAnimationView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_alimentacion);

        res  = findViewById(R.id.Resultados);
        l = findViewById(R.id.animacion);
        l.animate().setDuration(2700).setStartDelay(2900);

        contador  = (int) getIntent().getSerializableExtra("alimentacion");
        agua  = (int) getIntent().getSerializableExtra("agua");
        entrecomidas = (int) getIntent().getSerializableExtra("entrecomidas");

        if (contador == 1 && agua == 1) {
            l.setAnimation(R.raw.caloriasbuenas);
            res.setText("Tu ingesta de calorias es saludable! "+"\n\n\n"+"La Organización Mundial de la Salud (OMS) establece un cálculo genérico para conocer la cantidad de calorías diarias que necesita una persona: entre 1600 y 2000 calorías al día para las mujeres, y para los hombres entre 2000 y 2500.");
        }
        if (contador == 2 || entrecomidas == 2 && agua == 1 ) {
            l.setAnimation(R.raw.caloriasmalas);
            res.setText("Sólo por estar vivos, gastamos energía. A este consumo se le conoce como metabolismo basal.\n" +
                    "\n" +
                    "Este término hace referencia al número de calorías que gastamos en funciones fisiológicas como respirar, comer, dormir, además de todas las acciones que realizan nuestros órganos internos. Es decir, son las calorías que consumimos en reposo.\n" +
                    "\n" +
                    "Puedes calcular tu metabolismo basal con esta fórmula:\n" +
                    "\n" +
                    "Los hombres necesitan 1 caloría por kilogramo de peso y hora:\n" +
                    "Peso en Kg x 1 caloría x 24 horas\n" +
                    "Las mujeres necesitan 0,9 calorías por kilogramo de peso y hora:\n" +
                    "Peso en Kg x 0,9 calorías x 24 horas" + "\n"+
                    "La gente que engorda lo hace porque ingiere más alimentos, es decir más energía (calorías diarias), de lo que consume. Al contrario, sucede con la gente que adelgaza, es decir, ingiere menos calorías al día de las que consume.");
        }
        if (contador == 2 && agua == 2  ) {
            l.setAnimation(R.raw.agua);
            res.setText("Tu ingesta de calorias es muy alta y tomas muy poca agua! "+"\n\n\n"+"Sólo por estar vivos, gastamos energía. A este consumo se le conoce como metabolismo basal.\n" +
                    "\n" +
                    "Este término hace referencia al número de calorías que gastamos en funciones fisiológicas como respirar, comer, dormir, además de todas las acciones que realizan nuestros órganos internos. Es decir, son las calorías que consumimos en reposo.\n" +
                    "\n" +
                    "La gente que engorda lo hace porque ingiere más alimentos, es decir más energía (calorías diarias), de lo que consume. Al contrario, sucede con la gente que adelgaza, es decir, ingiere menos calorías al día de las que consume." + "\n\n"+"Beber poca agua"+"\n"+"Aproximadamente el 60 % de nuestro cuerpo se compone de agua. En este sentido, beber suficiente líquido es vital porque de lo contrario perdemos energía, nuestra piel se pone seca y comenzamos a experimentar efectos cada vez más serios que pueden llegar a ocasionar que nuestro organismo deje de funcionar por completo.\n" +
                    "\n" +
                    "Es decir, las consecuencias de no beber agua durante un largo período pueden ser graves. La deshidratación crónica, entre otros padecimientos, suele aparecer y poner en peligro la salud de la persona.");
        }
        if (contador == 1 && agua == 2) {
            l.setAnimation(R.raw.agua);
            res.setText("Aproximadamente el 60 % de nuestro cuerpo se compone de agua. En este sentido, beber suficiente líquido es vital porque de lo contrario perdemos energía, nuestra piel se pone seca y comenzamos a experimentar efectos cada vez más serios que pueden llegar a ocasionar que nuestro organismo deje de funcionar por completo.\n" +
                    "\n" +
                    "Es decir, las consecuencias de no beber agua durante un largo período pueden ser graves. La deshidratación crónica, entre otros padecimientos, suele aparecer y poner en peligro la salud de la persona.");
        }
        if (contador == 1 && agua == 1 && entrecomidas == 1) {
            l.setAnimation(R.raw.todobien);
            res.setText("Usted esta sano!, bebe y ingiere calorías de forma correcta en su dia!");
        }
        if(entrecomidas == 2) {
            l.setAnimation(R.raw.caloriasmalas);
            res.setText("Los refrigerios o colaciones son alimentos que se consumen entre las principales comidas del día (desayuno, comida y cena) y forman parte de una alimentación saludable.\n" +
                    "\n" +
                    "Los expertos en nutrición recomiendan consumir cinco comidas al día, las tres principales (desayuno, comida y cena) y dos refrigerios entre cada una de ellas, uno entre el desayuno y la comida y otro más entre la comida y la cena.\n" +
                    "\n" +
                    "La colación o refrigerio es un alimento ligero con poca grasa y con menos del 10% (160- 200 kcal) del total de calorías que se consumen en el día. Este alimento se consume entre comidas y no debe substituir a las tres principales del día.");
        }
        if (entrecomidas == 2 && agua == 2) {
            res.setText("Los refrigerios o colaciones son alimentos que se consumen entre las principales comidas del día (desayuno, comida y cena) y forman parte de una alimentación saludable.\n" +
                            "\n" +
                            "Los expertos en nutrición recomiendan consumir cinco comidas al día, las tres principales (desayuno, comida y cena) y dos refrigerios entre cada una de ellas, uno entre el desayuno y la comida y otro más entre la comida y la cena.\n" +
                            "\n" +
                            "La colación o refrigerio es un alimento ligero con poca grasa y con menos del 10% (160- 200 kcal) del total de calorías que se consumen en el día. Este alimento se consume entre comidas y no debe substituir a las tres principales del día. "+"\n\n"+"Beber poca agua"+"\n"+"Aproximadamente el 60 % de nuestro cuerpo se compone de agua. En este sentido, beber suficiente líquido es vital porque de lo contrario perdemos energía, nuestra piel se pone seca y comenzamos a experimentar efectos cada vez más serios que pueden llegar a ocasionar que nuestro organismo deje de funcionar por completo.\n" +
                    "\n" +
                    "Es decir, las consecuencias de no beber agua durante un largo período pueden ser graves. La deshidratación crónica, entre otros padecimientos, suele aparecer y poner en peligro la salud de la persona.");
        }

    }
}